package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.Pawn;
import game.entities.identities.PlayerType;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.StandardGameManager;

class StandardMovementManagerPawnTest {

	@Test
	void pawnCheckFirstMoveSingleTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		assertEquals(true, mm.checkMove(testId, 0, 1));
		assertEquals(true, mm.checkMove(testId, 0, 2));
		
	}
	
	@Test
	void pawnCheckFirstMoveBlockedByAllyTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.WHITE));
		bm.add(dummyId, 0, 1);
		
		assertEquals(false, mm.checkMove(testId, 0, 1));
		assertEquals(false, mm.checkMove(testId, 0, 2));
		
	}
	
	@Test
	void pawnCheckFirstMoveBlockedByOpponentTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.BLACK));
		bm.add(dummyId, 0, 1);
		
		assertEquals(false, mm.checkMove(testId, 0, 1));
		assertEquals(false, mm.checkMove(testId, 0, 2));
		
	}
	
	@Test
	void pawnCheckFirstMoveCaptureFailTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.BLACK));
		bm.add(dummyId, 0, 1);
		
		String dummyId2 = "Dimitri";
		pm.add(dummyId2,  new Pawn(PlayerType.BLACK));
		bm.add(dummyId2, 2, 1);
		
		assertEquals(false, mm.checkMove(testId, 0, 1));
		assertEquals(false, mm.checkMove(testId, 2, 1));
		
	}
	
	@Test
	void pawnFirstMoveSingleTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		assertEquals(true, mm.move(testId, 0, 1));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(1, pm.get(testId).getY());
		
	}
	
	@Test
	void pawnAlternateFirstMoveSingleTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		assertEquals(true, mm.move(testId, 0, 2));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
	}
	
	@Test
	void pawnAfterFirstMoveFailTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 0, 0);
		
		assertEquals(true, mm.move(testId, 0, 2));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());

		assertEquals(false, mm.move(testId, 0, 4));
		assertEquals(0, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
	}
	
	@Test
	void pawnCheckSecondMoveSingleTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.checkMove(testId, 1, 3));
		
	}
	
	@Test
	void pawnCheckSecondMoveBlockedByAllyTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.WHITE));
		bm.add(dummyId, 1, 3);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(false, mm.checkMove(testId, 1, 3));
	}
	
	@Test
	void pawnCheckSecondMoveBlockedByOpponentTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.BLACK));
		bm.add(dummyId, 1, 3);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(false, mm.checkMove(testId, 1, 3));
	}
	
	@Test
	void pawnCheckSecondMoveCaptureSingleTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(false, mm.checkMove(testId, 2, 3));
		assertEquals(false, mm.checkMove(testId, 0, 3));
	}
	
	@Test
	void pawnCheckSecondMoveCaptureBlockedTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.WHITE));
		bm.add(dummyId, 2, 3);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(false, mm.checkMove(testId, 2, 3));
	}
	
	@Test
	void pawnCheckSecondMoveCaptureTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.BLACK));
		bm.add(dummyId, 2, 3);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.checkMove(testId, 2, 3));
	}
	
	@Test
	void pawnSecondMoveSingleTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 1, 3));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(3, pm.get(testId).getY());
	}
	
	@Test
	void pawnSecondMoveBlockedByAllyTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.WHITE));
		bm.add(dummyId, 1, 3);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(false, mm.move(testId, 1, 3));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
	}
	
	@Test
	void pawnSecondMoveBlockedByOpponentTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.BLACK));
		bm.add(dummyId, 1, 3);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(false, mm.move(testId, 1, 3));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
	}
	
	@Test
	void pawnSecondMoveCaptureTest() {
		
		TestFunctions.resetManagers();

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Pawn(PlayerType.WHITE));
		bm.add(testId, 1, 0);
		
		String dummyId = "Edelgard";
		pm.add(dummyId,  new Pawn(PlayerType.BLACK));
		bm.add(dummyId, 2, 3);
		
		String dummyId2 = "Dimitri";
		pm.add(dummyId2, new Pawn(PlayerType.BLACK));
		bm.add(dummyId2, 1, 5);
		
		assertEquals(true, mm.move(testId, 1, 2));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(2, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 2, 3));
		assertEquals(2, pm.get(testId).getX());
		assertEquals(3, pm.get(testId).getY());
		assertEquals(false, pm.isActive(dummyId));
		
		assertEquals(true, mm.move(testId, 2, 4));
		assertEquals(2, pm.get(testId).getX());
		assertEquals(4, pm.get(testId).getY());
		
		assertEquals(true, mm.move(testId, 1, 5));
		assertEquals(1, pm.get(testId).getX());
		assertEquals(5, pm.get(testId).getY());
		assertEquals(false, pm.isActive(dummyId2));
	}
}
