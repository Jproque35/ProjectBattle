package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.GamePiece;
import game.entities.King;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class KingTests {

	@Test
	void getTypeTest() {
		
		GamePiece testKing = new King(PlayerType.WHITE, 0, 0);
		
		assertEquals(PieceType.KING, testKing.getType());
		
	}
	
	@Test
	void moveTestCentered() {
		
		GamePiece testKing = new King(PlayerType.WHITE, 0, 0);
		
		assertEquals(testKing.checkMove(1, 0), true);
		assertEquals(testKing.checkMove(1, 1), true);
		assertEquals(testKing.checkMove(0, 1), true);
		assertEquals(testKing.checkMove(-1, 1), true);
		assertEquals(testKing.checkMove(-1, 0), true);
		assertEquals(testKing.checkMove(-1, -1), true);
		assertEquals(testKing.checkMove(0, -1), true);
		assertEquals(testKing.checkMove(1, -1), true);
		
	}
	
	@Test
	void moveTestUncentered() {
		
		GamePiece testKing = new King(PlayerType.WHITE, 0, 0);
		
		for(int i = -1000; i < 1000; i++) {
			for(int j = -1000; j < 1000; j++) {
				testKing.setX(i);
				testKing.setY(j);
				
				assertEquals(testKing.checkMove(testKing.getX() + 1, testKing.getY()), true);
				assertEquals(testKing.checkMove(testKing.getX() + 1, testKing.getY() + 1), true);
				assertEquals(testKing.checkMove(testKing.getX(), testKing.getY() + 1), true);
				assertEquals(testKing.checkMove(testKing.getX() - 1, testKing.getY() + 1), true);
				assertEquals(testKing.checkMove(testKing.getX() - 1, testKing.getY()), true);
				assertEquals(testKing.checkMove(testKing.getX() - 1, testKing.getY() - 1), true);
				assertEquals(testKing.checkMove(testKing.getX(), testKing.getY() - 1), true);
				assertEquals(testKing.checkMove(testKing.getX() + 1, testKing.getY() - 1), true);
			}
		}
		
	}

}
