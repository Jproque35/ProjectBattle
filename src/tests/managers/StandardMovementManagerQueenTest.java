package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.Queen;
import game.entities.identities.PlayerType;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.StandardGameManager;

class StandardMovementManagerQueenTest {

	@Test
	void queenCheckMoveSingleTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Queen(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		for(int i = 0; i < bm.getLength(); i++) {
			
			for(int j = 0; j < bm.getWidth(); j++ ) {
				
				if(pm.get(testId).checkMove(i, j)) {
					
					assertEquals(true, mm.checkMove(testId, i, j));
					
				}
				
			}
			
		}
		
		for(int i = 0; i < bm.getLength(); i++) {
			
			for(int j = 0; j < bm.getWidth(); j++ ) {
				
				if(pm.get(testId).checkMove(i, j)) {
					
					assertEquals(true, mm.checkMove(testId, i, j));
					
				}
				
			}
			
		}
		
	}

	@Test
	void queenCheckMoveBlockedTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Queen(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId0 = "Edelgard";
		pm.add(dummyId0, new Queen(PlayerType.WHITE));
		bm.add(dummyId0, 3, 3);
		
		String dummyId1 = "Dimitri";
		pm.add(dummyId1, new Queen(PlayerType.WHITE));
		bm.add(dummyId1, 0, 3);
		
		String dummyId2 = "Claude";
		pm.add(dummyId2, new Queen(PlayerType.WHITE));
		bm.add(dummyId2, 3, 0);
		
		assertEquals(false, mm.checkMove(testId, 3, 3));
		assertEquals(false, mm.checkMove(testId, 4, 4));
		
		assertEquals(false, mm.checkMove(testId, 0, 3));
		assertEquals(false, mm.checkMove(testId, 0, 4));
		
		assertEquals(false, mm.checkMove(testId, 3, 0));
		assertEquals(false, mm.checkMove(testId, 4, 0));
	}

	@Test
	void queenCheckMoveCaptureTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Queen(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId0 = "Edelgard";
		pm.add(dummyId0, new Queen(PlayerType.BLACK));
		bm.add(dummyId0, 3, 3);
		
		String dummyId1 = "Dimitri";
		pm.add(dummyId1, new Queen(PlayerType.BLACK));
		bm.add(dummyId1, 0, 3);
		
		String dummyId2 = "Claude";
		pm.add(dummyId2, new Queen(PlayerType.BLACK));
		bm.add(dummyId2, 3, 0);
		
		assertEquals(true, mm.checkMove(testId, 3, 3));
		assertEquals(false, mm.checkMove(testId, 4, 4));
		
		assertEquals(true, mm.checkMove(testId, 0, 3));
		assertEquals(false, mm.checkMove(testId, 0, 4));
		
		assertEquals(true, mm.checkMove(testId, 3, 0));
		assertEquals(false, mm.checkMove(testId, 4, 0));
	}
}
