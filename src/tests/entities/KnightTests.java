package tests.entities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import game.entities.GamePiece;
import game.entities.Knight;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class KnightTests {
	
	@Test 
	void getTypeTest() {
		GamePiece testKnight = new Knight(PlayerType.WHITE, 0, 0);
		
		assertEquals(PieceType.KNIGHT, testKnight.getType());
		
	}
	
	@Test
	void checkMoveTestCentered() {
		
		GamePiece testKnight = new Knight(PlayerType.WHITE, 0, 0);
		
		assertEquals(testKnight.checkMove(1, 2), true);
		assertEquals(testKnight.checkMove(2, 1), true);
		assertEquals(testKnight.checkMove(-1, -2), true);
		assertEquals(testKnight.checkMove(-2, -1), true);
		assertEquals(testKnight.checkMove(-1, 2), true);
		assertEquals(testKnight.checkMove(-2, 1), true);
		assertEquals(testKnight.checkMove(1, -2), true);
		assertEquals(testKnight.checkMove(2, -1), true);
		
	}
	
	@Test
	void checkMoveTestUncentered() {
		
		GamePiece testKnight = new Knight(PlayerType.WHITE, 0, 0);
		
		for(int i = -1000; i < 1000; i++) { 
			for(int j = -1000; j < 1000; j++) {
				testKnight.setX(i);
				testKnight.setY(j);
				
				assertEquals(testKnight.checkMove(testKnight.getX() + 1, testKnight.getY() + 2), true);
				assertEquals(testKnight.checkMove(testKnight.getX() + 2, testKnight.getY() + 1), true);
				assertEquals(testKnight.checkMove(testKnight.getX() - 1, testKnight.getY() - 2), true);
				assertEquals(testKnight.checkMove(testKnight.getX() - 2, testKnight.getY() - 1), true);
				assertEquals(testKnight.checkMove(testKnight.getX() - 1, testKnight.getY() + 2), true);
				assertEquals(testKnight.checkMove(testKnight.getX() - 2, testKnight.getY() + 1), true);
				assertEquals(testKnight.checkMove(testKnight.getX() + 1, testKnight.getY() - 2), true);
				assertEquals(testKnight.checkMove(testKnight.getX() + 2, testKnight.getY() - 1), true);
			}
		}
	}
	
}
