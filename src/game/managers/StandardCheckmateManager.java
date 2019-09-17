package game.managers;

import java.util.ArrayList;
import java.util.Iterator;

import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;
import game.util.Algorithms;
import game.util.Coordinate;

public class StandardCheckmateManager implements CheckmateManager {

	protected PieceManager pm;
	protected BoardManager bm;
	protected GameManager gm;
	protected MovementManager mm;
	
	public StandardCheckmateManager(GameManager gm) {
		
		this.gm = gm;
		this.pm = gm.getPieceManager();
		this.bm = gm.getBoardManager();
		this.mm = gm.getMovementManager();
		
	}

	/**
	 * Standard implementation of checkmate. Look at auxiliary functions for implementation
	 * details.
	 */
	@Override
	public boolean verifyCheckmate(PlayerType player) {
		
		System.out.println("Looking for checkmate");
		
		String kingId = gm.getKingId(player);
		
		int x = pm.get(kingId).getX();
		int y = pm.get(kingId).getY();
		
		
		if(!verifyCheckmateAux(player, x, y)) {
			
			return false;
			
		}
		
		return checkNeighbors(player, kingId, x, y);
	}

	/**
	 * Visits all of the spaces surrounding the specified location and determines whether or not
	 * they are vulnerable to an unimpeded attack from the opponent's pieces. If all of the spaces
	 * a designated player's king can move to are all under attack, it is considered checkmate.
	 * 
	 * @param player The player to verify whether or not is in checkmate
	 * @param kingId The id of the designated player's king
	 * @param x The x-coordinate of the pace whoe neighbors to check
 	 * @param y They y-coordinate of the space whose neighbors to check
	 * @return Returns true if all of the spaces surrounding the king are checkmated. Otherwise,
	 * returns false.
	 */
	private boolean checkNeighbors(PlayerType player, String kingId, int x, int y) {
		
		if(mm.checkMove(kingId, x + 1, y) && !verifyCheckmateAux(player, x + 1, y)) {
			
			return false;
			
		} else if(mm.checkMove(kingId, x + 1, y + 1) && !verifyCheckmateAux(player, x + 1, y + 1)) {
			
			return false;
			
		} else if(mm.checkMove(kingId, x, y + 1) && !verifyCheckmateAux(player, x, y + 1)) {
			
			return false;
			
		} else if(mm.checkMove(kingId, x - 1, y + 1) && !verifyCheckmateAux(player, x - 1, y + 1)) {
			
			return false;
			
		} else if(mm.checkMove(kingId, x - 1, y) && !verifyCheckmateAux(player, x - 1, y)) {
			
			return false;
			
		} else if(mm.checkMove(kingId, x - 1, y - 1) && !verifyCheckmateAux(player, x - 1, y - 1)) {
			
			return false;
			
		} else if(mm.checkMove(kingId, x, y - 1) && !verifyCheckmateAux(player, x, y - 1)) {
			
			return false;
			
		}  else if(mm.checkMove(kingId, x + 1, y - 1) && !verifyCheckmateAux(player, x + 1, y - 1)) {
			
			return false;
			
		}
		
		return true;
	}
	
	/**Auxiliary function for the main checkmate function. Checks whether or not the specified
	 * location is under attack by an opponent's piece and whether or not the attack can be
	 * blocked by either capturing the attacking pieces or blocking their path.
	 * 
	 * @param player The player to designate as the main player
	 * @param x The x-coordinate of the space to check.
	 * @param y The y-coordinate of the space to check.
	 * @return Return true if the specified location is completely vulnerable to attack.
	 * Otherwise, return false. 
	 */
	private boolean verifyCheckmateAux(PlayerType player, int x, int y) {
		
		if(verifyCheckAux(player, x, y)) {
			
			return isCheckmateBlockable(player, x, y);
			
		}
		
		return false;
		
	}
	
	/**
	 * Verifies whether or not the paths from an opponent's piece to the specified location are
	 * blockable by looking at all of the player's active pieces.
	 * 
	 * @param player The player to check.
	 * @param x The x-coordinate to check.
	 * @param y The y-coordinate to check.
	 * @return Returns true if all paths are blockable. Otherwise, returns false.
	 */
	private boolean isCheckmateBlockable(PlayerType player, int x, int y) {
		
		PlayerType opponent = gm.getOpponent(player);
		ArrayList<String> playerKeys = pm.getActiveKeys(player);
		ArrayList<String> opponentKeys = pm.getActiveKeys(opponent);
		
		System.out.println(playerKeys);
		System.out.println(opponentKeys);
		System.out.println("<" + x + ", " + y + ">");
		
		Iterator<String> opponentIterator = opponentKeys.iterator();
		
		while(opponentIterator.hasNext()) {
			
			String currOppId = opponentIterator.next();
			
			if(mm.checkMove(currOppId, x, y)) {
				
				if(verifyPathBlockable(player, x, y, playerKeys, currOppId)) {
					
					System.out.println("Path Can Be Blocked");
					return false;
					
				}
				
			}
			
		}
		
		return true;
		
	}

	/**
	 * Verifies whether or not the path an opponent's piece takes to a specified location can be
	 * blocked by any of the player's pieces.
	 * 
	 * @param x The x-coordinate of the space the opponent's piece is travelling to.
	 * @param y The y-coordinate of the space the opponent's piece is travellign to.
	 * @param playerKeys An array containing all of the ids of the current player's pieces.
	 * @param currOppId The id of the opponent's attackign GamePiece object.
	 * @return Returns true if the path is blockable by any piece. Otherwise, returns false.
	 */
	private boolean verifyPathBlockable(PlayerType player, int x, int y, ArrayList<String> playerKeys, String currOppId) {
		
		Iterator<String> playerIterator = playerKeys.iterator();
		ArrayList<Coordinate> path = Algorithms.getShortestPath(currOppId, gm, x, y);
		
		if(pm.get(currOppId).getType() == PieceType.KNIGHT){
			
			path = new ArrayList<Coordinate>();
			path.add(new Coordinate(pm.get(currOppId).getX(), pm.get(currOppId).getY()));
			
		}
		
		while(playerIterator.hasNext()) {
			
			String currId = playerIterator.next();
			
			if(!currId.equals(gm.getKingId(player)) && verifyPathBlockableSingle(path, currId)) {
				
				System.out.println("Path can be blocked by " + currId);
				return true;
				
			}
			
		}
		
		System.out.println("Path cannot be blocked");
		return false;
		
	}

	/**
	 * Checks whether or not a specified piece can block the provided path, i.e. move into any
	 * of the designated spaces.
	 * 
	 * @param path The list of spaces contained within the path to block.
	 * @param currId The id of the GamePiece object to check whether or not it can block the path.
	 * @return Returns true if the specified piece can block the path. Otherwise, returns false.
	 */
	private boolean verifyPathBlockableSingle(ArrayList<Coordinate> path, String currId) {
		
		System.out.println(path);
		Iterator<Coordinate> pathIterator = path.iterator();
		
		while(pathIterator.hasNext()) {
			
			Coordinate currCoord = pathIterator.next();
			
			if(mm.checkMove(currId, currCoord.getX(), currCoord.getY())) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

	/**
	 * Verifies whether or not a check has occurred. A checkmate occurs when a player's King
	 * is threatened by another piece.
	 */
	@Override
	public boolean verifyCheck(PlayerType player) {
		
		String kingId = gm.getKingId(player);
		
		return verifyCheckAux(player, pm.get(kingId).getX(), pm.get(kingId).getY());
		
	}
	
	/**Auxiliary function. Determines whether or not the specified location is under attack by
	 * any of the opponent's pieces.
	 * 
	 * @param player The player to check if they are in check.
	 * @param x The x-coordinate of the space to check.
	 * @param y The y-coordinate of the space to check.
	 * @return Returns true if the space is under attack by any of hte opponent's pieces. 
	 * Otherwise, returns false.
	 */
	private boolean verifyCheckAux(PlayerType player, int x, int y) {
		
		ArrayList<String> opponentKeys = pm.getActiveKeys(gm.getOpponent(player));
		Iterator<String> opponentIterator = opponentKeys.iterator();
		
		while(opponentIterator.hasNext()) {
			
			String currId = (String) opponentIterator.next();
			
			if(mm.checkMove(currId, x, y)) {
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
}
