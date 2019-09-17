package game.entities;

import game.entities.behaviors.MoveBehavior;
import game.entities.behaviors.PawnAlternateCaptureMoveBehavior;
import game.entities.behaviors.PawnAlternateFirstMoveBehavior;
import game.entities.behaviors.PawnAlternateSecondMoveBehavior;
import game.entities.behaviors.PawnCaptureMoveBehavior;
import game.entities.behaviors.PawnFirstMoveBehavior;
import game.entities.behaviors.PawnSecondMoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class Pawn extends GamePiece {

	protected MoveBehavior capMb;
	
	public Pawn(PlayerType owner) {
		
		super(owner, -1, -1, "resources/images/pieces/pawn_white.png");
		
		init();
	}
	
	public Pawn(PlayerType owner, int x, int y) {
		
		super(owner, x, y, "resources/images/pieces/pawn_white.png");
		
		init();
		
	}

	protected void init() {
		
		this.type = PieceType.PAWN;
		
		if(this.owner == PlayerType.WHITE) {
			
			this.mb = new PawnFirstMoveBehavior();
			this.capMb = new PawnCaptureMoveBehavior();
			
		} else if(this.owner == PlayerType.BLACK) {
			
			this.mb = new PawnAlternateFirstMoveBehavior();
			this.capMb = new PawnAlternateCaptureMoveBehavior();
			this.imgPath = "resources/images/pieces/pawn_black.png";
			
		}
		
	}
	
	/**
	 * Marks the Pawn as having moved and changes its MovementBehavior accordingly.
	 */
	public void setMoved() {
		
		if(this.owner == PlayerType.WHITE) {
			
			mb = new PawnSecondMoveBehavior();
			
		} else if(this.owner == PlayerType.BLACK) {
			
			mb = new PawnAlternateSecondMoveBehavior();
			
		}
		
		hasMoved = true;
		
	}
	
	/**
	 * Sets the Pawn's hasMoved flag to false and sets its MovementBehavior back to its initial one.
	 */
	public void setUnmoved() {
		
		if(this.owner == PlayerType.WHITE) {
			
			mb = new PawnFirstMoveBehavior();
			
		} else if(this.owner == PlayerType.BLACK) {
			
			mb = new PawnAlternateFirstMoveBehavior();
			
		}
		
		hasMoved = true;
		
	}
	
	/**
	 * Checks the Pawn's movement based on its Capture Movement.
	 * 
	 * @param x The x-coordinate to move the piece to
	 * @param y The y-coordinate to move the piece to
	 * @return Whether or not the piece can move to the specified location
	 */
	public boolean checkCaptureMove(int x, int y) {
		
		return capMb.checkMove(this.x, this.y, x, y);
		
	}

}
