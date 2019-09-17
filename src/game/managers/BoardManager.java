package game.managers;

import game.entities.GamePiece;

/**
 * @author duren
 *
 */
public abstract class BoardManager {

	protected final String emptySpace = "-empty-";
	protected PieceManager pm;
	protected String[][] data;
	protected int width;
	protected int length;
	
	/**
	 * Board Manager class. Adds pieces from a piece manager to a GameBoard object and syncs with the
	 * PieceManagers.
	 * 
	 * @param pm A piece manager containing the pieces in the game.
	 * @param gb A GameBoard object where the game will take place.
	 */
	public BoardManager(GameManager gm) {
		
		this.pm = gm.getPieceManager();
		
	}
	
	/**
	 * Clears the board of all ids. 
	 */
	public void clearAll() {
		
		for(int i = 0; i < this.width; i++) {
			
			for(int j = 0; j < this.length; j++) {
				
				data[i][j] = emptySpace;
				
			}
			
		}
		
	}
	
	/**
	 * Retrieves the id of the piece located in the specified location of the GameBoard object.
	 * 
	 * @param x The x-coordinate of the space to check on the GameBoard object.
	 * @param y The y-coordinate of the space to check on the GameBoard object.
	 * @return Returns the id of the GamePiece object located in the specified location. If there is
	 * nothing in the space, returns null.
	 */
	public String get(int x, int y) {
		
		if(inBounds(x,y) && !data[x][y].equals(emptySpace)) {
			
			return this.data[x][y];	
			
		}
		
		return null;
		
	}
	
	/**
	 * Retrieves the width of the GameBoard. 
	 * 
	 * @return Returns the width of the GameBoard object.
	 */
	public int getWidth() {
		
		return width;
		
	}
	
	/**
	 *Retrieves the length of the GameBoard. 
	 * 
	 * @return Returns the length of the GameBoard object.
	 */
	public int getLength() {
		
		return length;
		
	}
	
	/**
	 * Determines whether or not the GameBoard contains a piece with the specified id.
	 * 
	 * @param id The id of the piece to check is present.
	 * @return Returns the id of the piece in the b
	 */
	public boolean contains(String id) {
		
		for(int i = 0; i < this.width; i++) {
			
			for(int j = 0; j < this.length; j++) {
				
				if(data[i][j].equals(id)) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Determines whether or not the given space is within the bounds of the GameBoard object.
	 * 
	 * @param x The x-coordinate of the space to check.
	 * @param y The y-coordiante of the space to check.
	 * @return Returns true if the space is within the bounds of the Gameboard object. Otherwise, returns false.
	 */
	public boolean inBounds(int x, int y) {
		
		if(0 <= x && x < width) {
			
			if(0 <= y && y < length) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Determines whether or not the specified space on the board contains a piece.
	 * 
	 * @param x The x-coordinate of the space to check.
	 * @param y	The y-coordinate of the space to check.
	 * @return Returns true if there is no piece present in the specified location.Otherwise, returns
	 * false.
	 */
	public boolean isEmpty(int x, int y) {
		
		return get(x, y) == null;
		
	}
	
	/**
	 * Adds a GamePiece object with the given id to the GameBoard object and activates it. Does not overwrite if the space is occupied.
	 * 
	 * @param id The id of the GamePiece object to add
	 * @param x The x-coordinate on the GameBoard object to place the GamePiece object
	 * @param y The y-coordinate on the GameBoard object to place the GamePiece object
	 */
	public void add(String id, int x, int y) {
		
		if( isValidPiece(id, x, y) && inBounds(x, y) ) {
			
			pm.activate(id);
			pm.get(id).setX(x);
			pm.get(id).setY(y);
			addAux(id, x, y);
			
		}
		
	}
	
	/**
	 * Stores the id in the specified location on the game board.
	 * 
	 * @param id The id to store in the game board
	 * @param x The x-coordinate of the location to store the id
	 * @param y The y-coordinate of the location to store the id
	 */
	private void addAux(String id, int x, int y) {
		
		if(inBounds(x,y)) {
			
			this.data[x][y] = id;
			
		}
		
	}

	/**
	 * Auxilary method for the add function that verifies if the given arguments are valid.
	 * 
	 * @param id The id of the GamePiece object to add
	 * @param x The x-coordinate on the GameBoard object to place the GamePiece object
	 * @param y The y-coordinate on the GameBoard object to place the GamePiece object
	 * @return Returns true if the given id is in the PieceManager and the given coordinates are in the bounds of the GameBoard object.
	 */
	private boolean isValidPiece(String id, int x, int y) {
		
		return pm.contains(id) && isEmpty(x, y);
		
	}
	
	/**
	 * Deactivates a piece with the given id and removes it from the game board.
	 * 
	 * @param id The id of the piece to deactivate and remove from the GameBoard object.
	 * @return Returns the id that was removed, represented as a String. Returns an empty String if nothing was removed.
	 */
	public String remove(int x, int y) {
		
		if(!isEmpty(x, y) && pm.contains(get(x, y))) {
			
			String currId = get(x, y);
			
			pm.deactivate(currId);
			
			return removeAux(pm.get(currId).getX(), pm.get(currId).getY());
			
		}
		
		return null;
		
	}
	
	/**
	 * Removes the id at the specified spot on the board.
	 * 
	 * @param x The x-coordinate of the id to remove
	 * @param y The y-coordinate of the id to remove
	 * @return A String that specifies the id removed. Returns an empty string if there is no id to remove.
	 */
	private String removeAux(int x, int y) {
		
		if(inBounds(x, y)) {
			
			String desire = data[x][y];
			
			data[x][y] = emptySpace;
			
			return desire;
			
		}
		
		return null;
		
	}
	
	/**
	 * Updates the  position of the GamePiece object with the associated id with the given x-coordinate and y-coordinate. Removes the piece in the old position, if any.
	 * 
	 * @param id The id of the GamePiece object to update.
	 * @param x The new x-coordinate to assign to the GamePiece object.
	 * @param y The new y-coordinate to assign to the GamePiece object.
	 * @return Returns true if the update was successful. Otherwise, returns false.
	 */
	public void updatePosition(String id, int x, int y) {
		
		if(!inBounds(x,y)) {
			
			return;
			
		}
		
		if( contains(id) && pm.contains(id) ) {
			
			GamePiece currPiece = pm.get(id);
			
			removeIfOccupied(x, y);
			
			add(this.remove(currPiece.getX(), currPiece.getY()), x, y);
			
		}
		
	}

	/**
	 * Auxilary function. Removes the id of the GamePiece that occupies the specified position.
	 * 
	 * @param x The x-coordinate to check.
	 * @param yThe y-coordinate to check.
	 */
	private void removeIfOccupied(int x, int y) {
		
		if(!isEmpty(x, y)) {
			
			this.remove(x, y);
			
		}
		
	}
}
