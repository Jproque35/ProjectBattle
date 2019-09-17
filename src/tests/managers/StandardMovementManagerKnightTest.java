package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.Knight;
import game.entities.identities.PlayerType;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.StandardGameManager;

class StandardMovementManagerKnightTest {

	@Test
	void knightCheckMoveTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Knight(PlayerType.WHITE));
		bm.add(testId, 3, 3);
		
		assertEquals(true, mm.checkMove(testId, 4, 5));
		assertEquals(true, mm.checkMove(testId, 5, 4));
		assertEquals(true, mm.checkMove(testId, 2, 1));
		assertEquals(true, mm.checkMove(testId, 1, 2));
		assertEquals(true, mm.checkMove(testId, 2, 5));
		assertEquals(true, mm.checkMove(testId, 4, 1));
		assertEquals(true,mm.checkMove(testId, 1, 4));
		assertEquals(true, mm.checkMove(testId, 4, 1));
		
	}
	
	@Test
	void knightCheckMoveBlockedTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Knight(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Knight(PlayerType.WHITE));
		bm.add(dummyId, 1, 2);
		
		String dummyId2 = "Dimitri";
		pm.add(dummyId2, new Knight(PlayerType.WHITE));
		bm.add(dummyId2, 1, 1);
		
		String dummyId3 = "Claude";
		pm.add(dummyId3, new Knight(PlayerType.WHITE));
		bm.add(dummyId3, 1, 0);
		
		assertEquals(false, mm.checkMove(testId, 1, 2));
		assertEquals(true, mm.checkMove(testId, 2, 1));
		
	}
	
	@Test
	void knightCheckMoveCaptureTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Knight(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Knight(PlayerType.BLACK));
		bm.add(dummyId, 1, 2);
		
		String dummyId2 = "Dimitri";
		pm.add(dummyId2, new Knight(PlayerType.BLACK));
		bm.add(dummyId2, 1, 1);
		
		String dummyId3 = "Claude";
		pm.add(dummyId3, new Knight(PlayerType.BLACK));
		bm.add(dummyId3, 1, 0);
		
		assertEquals(true, mm.checkMove(testId, 1, 2));
		assertEquals(true, mm.checkMove(testId, 2, 1));
		
	}
	
	@Test
	void knightMoveSingleTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Knight(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 3, 1));
		assertEquals(3, pm.get(testId).getX());
		assertEquals(1, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId,  5, 2));
		assertEquals(5, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
	}
	
	@Test
	void knightMoveBlockedTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Knight(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Knight(PlayerType.WHITE));
		bm.add(dummyId, 1, 2);
		
		String dummyId2 = "Dimitri";
		pm.add(dummyId2, new Knight(PlayerType.WHITE));
		bm.add(dummyId2, 1, 1);
		
		String dummyId3 = "Claude";
		pm.add(dummyId3, new Knight(PlayerType.WHITE));
		bm.add(dummyId3, 1, 0);
		
		assertEquals(false, mm.move(testId, 1, 2));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(0, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId,2, 1));
		assertEquals(2, pm.get(testId).getX());
		assertEquals(1, pm.get(testId).getY());
	}
	
	@Test
	void knightMoveCpautreTest() {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Knight(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Knight(PlayerType.BLACK));
		bm.add(dummyId, 3, 1);
		
		String dummyId2 = "Dimitri";
		pm.add(dummyId2, new Knight(PlayerType.BLACK));
		bm.add(dummyId2, 5, 2);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 3, 1));
		assertEquals(3, pm.get(testId).getX());
		assertEquals(1, pm.get(testId).getY());
		assertEquals(false, pm.isActive(dummyId));
		
		assertEquals(true, mm.move(testId,  5, 2));
		assertEquals(5, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		assertEquals(false, pm.isActive(dummyId2));
		
	}
	
}
