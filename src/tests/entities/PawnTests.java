package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.*;
import game.entities.behaviors.PawnSecondMoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class PawnTests {

	@Test
	void getTypeTest() {

		GamePiece testPawn = new Pawn(PlayerType.WHITE, 0, 0);
		
		assertEquals(PieceType.PAWN, testPawn.getType());
		
	}
	
	@Test
	void checkFirstMoveTestCentered() {
		
		GamePiece testPawn = new Pawn(PlayerType.WHITE, 0, 0);
		
		assertEquals(testPawn.checkMove(0, 2), true);
		
	}
	
	@Test
	void checkFirstMoveTestUncentered() {
		
		GamePiece testPawn = new Pawn(PlayerType.WHITE, 0, 0);
		
		for(int i = -1000; i < 1000; i++) {
			for(int j = -1000; j < 1000; j++) {
				testPawn.setX(i);
				testPawn.setY(j);
				
				assertEquals(testPawn.checkMove(i, j + 2), true);
			}
		}
		
	}
	
	@Test
	void checkSecondMoveTestCentered() {
		
		GamePiece testPawn = new Pawn(PlayerType.WHITE, 0, 0);
		
		testPawn.setMoveBehavior(new PawnSecondMoveBehavior());
		
		assertEquals(testPawn.checkMove(0, 1), true);
		
	}
	
	@Test
	void checkSecondMoveTestUncentered() {
		
		GamePiece testPawn = new Pawn(PlayerType.WHITE, 0, 0);
		
		testPawn.setMoveBehavior(new PawnSecondMoveBehavior());
		
		for(int i = -1000; i < 1000; i++) {
			for(int j = -1000; j < 1000; j++) {
				
				testPawn.setX(i);
				testPawn.setY(j);
				
				assertEquals(testPawn.checkMove(i,  j+1), true);
				
			}
		}
		
	}
	
	@Test
	void checkCaptureMoveTestCentered() {
		
		GamePiece testPawn = new Pawn(PlayerType.WHITE, 0, 0);
		
		assertEquals(((Pawn)testPawn).checkCaptureMove(1,1), true);
		assertEquals(((Pawn)testPawn).checkCaptureMove(-1, 1), true);
		
	}
	
	@Test
	void checkCaptureMoveTestUncentered() {
		
		GamePiece testPawn = new Pawn(PlayerType.WHITE, 0, 0);
		
		for(int i = -1000; i < 1000; i++) {
			for(int j = -1000; j < 1000; j++) {
				testPawn.setX(i);
				testPawn.setY(j);
				
				assertEquals(((Pawn)testPawn).checkCaptureMove(i + 1,j+1), true);
				assertEquals(((Pawn)testPawn).checkCaptureMove(i-1, j+1), true);
			}
		}
		
	}

}
