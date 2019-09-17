package game.entities;

import game.entities.behaviors.TestMoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class TestPiece extends GamePiece {

	public TestPiece(PlayerType owner, int x, int y) {
		
		super(owner, x, y);
		init();
	}

	@Override
	protected void init() {
		this.type = PieceType.TEST;
		mb = new TestMoveBehavior();
	}
	
}
