package game.entities;

import game.entities.behaviors.RookMoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class Rook extends GamePiece {

	public Rook(PlayerType owner) {
		
		super(owner, -1, -1, "resources/images/pieces/rook_white.png");
		init();
	}
	
	public Rook(PlayerType owner, int x, int y) {
		
		super(owner, x, y, "resources/images/pieces/rook_white.png");
		init();
	}

	protected void init() {
		this.type = PieceType.ROOK;
		this.mb = new RookMoveBehavior();
		
		if(this.owner == PlayerType.BLACK) {
			this.imgPath = "resources/images/pieces/rook_black.png";
		}
	}
	
}
