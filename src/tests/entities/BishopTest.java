package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.Bishop;
import game.entities.GamePiece;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class BishopTest {

	@Test
	void getTypeTest() {
		
		GamePiece testBishop = new Bishop(PlayerType.WHITE, 0, 0);
		
		assertEquals(PieceType.BISHOP, testBishop.getType());
	}
	
	@Test
	void checkMoveTestCentered() {
		
		GamePiece testBishop = new Bishop(PlayerType.WHITE, 0, 0);
		
		int j = 1;
		for(int i = 1; i < 1000; i++) {
			assertEquals(testBishop.checkMove(i, j), true);
			j++;
		}
		
		j = -1;
		for(int i = -1; i > -1000; i--) {
			assertEquals(testBishop.checkMove(i, j), true);
			j--;
		}
		
		j = -1;
		for(int i = 1; i < 1000; i++) {
			assertEquals(testBishop.checkMove(i, j), true);
			j--;
		}
		
		j = 1;
		for(int i = -1; i > -1000; i--) {
			assertEquals(testBishop.checkMove(i, j), true);
			j++;
		}
		
	}
	
	@Test
	void checkMoveTestUncentered() {
		
		GamePiece testBishop = new Bishop(PlayerType.WHITE, 0, 0);
		
		for(int x = -1000; x < 1000; x++) {
			for(int y = -1000; y < 1000; y++) {
				testBishop.setX(x);
				testBishop.setY(y);
				
				moveTestHelper(testBishop);
				
			}
		}
		
	}

	private void moveTestHelper(GamePiece testBishop) {
		int j = testBishop.getY() + 1;
		for(int i = testBishop.getX() + 1; i < 1000; i++) {
			assertEquals(testBishop.checkMove(i, j), true);
			j++;
		}
		
		j = testBishop.getY() - 1;
		for(int i = testBishop.getX() - 1; i > -1000; i--) {
			assertEquals(testBishop.checkMove(i, j), true);
			j--;
		}
		
		j = testBishop.getY() - 1;
		for(int i = testBishop.getX() + 1; i < 1000; i++) {
			assertEquals(testBishop.checkMove(i, j), true);
			j--;
		}
		
		j = testBishop.getY() + 1;
		for(int i = testBishop.getX() - 1; i > -1000; i--) {
			assertEquals(testBishop.checkMove(i, j), true);
			j++;
		}
	}

}
