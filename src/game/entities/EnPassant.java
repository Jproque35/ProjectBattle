package game.entities;

import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class EnPassant extends GamePiece {

	protected String parentId;
	protected PlayerType parentOwner;
	
	public EnPassant(String parentId, PlayerType parentOwner) {
		
		super(PlayerType.UNALIGNED);
		this.parentId = parentId;
		this.parentOwner = parentOwner;
		
		init();
		
	}

	@Override
	protected void init() {
			
		this.type= PieceType.ENPASSANT;
		
	}
	
	/**
	 * The EnPassant is not a moveable piece, so it should not be able to move at all.
	 */
	public boolean checkMove(int x, int y) {
		
		return false;
		
	}
	
	public String getParentId() {
		
		return parentId;
		
	}
	
	public PlayerType getParentOwner() {
		
		return parentOwner;
		
	}

}
