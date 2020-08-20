package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.Bishop;
import game.entities.identities.PlayerType;
import game.managers.*;

class StandardMovementManagerBishopTest {

	@Test
	void bishopCheckMoveSingleTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Bishop(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		for(int i = 0; i < bm.getLength(); i++) {
			
			for(int j = 0; j < bm.getWidth(); j++ ) {
				
				if(pm.get(testId).checkMove(i, j)) {
					
					assertEquals(true, mm.checkMove(testId, i, j));
					
				}
				
			}
			
		}
		
	}

	@Test
	void bishopCheckMoveBlockedTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Bishop(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new Bishop(PlayerType.WHITE));
		bm.add(dummyId, 3, 3);
		
		assertEquals(false, mm.checkMove(testId, 3, 3));
		assertEquals(false, mm.checkMove(testId, 4, 4));
		assertEquals(false, mm.checkMove(testId, 5, 5));
		
	}

	@Test
	void bishopCheckMoveCaptureTest() {
		
		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Bishop(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new Bishop(PlayerType.BLACK));
		bm.add(dummyId, 3, 3);
		
		assertEquals(true, mm.checkMove(testId, 3, 3));
		assertEquals(false, mm.checkMove(testId, 4, 4));
		assertEquals(false, mm.checkMove(testId, 5, 5));
		
	}

	@Test
	void bishopMoveSingleTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Bishop(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		assertEquals(true, mm.move(testId, 3, 3));
		assertEquals(testId, bm.get(3, 3));
		assertEquals(3, pm.get(testId).getX());
		assertEquals(3, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 1, 1));
		assertEquals(testId, bm.get(1, 1));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(1, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 2, 0));
		assertEquals(testId, bm.get(2, 0));
		assertEquals(2, pm.get(testId).getX());
		assertEquals(0, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 1, 1));
		assertEquals(testId, bm.get(1, 1));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(1, pm.get(testId).getY());
		
	}

	@Test
	void bishopMoveBlockedTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Bishop(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId0 = "Edelgard";
		pm.add(dummyId0, new Bishop(PlayerType.WHITE));
		bm.add(dummyId0, 3, 3);
		
		String dummyId1 = "Dimitri";
		pm.add(dummyId1, new Bishop(PlayerType.WHITE));
		bm.add(dummyId1, 7, 3);
		
		assertEquals(false, mm.move(testId, 3, 3));
		assertEquals(dummyId0, bm.get(3, 3));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(0, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 2, 2));
		assertEquals(testId, bm.get(2, 2));
		assertEquals(2, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 4, 0));
		assertEquals(testId, bm.get(4, 0));
		assertEquals(4, pm.get(testId).getX());
		assertEquals(0, pm.get(testId).getY());
		
		assertEquals(false, mm.move(testId, 7, 3));
		assertEquals(dummyId1, bm.get(7, 3));
		assertEquals(4, pm.get(testId).getX());
		assertEquals(0, pm.get(testId).getY());
		
	}

	@Test
	void bishopMoveCaptureTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Bishop(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId0 = "Edelgard";
		pm.add(dummyId0, new Bishop(PlayerType.BLACK));
		bm.add(dummyId0, 3, 3);
		
		String dummyId1 = "Dimitri";
		pm.add(dummyId1, new Bishop(PlayerType.BLACK));
		bm.add(dummyId1, 4, 2);
		
		assertEquals(false, mm.move(testId, 4, 4));
		assertEquals(null, bm.get(4, 4));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(0, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 3, 3));
		assertEquals(testId, bm.get(3, 3));
		assertEquals(3, pm.get(testId).getX());
		assertEquals(3, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 1, 5));
		assertEquals(testId, bm.get(1, 5));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(5, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 4, 2));
		assertEquals(testId, bm.get(4, 2));
		assertEquals(4, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
	}
}
