package game.managers;

import java.util.ArrayList;
import java.util.Iterator;

import game.entities.*;
import game.entities.behaviors.BishopMoveBehavior;
import game.entities.behaviors.KingCastleMoveBehavior;
import game.entities.behaviors.KingMoveBehavior;
import game.entities.behaviors.RookMoveBehavior;
import game.entities.identities.PieceType;

public class StandardMovementManager extends MovementManager {

	
	public StandardMovementManager(GameManager gm) {
		
		super(gm);
		
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
		
		if(!pm.contains(id)) {
			
			return false;
			
		} else if(pm.get(id).getType() == PieceType.KNIGHT ) {
			
			return this.checkMoveKnight(id, x, y);
			
		} else if(pm.get(id).getType() == PieceType.PAWN) {
			
			return this.checkMovePawn(id, x, y);
			
		} else if(pm.get(id).getType() == PieceType.QUEEN) {
			
			pm.get(id).setMoveBehavior(new RookMoveBehavior());
			boolean straightCheck = checkMoveBase(id, x, y);
			pm.get(id).setMoveBehavior(new BishopMoveBehavior());
			
			return  straightCheck || checkMoveBase(id, x, y);
			
		} else if(pm.get(id).getType() == PieceType.KING) {
			
			
			if(!pm.get(id).hasMoved() && checkMoveKingCastle(id, x, y)) {
				
				return true;
				
			}
			
		}
		
		return checkMoveBase(id, x, y);
		
	}
	
	/**
	 * Checks if a GamePiece object with the specified id can move to the specified space. Does not consider whether not
	 * the path to the space is blocked.
	 * 
	 * @param id The id of the GamePiece object wwe ant to move.
	 * @param x The x-coordinate of the destination space
	 * @param y The y-coordinate of the destination space
	 * @return Returns true if the GamePiece object can move to the specified space. Otherwise returns false.
	 */
	private boolean checkMoveKnight(String id, int x, int y) {
		
		return this.isValidSpace(id, x, y) && !this.isOccupiedByAlly(id, x, y);
		
	}
	
	/**
	 * Checks if a GamePiece object with the specified id can move to the specified space. Abides to the Pawn's varying 
	 * movement pattern.
	 * 
	 * @param id The id of the GamePiece object to move
	 * @param x The x-coordinate of the destination space
	 * @param y The y-coordinate of the destination space
	 * @return Returns true if the GamePiece object can move to the specified space. Otherwise returns false.
	 */
	private boolean checkMovePawn(String id, int x, int y) {
		
		Pawn currPiece = (Pawn) pm.get(id);
		
		if(!currPiece.hasMoved()) {
			
			return this.checkMoveBase(id, x, y) && !this.isOccupiedByOpponent(id, x, y);
			
		} else {
			
			if(currPiece.checkMove(x, y) && bm.isEmpty(x, y)) {
				
				return true;
				
			} else if(currPiece.checkCaptureMove(x, y) && checkMovePawnCapture(id, x, y)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	protected boolean checkMovePawnCapture(String id, int x, int y) {
		
		if(!bm.isEmpty(x, y)) {
			
			return pm.get(id).getOwner() != pm.get(bm.get(x, y)).getOwner();
			
		}
		
		return false;
		
	}
	
	protected boolean isValidSpace(String id, int x, int y) {
		
		return bm.inBounds(x, y) && pm.get(id).checkMove(x, y);
		
	}
	
	private boolean checkMoveKingCastle(String id, int x, int y) {
		
		King currKing = (King) pm.get(id);
		boolean desire= false;
		
		System.out.println("Checking for tower");
		
		if(checkMoveBase(id, x, y)) {
			currKing.setMoveBehavior(new KingCastleMoveBehavior());
			if(checkMoveKnight(id, x, y)) {
				
				String rookId = this.getClosestUnmovedRook(id, x, y);
				
				System.out.println("Tower passed: " + rookId);
				desire = true;
				
			}
			currKing.setMoveBehavior(new KingMoveBehavior());
		}
		
		return desire;
		
	}
	
	private String getClosestUnmovedRook(String id, int x, int y) {
		
		ArrayList<String> keys = pm.getActiveKeys(pm.get(id).getOwner());
		String desire = "";
		int smallestDist = Integer.MAX_VALUE;
		
		Iterator<String> keyIterator = keys.iterator();
		
		while(keyIterator.hasNext()) {
			
			String currId = keyIterator.next();
			GamePiece currPiece = pm.get(currId);
			
			if(currPiece.getType() == PieceType.ROOK && !currPiece.hasMoved()) {
				
				int xSquare = ( currPiece.getX() - x ) * ( currPiece.getX() - x );
				int ySquare = ( currPiece.getY() - y ) * ( currPiece.getY() - y );
				int currDist = (int) Math.sqrt( xSquare + ySquare );
				
				if( currDist < smallestDist) {
					
					smallestDist = currDist;
					desire = currId;
					
				}
				
			}
			
		}
		
		return desire;
		
	}
	
	/**
	 * Method with actions to accomplish before a piece is moved. This iteration involves creating a "ghost"
	 * piece to facilitate the En Passant rule when a Pawn is moved two spaces.
	 */
	protected void preMove(String id, int x, int y) {
		
		GamePiece currPiece = pm.get(id);
		
		if(currPiece.getType() == PieceType.PAWN && Math.abs(y - currPiece.getY()) == 2) {
			
			if(currPiece.getY() < y) {
				
				bm.add(id + "_ep", currPiece.getX(), currPiece.getY() + 1);
				System.out.println(pm.get(id + "_ep"));
				
			} else if(currPiece.getY() > y) {
				
				bm.add(id + "_ep", currPiece.getX(), currPiece.getY() - 1);
				System.out.println(pm.get(id + "_ep"));
				
			}
			
		}
		
	}
	
	/**
	 * Method containing actions to accomplish after the successful move of a piece. This particular iteration
	 * is intended to change the movement pattern of any Pawn-type piece after its first move.
	 */
	protected void postMove(String id, int x, int y) {

		GamePiece currPiece = pm.get(id);
		
		if(!currPiece.hasMoved()) {
			
			currPiece.setMoved();
			
		}
		/*
		if(pm.get(id).getType() == PieceType.PAWN) {
			
			Pawn currPiece = (Pawn) pm.get(id);
			
			
		}*/
		
	}

}
