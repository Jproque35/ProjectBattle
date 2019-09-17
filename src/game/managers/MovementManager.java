package game.managers;

import java.util.ArrayList;
import java.util.Iterator;

import game.util.Coordinate;
import game.util.Queue;

public abstract class MovementManager {

	protected BoardManager bm;
	protected PieceManager pm;
	protected CheckmateManager cm;
	protected GameManager gm;
	
	/**
	 * The MovementManager handles the relocation of the GamePiece object on the GameBoard according to their CheckMove function.
	 * 
	 * @param pm The PieceManager object that contains the pieces we want to work with.
	 * @param bm The BoardManager that contains the above PieceManager and the board we want to work with.
	 */
	public MovementManager(GameManager gm) {
		
		this.bm = gm.getBoardManager();
		this.pm = gm.getPieceManager();
		this.cm = gm.getCheckmateManager();
		this.gm = gm;
		
	}
	
	public void setCheckmateManager(CheckmateManager cm) {
		
		this.cm = cm;
		
	}
	
	/**
	 * Checks if the object with the specified id can move to the specified location. 
	 * 
	 * @param id The id of the GamePiece we want to move.
	 * @param x The x-coordinate we want to move the GaePiece object to.
	 * @param y The y-coordinate we want to move the GamePiece object to.
	 * @return Returns true if the movement is possible. Otherwise returns false.
	 */
	public boolean checkMove(String id, int x, int y) {
		
		return checkMoveBase(id, x, y);
		
	}
	
	/**
	 * The basic algorithm for checking if a piece can move to a specified location. It is considered possible to move to a 
	 * specified location if it passes the GamePiece object's checkMove function and if there is no GamePiece object owned
	 * by the same player on the space. Utilizes a breadth-first search algorithm to check the surrounding spaces.
	 * 
	 * @param id The id of the GamePiece object to move.
	 * @param x The x-coordinate of the destination space.
	 * @param y The y-coordinate of the destination space.
	 * @return Returns true if it is possible to move to the specified location. Otherwwise, returns false.
	 */
	protected boolean checkMoveBase(String id, int x, int y) {
		
		if(pm.contains(id) && pm.isActive(id)) {
						
			Queue<Coordinate> q = new Queue<Coordinate>();
			ArrayList<Coordinate> visited = new ArrayList<Coordinate>();
			
			addNeighbors(id, q, visited, pm.get(id).getX(), pm.get(id).getY());
			
			while(!q.isEmpty()) {
				
				Coordinate currCoord = q.dequeue();
				
				if(currCoord.getX() == x && currCoord.getY() == y) {
					
					return true;
					
				}
				
				if(bm.isEmpty(currCoord.getX(), currCoord.getY())) {
					
					addNeighbors(id, q, visited, currCoord.getX(), currCoord.getY());
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * Adds the neighbors of the given point denoted by the given x and y coordinates. The piece ith the given id must be
	 * able to move to the potential neighbors, it must be within the bounds specified by the BoardManager object, and
	 * it cannot be occupied by a piece that has the same owner as the piece wiwth the given id.
	 * 
	 * @param id The id of GamePiece object e ant to move
	 * @param q A queue to add the neighbors to in an ordered fashion
	 * @param l1 A list containing spaces that have already been visited
	 * @param x The x-coordinate of the point we are working with
	 * @param y The y-coordinate of the point we are working ith
	 */
	private void addNeighbors(String id, Queue<Coordinate> q, ArrayList<Coordinate> l1, 
			int x, int y) {
		
		addNeighborsAux(id, q, l1, x + 1, y);		
		addNeighborsAux(id, q, l1, x + 1, y + 1);		
		addNeighborsAux(id, q, l1, x + 1, y - 1);
				
		addNeighborsAux(id, q, l1, x - 1, y);		
		addNeighborsAux(id, q, l1, x - 1, y + 1);		
		addNeighborsAux(id, q, l1, x - 1, y - 1);
			
		addNeighborsAux(id, q, l1, x, y + 1);		
		addNeighborsAux(id, q, l1, x, y - 1);
		
	}

	/**
	 * Auxilary function that adds a given point to a queue and list if it meets the constraints specified in the main
	 * function.
	 * 
	 * @param id The id of the GamePiece object we are working with
	 * @param q A queue to add the neighbors to in an ordered fashion
	 * @param l A list containing spaces that have already been visited
	 * @param currX The x-coordinate of the point to evaluate
	 * @param currY The y-coordinate of the point to evaluate
	 */
	private void addNeighborsAux(String id, Queue<Coordinate> q, ArrayList<Coordinate> l,
			int currX, int currY) {
		
		if(isValidSpace(id, currX, currY) && !isOccupiedByAlly(id, currX, currY)) {
			
			Coordinate currCoord = new Coordinate(currX, currY);
			
			if(!listContains(l, currCoord)) {
				q.enqueue(currCoord);
				l.add(currCoord);
			}
			
		}
	}
	
	/**
	 * Determines whether or not the given space is a valid space to move under the checkMove function of the GamePiece
	 * object with the specified id.
	 * 
	 * @param id The id of the GamePiece object we are working with
	 * @param x The x-coordinate to evaluate
	 * @param y The y-coordinate to evaluate
	 * @return Returns true if the given space is valid under the GamePiece object's checkMove function and if it is in
	 * the bounds of the GameBoard object.
	 */
	protected boolean isValidSpace(String id, int x, int y) {
		
		return bm.inBounds(x, y) && pm.get(id).checkMove(x, y);
		
	}
	
	/**
	 * Checks if the given space is occupied by a GamePiece object that shares the same owner as the GamePiece object with 
	 * the given id
	 * 
	 * @param id The id of the GamePiece object to compare with
	 * @param x The x-coordinate of the space to check
	 * @param y The y-coordinate of the space to check
	 * @return Returns true if the provided space is occupied by a GamePiece object that shares the same owner as the one
	 * occupying the given space. Returns false if there is no GamePiece object in the given space or if the object has a
	 * different oner.
	 */
	protected boolean isOccupiedByAlly(String id, int x, int y) {
		
		if(!bm.isEmpty(x, y)) {
			
			return pm.get(id).getOwner() == pm.get(bm.get(x, y)).getOwner();
			
		}
		
		return false;
		
	}
	
	/**
	 * Determines whether or not the given space is occupied by a GamePiece object with a different owwner than that wwith
	 * the given id.
	 * 
	 * @param id The id of the GamePiece object to compare to.
	 * @param x The x-coordinate of the space to check.
	 * @param y The y-coordinate of the space to check.
	 * @return Returns true if the space is occupied by an opponent. Otherise, returns false.
	 */
	protected boolean isOccupiedByOpponent(String id, int x, int y) {
		
		if(!bm.isEmpty(x, y)) {
			
			return pm.get(id).getOwner() != pm.get(bm.get(x, y)).getOwner();
			
		}
		
		return false;
		
	}
	
	/**
	 * Verifies if a list of given coordinates contains the specified coordinate.
	 * 
	 * @param l A list of coordinates to check
	 * @param currCoord A coordinate to check if it is in the lsit
	 * @return Returns true if the given coordinate is in the given list. Otherise returns false.
	 */
	private boolean listContains(ArrayList<Coordinate> l, Coordinate currCoord) {
		
		Iterator<Coordinate> listIterator = l.iterator();
		
		while(listIterator.hasNext()) {
			
			if(listIterator.next().toString().equals(currCoord.toString())) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

	/**
	 * Auxiliary function that aids in determining whether or not a King can move to a specified location. If a space is under
	 * attack by an opponent's piece, the King cannot move to said location.
	 * 
	 * @param id The id of the piece whose movement we want to check
	 * @param x The x-coordinate of the space to check if the piece can move to 
	 * @param y The y-coordinate of the space to check if the piece can move to
	 * @return Returns true if the piece is not hindered by any of the opponent's pieces. Otherwise, returns false.
	 */
	public boolean moveCausesCheck(String id, int x, int y) {
		
		String currId = "";
		boolean desire = false;
		int oldX = pm.get(id).getX();
		int oldY = pm.get(id).getY();
		
		if(!bm.isEmpty(x, y)) {
			
			currId = bm.remove(x, y);
			
		}
		
		bm.updatePosition(id, x, y);
		
		if(cm.verifyCheck(pm.get(id).getOwner())) {
			
			desire = true;
			
		}
		
		bm.updatePosition(id, oldX, oldY);
		
		if(!currId.equals("")) {
			
			bm.add(currId, x, y);
			
		}
		
		return desire;
		
	}
	
	/**
	 * Moves the GamePiece object to the specified location. 
	 * 
	 * @param id The id of the GamePiece object we want to move.
	 * @param x The x-coordinate we want to move the GamePiece object to.
	 * @param y The y-coordinate we want to move the GamePiece object to.
	 * @return Returns true if the movement was successful. Otherwise returns false.
	 */
	public boolean move(String id, int x, int y) {
		
		if(pm.contains(id) && checkMove(id, x, y)) {
			
			this.preMove(id, x, y);
			bm.updatePosition(id, x, y);
			this.postMove(id, x, y);
			
			return true;
			
		}
		
		return false;
		
	}
	
	protected abstract void preMove(String id, int x, int y);
	
	/**
	 * Abstract method containing actions to accomplish after a successful move of a piece.
	 * 
	 * @param id The id of the GamePiece object to manipulate
	 * @param x The x-coordinate to which the GamePiece object was moved to
	 * @param y The y-coordinate to which the GamePiece object was moved to
	 */
	protected abstract void postMove(String id, int x, int y);
	
}
