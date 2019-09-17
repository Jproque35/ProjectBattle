package game.entities;

import game.entities.behaviors.BishopMoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class Bishop extends GamePiece {

	public Bishop(PlayerType owner) {
		
		super(owner, -1, -1, "resources/images/pieces/bishop_white.png");
		
		init();
		
	}
	
	public Bishop(PlayerType owner, int x, int y) {
		
		super(owner, x, y, "resources/images/pieces/bishop_white.png");
		
		init();
	}

	protected void init() {
		
		this.type = PieceType.BISHOP;
		mb = new BishopMoveBehavior();
		
		if(this.owner == PlayerType.BLACK) {
			
			this.imgPath = "resources/images/pieces/bishop_black.png";
			
		}
		
	}

}
