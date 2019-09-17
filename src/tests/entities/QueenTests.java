package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.GamePiece;
import game.entities.Queen;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class QueenTests {

	@Test
	void getTypeTest() {
		
		GamePiece testQueen = new Queen(PlayerType.WHITE, 0, 0);
		
		assertEquals(PieceType.QUEEN, testQueen.getType());
		
	}

}
