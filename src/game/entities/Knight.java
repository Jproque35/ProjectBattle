package game.entities;

import game.entities.behaviors.KnightMoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class Knight extends GamePiece {

	public Knight(PlayerType owner) {
		
		super(owner, -1, -1, "resources/images/pieces/knight_white.png");
		
		init();
		
	}
	
	public Knight(PlayerType owner, int x, int y) {
		
		super(owner, x, y, "resources/images/pieces/knight_white.png");
		
		init();
		
	}

	protected void init() {
		
		this.type = PieceType.KNIGHT;
		mb = new KnightMoveBehavior();
		
		if(this.owner == PlayerType.BLACK) {
			this.imgPath = "resources/images/pieces/knight_black.png";
		}
		
	}
	
}
