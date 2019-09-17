package game.entities;

import game.entities.behaviors.KingCastleMoveBehavior;
import game.entities.behaviors.KingMoveBehavior;
import game.entities.behaviors.MoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class King extends GamePiece {

	protected MoveBehavior castleMb;
	
	public King(PlayerType owner) {
		
		super(owner, -1, -1, "resources/images/pieces/king_white.png");
		
		init();
	}
	
	public King(PlayerType owner, int x, int y) {
		
		super(owner, x, y, "resources/images/pieces/king_white.png");
		
		init();
		
	}

	protected void init() {
		
		this.type = PieceType.KING;
		mb = new KingMoveBehavior();
		castleMb = new KingCastleMoveBehavior();
		
		if(this.owner == PlayerType.BLACK) {
			
			this.imgPath = "resources/images/pieces/king_black.png";
			
		}
		
	}
	
	public boolean checkCastleMove(int x, int y) {
		
		return castleMb.checkMove(this.x, this.y, x, y);
		
	}

}
