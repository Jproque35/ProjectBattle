package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.King;
import game.entities.identities.PlayerType;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.StandardGameManager;

class StandardMovementManagerKingTest {

	@Test
	void kingCheckMoveSingleTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new King(PlayerType.WHITE));
		bm.add(testId, 3, 3);
		
		assertEquals(true, mm.checkMove(testId, 4, 3));
		assertEquals(true, mm.checkMove(testId, 4, 4));
		assertEquals(true, mm.checkMove(testId,  3, 4));
		assertEquals(true, mm.checkMove(testId, 2, 4));
		assertEquals(true, mm.checkMove(testId, 2, 3));
		assertEquals(true, mm.checkMove(testId, 2, 2));
		assertEquals(true, mm.checkMove(testId, 3, 2));
		assertEquals(true, mm.checkMove(testId, 4, 2));
		
	}
	
	@Test
	void kingChekcMoveBlockedTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new King(PlayerType.WHITE));
		bm.add(testId, 3, 3);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new King(PlayerType.WHITE));
		bm.add(dummyId, 4, 4);
		
		assertEquals(false, mm.checkMove(testId, 4, 4));
		
	}
	
	@Test
	void kingCheckMoveCaptureTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new King(PlayerType.WHITE));
		bm.add(testId, 3, 3);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new King(PlayerType.BLACK));
		bm.add(dummyId, 4, 4);
		
		assertEquals(true, mm.checkMove(testId, 4, 4));
	}

	@Test
	void kingMoveSingleTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new King(PlayerType.WHITE));
		bm.add(testId, 3, 3);
		
		assertEquals(true, mm.move(testId, 4, 3));
		assertEquals(4, pm.get(testId).getX());
		assertEquals(3, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId,  4, 2));
		assertEquals(4, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 3, 3));
		assertEquals(3, pm.get(testId).getX());
		assertEquals(3, pm.get(testId).getY());
		
	}
	
	@Test
	void kingMoveBlockedTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new King(PlayerType.WHITE));
		bm.add(testId, 3, 3);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new King(PlayerType.WHITE));
		bm.add(dummyId, 4, 4);
		
		assertEquals(false, mm.move(testId, 4, 4));
		assertEquals(3, pm.get(testId).getX());
		assertEquals(3, pm.get(testId).getY());
		
	}
	
	@Test
	void kingMoveCpatureTest() {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new King(PlayerType.WHITE));
		bm.add(testId, 3, 3);
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new King(PlayerType.BLACK));
		bm.add(dummyId, 4, 4);
		
		assertEquals(true, mm.move(testId, 4, 4));
		assertEquals(4, pm.get(testId).getX());
		assertEquals(4, pm.get(testId).getY());
		assertEquals(false, pm.isActive(dummyId));
		
	}
	
	
}
