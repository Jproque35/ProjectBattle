package game.managers;

import java.util.ArrayList;
import java.util.Set;

import game.entities.GamePiece;
import game.entities.identities.PlayerType;

public interface PieceManager {
	
	/**
	 * Adds a piece as inactive to the piece manager.
	 * 
	 * @param id The id to assign to the piece
	 * @param piece The piece to add to the manager
	 */
	public void add(String id, GamePiece piece);
	
	/**
	 * Removes a piece from the piece manager.
	 * 
	 * @param id The id of the piece that should be removed
	 * @return The piece that was removed from the manager
	 */
	public GamePiece remove(String id);
	
	/**
	 * Checks if the piece with the given id is present within the manager
	 * 
	 * @param id The id of the piece to check
	 * @return Whether or not the piece exists in the manager
	 */
	public boolean contains(String id);
	
	/**
	 * Retrieves a piece with the assigned id
	 * 
	 * @param id The id of the piece you want to retrieve
	 * @return The GamePiece object with the given id
	 */
	public GamePiece get(String id);
	
	/**
	 * Activates the piece with the given id
	 * 
	 * @param id The id of the piece that should be activated
	 */
	public void activate(String id);
	
	/**
	 * Deactivates the piece with the given id
	 * 
	 * @param id The id of the piece to deactivate
	 */
	public void deactivate(String id);
	
	/**
	 * CHecks whether or not the piece with the given id is active.
	 * 
	 * @param id The id of the piece to check.
	 * @return Whether or not the piece with the given id is active. Returns false if the piece does not exist in the manager.
	 */
	public boolean isActive(String id);
	
	/**
	 * Returns a set of the keys of all active pieces in the manager
	 * 
	 * @return A set of strings corresponding to the keys of all active pieces in the manager
	 */
	public Set<String> getActiveKeys();
	
	/**
	 * Retrieves an ArrayList containing the ActiveKeys belonging to the specified player.
	 * 
	 * @param player
	 * @return Returns a list of ids belonging to the designated player's active pieces.
	 */
	public ArrayList<String> getActiveKeys(PlayerType player);
	
	/**
	 * Returns a set of keys of all inactive pieces in the manager
	 * 
	 * @return A set of strings corresponding to the keys of all inactive pieces in the manager
	 */
	public Set<String> getInactiveKeys();
	
}
