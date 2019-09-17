package game.managers;

import java.util.ArrayList;
import java.util.Iterator;

import game.entities.EnPassant;
import game.entities.GamePiece;
import game.entities.identities.MessageConstants;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class StandardTurnManager implements TurnManager {

	protected int currTurn;
	protected PlayerType currPlayer;
	protected String currPieceId;
	protected GameManager gm;
	protected PieceManager pm;
	protected BoardManager bm;
	protected CheckmateManager cm;
	protected NotificationManager nm;
	
	public StandardTurnManager(GameManager gm) {
		
		CheckmateManager cm2 = gm.getCheckmateManager();
		
		currTurn = 1;
		currPlayer = PlayerType.WHITE;
		currPieceId = "";
		this.gm = gm;
		this.pm = gm.getPieceManager();
		this.bm = gm.getBoardManager();
		this.cm = cm2;
		this.nm = gm.getNotificationManager();
		
	}
	
	public void setCurrentPiece(String id) {
		
		System.out.println("Current piece is now " + id);
		currPieceId = id;
		
	}
	
	public String getCurrentPiece() {
		
		return currPieceId;
		
	}

	@Override
	public void nextTurn() {

		currTurn++;
		
		if(currPlayer == PlayerType.WHITE) {
			
			currPlayer = PlayerType.BLACK;
			
		} else {
			
			currPlayer = PlayerType.WHITE;
			
		}
		
		verifyCheckmate();
		clearEnPassantPieces();
		
	}

	public void clearEnPassantPieces() {
		
		ArrayList<String> keys = pm.getActiveKeys(PlayerType.UNALIGNED);
		Iterator<String> keyIterator = keys.iterator();
		
		while(keyIterator.hasNext()) {
			
			GamePiece currPiece = pm.get(keyIterator.next());
			
			if(currPiece.getType() == PieceType.ENPASSANT 
					&& ((EnPassant) currPiece).getParentOwner() == currPlayer) {
				
				bm.remove(currPiece.getX(), currPiece.getY());
				
			}
			
		}
		
	}

	public void verifyCheckmate() {
		if(cm.verifyCheckmate(currPlayer)) {
			
			if(currPlayer == PlayerType.WHITE) {
				
				nm.readyNotification(MessageConstants.blackWins);
				
			} else if(currPlayer == PlayerType.BLACK) {
				
				nm.readyNotification(MessageConstants.whiteWins);
				
			}
			
		} else if(cm.verifyCheck(currPlayer)) {
			
			if(currPlayer == PlayerType.WHITE) {
				
				nm.readyNotification(MessageConstants.whiteCheck);
				
			} else if(currPlayer == PlayerType.BLACK) {
				
				nm.readyNotification(MessageConstants.blackCheck);
				
			}
			
		}
	}

	@Override
	public int getCurrentTurn() {
		
		return currTurn;
		
	}

	@Override
	public PlayerType getCurrentPlayer() {
		
		return currPlayer;
		
	}

}
