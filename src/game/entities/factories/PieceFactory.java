package game.entities.factories;

import game.entities.*;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public class PieceFactory {

	public static GamePiece makePiece(PieceType type, PlayerType owner) {
		
		switch(type) {
		
		case KNIGHT:
			return new Knight(owner);
		case ROOK:
			return new Rook(owner);
		case BISHOP:
			return new Bishop(owner);
		case QUEEN:
			return new Queen(owner);
		case KING:
			return new King(owner);
		case PAWN:
			return new Pawn(owner);
		default:
			break;
		
		}
		
		return null;
		
	}
	
}
