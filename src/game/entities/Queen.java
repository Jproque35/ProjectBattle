package game.entities;

import game.entities.behaviors.BishopMoveBehavior;
import game.entities.behaviors.MoveBehavior;
import game.entities.behaviors.RookMoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class Queen extends GamePiece {

	protected MoveBehavior mb2;
	
	public Queen(PlayerType owner) {
		
		super(owner, -1, -1, "resources/images/pieces/queen_white.png");
		
		init();
	}
	
	public Queen(PlayerType owner, int x, int y) {
		
		super(owner, x, y, "resources/images/pieces/queen_white.png");
		
		init();
		
	}

	protected void init() {
		this.type = PieceType.QUEEN;
		this.mb = new BishopMoveBehavior();
		this.mb2 = new RookMoveBehavior();
		
		if(this.owner == PlayerType.BLACK) {
			
			this.imgPath = "resources/images/pieces/queen_black.png";
			
		}
	}
	
	/*
	public boolean checkMove(int x, int y) {
		
		return mb.checkMove(this.x, this.y, x, y) || mb2.checkMove(this.x, this.y, x, y);
		
	}
	*/
	
}
