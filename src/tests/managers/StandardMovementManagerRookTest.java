package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.Rook;
import game.entities.identities.PlayerType;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.StandardGameManager;

class StandardMovementManagerRookTest {

	@Test
	void rookCheckMoveSingleTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE));
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
	void rookCheckMoveOutOfBoundsTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		for(int i = bm.getLength(); i < bm.getLength() * 2; i++) {
					
				assertEquals(false, mm.checkMove(testId, i, 0));
			
		}
		
		for(int i = bm.getWidth(); i < bm.getWidth() * 2; i++) {
					
				assertEquals(false, mm.checkMove(testId, 0, i));
			
		}
		
	}

	@Test
	void rookCheckMoveBlockedTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new Rook(PlayerType.WHITE));
		bm.add(dummyId, 0, 5);
		
		assertEquals(false, mm.checkMove(testId, 0, 5));
		assertEquals(false, mm.checkMove(testId, 0, 6));
		assertEquals(false, mm.checkMove(testId, 0, 7));
		
	}

	@Test
	void rookCheckMoveCaptureTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new Rook(PlayerType.BLACK));
		bm.add(dummyId, 0, 5);
		
		assertEquals(true, mm.checkMove(testId, 0, 5));
		assertEquals(false, mm.checkMove(testId, 0, 6));
		assertEquals(false, mm.checkMove(testId, 0, 7));
	}
	
	@Test
	void rookMoveSingleTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		assertEquals(true, mm.move(testId, 0, 7));
		assertEquals(testId, bm.get(0, 7));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(7, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 0, 5));
		assertEquals(testId, bm.get(0, 5));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(5, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 7, 5));
		assertEquals(testId, bm.get(7, 5));
		assertEquals(7, pm.get(testId).getX());
		assertEquals(5, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 7, 2));
		assertEquals(testId, bm.get(7, 2));
		assertEquals(7, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		
	}
	
	@Test
	void rookMoveBlockedTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId0 = "Edelgard";
		pm.add(dummyId0, new Rook(PlayerType.WHITE));
		bm.add(dummyId0, 0, 5);

		String dummyId1 = "Dimitri";
		pm.add(dummyId1, new Rook(PlayerType.WHITE));
		bm.add(dummyId1, 6, 4);
		
		assertEquals(false, mm.move(testId, 0, 5));
		assertEquals(dummyId0, bm.get(0, 5));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(0, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 0, 4));
		assertEquals(testId, bm.get(0, 4));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(4, pm.get(testId).getY());
		
		assertEquals(false, mm.move(testId, 0, 6));
		assertEquals(null, bm.get(0, 6));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(4, pm.get(testId).getY());
		
		assertEquals(false, mm.move(testId, 6, 4));
		assertEquals(dummyId1, bm.get(6, 4));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(4, pm.get(testId).getY());
		
		
	}
	
	@Test
	void rookMoveCaptureTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId0 = "Edelgard";
		pm.add(dummyId0, new Rook(PlayerType.BLACK));
		bm.add(dummyId0, 0, 5);

		String dummyId1 = "Dimitri";
		pm.add(dummyId1, new Rook(PlayerType.BLACK));
		bm.add(dummyId1, 6, 5);
		
		assertEquals(false, mm.move(testId, 0, 6));
		assertEquals(true, mm.move(testId, 0, 5));
		assertEquals(testId, bm.get(0, 5));
		
		assertEquals(false, mm.move(testId, 7, 5));
		assertEquals(true, mm.move(testId, 6, 5));
		assertEquals(testId, bm.get(6, 5));
		
		assertEquals(false, pm.isActive(dummyId0));
		assertEquals(false, pm.isActive(dummyId1));
		assertEquals(false, bm.contains(dummyId0));
		assertEquals(false, bm.contains(dummyId1));
		
	}

}
