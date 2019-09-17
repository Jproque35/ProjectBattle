package game.managers;

import game.entities.identities.PlayerType;

public interface TurnManager {
	
	public String getCurrentPiece();
	
	public void setCurrentPiece(String id);
	
	public void nextTurn();
	
	public int getCurrentTurn();
	
	public PlayerType getCurrentPlayer();
	
}
