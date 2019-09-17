package game.managers;

import game.entities.identities.PlayerType;
import game.entities.identities.StandardConstants;
import game.view.MainWindow;

public abstract class GameManager {

	protected PieceManager pm;
	protected BoardManager bm;
	protected MovementManager mm;
	protected TurnManager tm;
	protected CheckmateManager cm;
	protected NotificationManager nm;
	protected BoardColorManager bcm;
	protected MainWindow mainView;
	
	/**
	 * Initializes the game with the specified view.
	 * 
	 * @param mainView The view that will be used to represent the game.
	 */
	public void init(MainWindow mainView) {
		
		this.mainView = mainView;
		buildBoard();
		updateView();
		
	}
	
	/**
	 * Retrieves the piece manager responsible for storing the GamePiece entities in the game.
	 * 
	 * @return Returns the PieceManager object responsible for storing the game's entities.
	 */
	public PieceManager getPieceManager() {
		
		return pm;
		
	}
	
	/**
	 * Retrieves the GameBoard object that represents the placement of the GamePiece objects
	 * and defines the bounds of the board.
	 * 
	 * @return Returns the GameBoard object used in the game.
	 
	public GameBoard getGameBoard() {
		
		return gb;
		
	}*/
	
	/**
	 * Retrieves the BoardManager object used for manipulating the GameBoard object.
	 * 
	 * @return Returns the BoardManager object.
	 */
	public BoardManager getBoardManager() {
		
		return bm;
		
	}
	
	/**
	 * Returns the movement manager responsible for moving the pieces on the GameBoard.
	 * 
	 * @return Returns the MovementManager object.
	 */
	public MovementManager getMovementManager() {
		
		return mm;
		
	}
	
	/**
	 * Returns the TurnManager object responsible for managing the turns during the game.
	 * 
	 * @return Returns the TurnManager object.
	 */
	public TurnManager getTurnManager() {
		
		return tm;
		
	}
	
	/**
	 * Retrieves the Checkmate Manager responsible for determining check and checkmate during the game.
	 * 
	 * @return Returns the CheckmateManager object. 
	 */
	public CheckmateManager getCheckmateManager() {
		
		return cm;
		
	}
	
	/**
	 * Retrieves the NotificationManager object responsible for pushing notifications during the game.
	 * 
	 * @return Returns the NotificationManager.
	 */
	public NotificationManager getNotificationManager() {
		
		return nm;
		
	}
	
	/**
	 * Retrieves the BoardColorManager responsible for handling the colors of the board space.
	 * 
	 * @return Returns the BoardColorManager object.
	 */
	public BoardColorManager getBoardColorManager() {
		
		return bcm;
		
	}
	
	public void updateView() {
		
		mainView.updateView();
		
	}
	
	public PlayerType getOpponent(PlayerType player) {
		
		if(player == PlayerType.WHITE) {
			
			return PlayerType.BLACK;
			
		} else if(player == PlayerType.BLACK) {
			
			return PlayerType.WHITE;
			
		}
		
		return player;
		
	}
	
	public String getKingId(PlayerType player) {
		
		if(player == PlayerType.WHITE) {
			
			return StandardConstants.whiteKing;
			
		} else {
			
			return StandardConstants.blackKing;
			
		}
		
	}
	
	public abstract void buildBoard();
	
}
