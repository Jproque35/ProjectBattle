package tests.entities;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import game.entities.GamePiece;
import game.entities.TestPiece;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class TestPieceTests {

	@Test
	void getTypeTest() {
		
		GamePiece TestPiece = new TestPiece(PlayerType.WHITE, 0, 0);
		
		assertEquals(PieceType.TEST, TestPiece.getType());
		
	}
	
	@Test
	void checkMoveTest() {
		
		GamePiece TestPiece = new TestPiece(PlayerType.WHITE, 0, 0);
		
		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < 1000; j++) {
				
				assertEquals(TestPiece.checkMove(i, j), true);
				
			}
		}
		
		for(int i = -1; i > -1000; i--) {
			for(int j = -1; j > -1000; j--) {
				assertEquals(TestPiece.checkMove(i,  j), false);
			}
		}
		
	}
	
	@Test
	void getOwnerTest() {
		
		GamePiece TestPiece = new TestPiece(PlayerType.WHITE, 0, 0);
		
		assertEquals(PlayerType.WHITE, TestPiece.getOwner());
		
	}
	
	@Test
	void xPosTest() {
		
		GamePiece TestPiece = new TestPiece(PlayerType.WHITE, 0, 0);
		
		assertEquals(TestPiece.getX(), 0);
		
		for(int i = 0; i < 1000; i++) {
			TestPiece.setX(i);
			assertEquals(TestPiece.getX(), i);
		}
	}
	
	@Test
	void yPosTest() {
		
		GamePiece TestPiece = new TestPiece(PlayerType.WHITE, 0, 0);
		
		assertEquals(TestPiece.getY(), 0);
		
		for(int i = 0; i < 1000; i++) {
			TestPiece.setY(i);
			assertEquals(TestPiece.getY(), i);
		}
	}

}
