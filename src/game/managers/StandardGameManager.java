package game.managers;

import game.entities.EnPassant;
import game.entities.factories.PieceFactory;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;
import game.entities.identities.StandardConstants;

public class StandardGameManager extends GameManager {

	private static StandardGameManager instance = null;
	
	public static StandardGameManager getInstance() {
		
		if(instance == null) {
			
			instance = new StandardGameManager();
			
		}
		
		return instance;
		
	}
	
	public StandardGameManager() {
		
		super();
		pm = StandardPieceManager.getInstance();
		bm = new StandardBoardManager(this);
		
		mm = new StandardMovementManager(this);
		cm = new StandardCheckmateManager(this);
		mm.setCheckmateManager(cm);
		
		nm = new StandardNotificationManager();
		tm = new StandardTurnManager(this);
		bcm = new StandardBoardColorManager(this);
		
	}
	
	public void buildBoard() {
		
		for(int i = 0; i < bm.getWidth(); i++) {
			
			String newId = "p0_pawn" + i;
			pm.add(newId, PieceFactory.makePiece(PieceType.PAWN, PlayerType.WHITE));
			pm.add(newId + "_ep", new EnPassant(newId, PlayerType.WHITE));
			bm.add(newId, i, 1);
			
		}
		
		pm.add("p0_rook0", PieceFactory.makePiece(PieceType.ROOK, PlayerType.WHITE));
		bm.add("p0_rook0", 0, 0);	
		
		pm.add("p0_rook1", PieceFactory.makePiece(PieceType.ROOK, PlayerType.WHITE));
		bm.add("p0_rook1", 7, 0);
		
		
		pm.add("p0_knight0", PieceFactory.makePiece(PieceType.KNIGHT, PlayerType.WHITE));
		bm.add("p0_knight0", 1, 0);	
		
		pm.add("p0_knight1", PieceFactory.makePiece(PieceType.KNIGHT, PlayerType.WHITE));
		bm.add("p0_knight1", 6, 0);
		
		pm.add("p0_bishop0", PieceFactory.makePiece(PieceType.BISHOP, PlayerType.WHITE));
		bm.add("p0_bishop0", 2, 0);	
		
		pm.add("p0_bishop1", PieceFactory.makePiece(PieceType.BISHOP, PlayerType.WHITE));
		bm.add("p0_bishop1", 5, 0);
		
		pm.add("p0_queen0", PieceFactory.makePiece(PieceType.QUEEN, PlayerType.WHITE));
		bm.add("p0_queen0", 4, 0);
		
		pm.add(StandardConstants.whiteKing, PieceFactory.makePiece(PieceType.KING, PlayerType.WHITE));
		bm.add(StandardConstants.whiteKing, 3, 0);
		
		
		for(int i = 0; i < bm.getWidth(); i++) {
			
			String newId = "p1_pawn" + i;
			pm.add(newId, PieceFactory.makePiece(PieceType.PAWN, PlayerType.BLACK));
			pm.add(newId + "_ep", new EnPassant(newId, PlayerType.BLACK));
			bm.add(newId, i, 6);
			
		}
		
		pm.add("p1_rook0", PieceFactory.makePiece(PieceType.ROOK, PlayerType.BLACK));
		bm.add("p1_rook0", 0, 7);	
		
		pm.add("p1_rook1", PieceFactory.makePiece(PieceType.ROOK, PlayerType.BLACK));
		bm.add("p1_rook1", 7, 7);
		
		
		pm.add("p1_knight0", PieceFactory.makePiece(PieceType.KNIGHT, PlayerType.BLACK));
		bm.add("p1_knight0", 1, 7);	
		
		pm.add("p1_knight1", PieceFactory.makePiece(PieceType.KNIGHT, PlayerType.BLACK));
		bm.add("p1_knight1", 6, 7);
		
		
		pm.add("p1_bishop0", PieceFactory.makePiece(PieceType.BISHOP, PlayerType.BLACK));
		bm.add("p1_bishop0", 2, 7);	
		
		pm.add("p1_bishop1", PieceFactory.makePiece(PieceType.BISHOP, PlayerType.BLACK));
		bm.add("p1_bishop1", 5, 7);
		
		pm.add("p1_queen0", PieceFactory.makePiece(PieceType.QUEEN, PlayerType.BLACK));
		bm.add("p1_queen0", 4, 7);
		
		pm.add(StandardConstants.blackKing, PieceFactory.makePiece(PieceType.KING, PlayerType.BLACK));
		bm.add(StandardConstants.blackKing, 3, 7);
		
	}
	
}
