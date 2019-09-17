package game.managers;

import game.entities.identities.PlayerType;

public interface CheckmateManager {
	
	/**
	 * Verifies whether or not a checkmate has occurred. A checkmate occurs when a player's King
	 * is threatened by the opposing player's piece(s) and it cannot avoid capture.
	 * 
	 * @param player The player to check whether or not a checkmate has occured to.
	 * @return Returns true if the specified player is in checkmate. Otherwise, returns false.
	 */
	public boolean verifyCheckmate(PlayerType player);
	
	/**
	 * Verifies whether or not a check has occured for a specified player. A check occurs when
	 * the player's King is threatened by the opposing player's piece(s) but can move out of
	 * the threat.
	 * 
	 * @param player The player to check whether or not a check has occurred to.
	 * @return Returns true if the specified player is in check. Otherwise, returns false.
	 */
	public boolean verifyCheck(PlayerType player);
	
}
