package game.managers;

import game.entities.*;
import game.entities.identities.PieceType;

public class StandardBoardManager extends BoardManager {

	public StandardBoardManager(GameManager gm) {
		
		super(gm);
		
		width = 8;
		length = 8;
		
		data = new String[width][length];
		
		clearAll();
		
	}
	
	/**
	 * Updated to include dealing with EnPassant. 
	 */
	public void updatePosition(String id, int x, int y) {
		
		if(pm.get(id).getType() == PieceType.PAWN) {
			
			removeEnPassant(id, x, y);
			
		}
		
		super.updatePosition(id, x, y);
		
	}

	/**
	 * If a spot is occupied by an EnPassant piece, removes it when captured by an opposing player.
	 * 
	 * @param id
	 * @param x
	 * @param y
	 */
	private void removeEnPassant(String id, int x, int y) {
		
		if(!isEmpty(x, y) && pm.get(get(x,y)).getType() == PieceType.ENPASSANT) {
			
			EnPassant currPiece = (EnPassant) pm.get(get(x, y));
			
			removeEnPassantParent(id, currPiece);
			remove(x, y);
			
		}
		
	}

	private void removeEnPassantParent(String id, EnPassant currPiece) {
		
		if(currPiece.getParentOwner() != pm.get(id).getOwner()) {
			
			GamePiece parentPiece = pm.get(currPiece.getParentId());
			remove(parentPiece.getX(), parentPiece.getY());
			
		}
		
	}
	
}
