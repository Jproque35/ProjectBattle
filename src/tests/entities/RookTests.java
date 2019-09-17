package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.GamePiece;
import game.entities.Rook;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class RookTests {

	@Test
	void getTypeTest() {
		
		GamePiece testRook = new Rook(PlayerType.WHITE, 0, 0);
		
		assertEquals(PieceType.ROOK, testRook.getType());
		
	}
	
	@Test
	void checkMoveTestCentered() {
		
		GamePiece testRook = new Rook(PlayerType.WHITE, 0, 0);
		
		moveTestHelper(testRook);
		
	}
	
	@Test
	void checkMoveTestUncentered() {
		
		GamePiece testRook = new Rook(PlayerType.WHITE, 0, 0);
		
		for(int i = -1000; i < 1000; i++) {
			for(int j = -1000; j < 1000; j++) {
				
				moveTestHelper(testRook);
				
			}
		}
		
	}

	private void moveTestHelper(GamePiece testRook) {
		for(int k = 1; k < 1000; k++) {
			assertEquals(testRook.checkMove(k, 0), true);
			assertEquals(testRook.checkMove(0, k), true);
		}
		
		for(int k = -1; k > -1000; k--) {
			assertEquals(testRook.checkMove(k, 0), true);
			assertEquals(testRook.checkMove(0, k), true);
		}
	}

}
