package game.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import game.entities.GamePiece;
import game.entities.identities.PlayerType;

public class StandardPieceManager implements PieceManager {

	private HashMap<String, GamePiece> active;
	private HashMap<String, GamePiece> inactive;
	
	public StandardPieceManager() {
		
		this.active = new HashMap<String, GamePiece>();
		this.inactive = new HashMap<String, GamePiece>();
		
	}
	
	/**
	 * Adds a piece as inactive to the piece manager.
	 * 
	 * @param id The id to assign to the piece
	 * @param piece The piece to add to the manager
	 */
	public void add(String id, GamePiece piece) {
		
		if(!id.equals("")) {
			
			inactive.put(id, piece);
			
		}
		
	}
	
	/**
	 * Removes a piece from the piece manager.
	 * 
	 * @param id The id of the piece that should be removed
	 * @return The piece that was removed from the manager
	 */
	public GamePiece remove(String id) {
		
		if(active.containsKey(id)) {
			
			return active.remove(id);
			
		}
		
		return inactive.remove(id);
		
	}
	
	/**
	 * Checks if the piece with the given id is present within the manager
	 * 
	 * @param id The id of the piece to check
	 * @return Whether or not the piece exists in the manager
	 */
	public boolean contains(String id) {
		
		return inactive.containsKey(id) || active.containsKey(id);
		
	}
	
	/**
	 * Retrieves a piece with the assigned id
	 * 
	 * @param id The id of the piece you want to retrieve
	 * @return The GamePiece object with the given id
	 */
	public GamePiece get(String id) {
		
		if(active.containsKey(id)) {
			
			return active.get(id);
			
		}
		
		return inactive.get(id);
		
	}
	
	/**
	 * Activates the piece with the given id
	 * 
	 * @param id The id of the piece that should be activated
	 */
	public void activate(String id) {
		
		if(inactive.containsKey(id)) {
			
			active.put(id, inactive.remove(id));
			
		}
		
	}
	
	/**
	 * Deactivates the piece with the given id
	 * 
	 * @param id The id of the piece to deactivate
	 */
	public void deactivate(String id) {
		
		if(active.containsKey(id)) {
			
			inactive.put(id, active.remove(id));
			
		}
		
	}
	
	/**
	 * CHecks whether or not the piece with the given id is active.
	 * 
	 * @param id The id of the piece to check.
	 * @return Whether or not the piece with the given id is active. Returns false if the piece does not exist in the manager.
	 */
	public boolean isActive(String id) {
		
		return active.containsKey(id);
		
	}
	
	/**
	 * Returns a set of the keys of all active pieces in the manager
	 * 
	 * @return A set of strings corresponding to the keys of all active pieces in the manager
	 */
	public Set<String> getActiveKeys() {
		
		return active.keySet();
		
	}
	
	/**
	 * Retrieves an ArrayList containing the ActiveKeys belonging to the specified player.
	 * 
	 * @param player
	 * @return
	 */
	public ArrayList<String> getActiveKeys(PlayerType player) {
		
		Set<String> activeKeys = active.keySet();
		ArrayList<String> desire = new ArrayList<String>();
		
		Iterator<String> activeIterator = activeKeys.iterator();
		
		while(activeIterator.hasNext()) {
			
			String currId = activeIterator.next();
			
			if(player == get(currId).getOwner()) {
				
				desire.add(currId);
				
			}
			
		}
		
		return desire;
		
	}
	
	/**
	 * Returns a set of keys of all inactive pieces in the manager
	 * 
	 * @return A set of strings corresponding to the keys of all inactive pieces in the manager
	 */
	public Set<String> getInactiveKeys() {
		
		return inactive.keySet();
		
	}
	
	/**
	 * Cleaers the piece manager of all pieces.
	 */
	public void clearAll() {
		
		active.clear();
		inactive.clear();
		
	}
	
}
