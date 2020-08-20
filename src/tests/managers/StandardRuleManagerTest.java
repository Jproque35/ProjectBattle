package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.*;
import game.entities.identities.PlayerType;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.CheckmateManager;
import game.managers.StandardGameManager;
import game.managers.StandardCheckmateManager;

class StandardRuleManagerTest {

	@Test
	void verifyCheckRookTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		pm.add("p1_rook0", new Rook(PlayerType.BLACK, 0, 0));
		bm.add("p1_rook0", 0, 7);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
	}

	@Test
	void verifyCheckBishopTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		String testId1 = "p1_bishop0";
		pm.add(testId1, new Bishop(PlayerType.BLACK, 5, 5));
		bm.add(testId1, 5, 5);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
	}

	@Test
	void verifyCheckQueenTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		String testId1 = "p1_queen0";
		pm.add(testId1, new Queen(PlayerType.BLACK, 5, 5));
		bm.add(testId1, 5, 5);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
		mm.move(testId1, 5, 0);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
	}

	@Test
	void verifyCheckKingTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		String testId1 = "p1_king0";
		pm.add(testId1, new King(PlayerType.BLACK, 5, 5));
		bm.add(testId1, 0, 1);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
		mm.move(testId1, 1, 0);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
	}

	@Test
	void verifyCheckPawnTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		String testId1 = "p1_pawn0";
		pm.add(testId1, new Pawn(PlayerType.BLACK, 5, 5));
		bm.add(testId1, 1, 3);
		
		mm.move(testId1, 1, 1);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
		bm.updatePosition(testId1, 0, 1);
		
		assertEquals(false, rm.verifyCheck(PlayerType.WHITE));
		
	}
	
	@Test
	void verifyRookCheckmateTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		pm.add("p1_rook0", new Rook(PlayerType.BLACK, 0, 0));
		bm.add("p1_rook0", 0, 7);
		
		pm.add("dummy0", new Pawn(PlayerType.WHITE, 1,0));
		bm.add("dummy0", 1, 0);
		
		pm.add("dummy1", new Pawn(PlayerType.WHITE, 1, 1));
		bm.add("dummy1", 1, 1);
		
		assertEquals(true, rm.verifyCheckmate(PlayerType.WHITE));
		
	}

	@Test
	void verifyCheckmateBishopTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		String testId1 = "p1_bishop0";
		pm.add(testId1, new Bishop(PlayerType.BLACK, 5, 5));
		bm.add(testId1, 5, 5);
		
		pm.add("dummy0", new Pawn(PlayerType.WHITE, 0, 0));
		bm.add("dummy0", 0, 1);
		
		pm.add("dummy1", new Bishop(PlayerType.WHITE, 0, 0));
		bm.add("dummy1", 1, 0);
		
		assertEquals(true, rm.verifyCheckmate(PlayerType.WHITE));
		
	}

	@Test
	void verifyCheckmateQueenTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		String testId1 = "p1_queen0";
		pm.add(testId1, new Queen(PlayerType.BLACK, 5, 5));
		bm.add(testId1, 5, 5);
		
		pm.add("dummy0", new Pawn(PlayerType.WHITE, 0, 0));
		bm.add("dummy0", 0, 1);
		
		pm.add("dummy1", new Bishop(PlayerType.WHITE, 0, 0));
		bm.add("dummy1", 1, 0);
		
		pm.add("dummy2", new Bishop(PlayerType.WHITE, 0, 2));
		
		assertEquals(true, rm.verifyCheckmate(PlayerType.WHITE));
		
	}

	@Test
	void verifyCheckmatePawnTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		CheckmateManager rm = new StandardCheckmateManager(gm);
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		pm.add("p0_king0", new King(PlayerType.WHITE, 0, 0));
		bm.add("p0_king0", 0, 0);
		
		String testId1 = "p1_pawn0";
		pm.add(testId1, new Pawn(PlayerType.BLACK, 5, 5));
		bm.add(testId1, 1, 3);
		
		pm.add("dummy0", new Bishop(PlayerType.WHITE, 0,1));
		bm.add("dummy0", 0, 1);
		
		pm.add("dummy1", new Bishop(PlayerType.WHITE, 1, 0));
		bm.add("dummy1", 1, 0);
		
		mm.move(testId1, 1, 1);
		
		assertEquals(true, rm.verifyCheck(PlayerType.WHITE));
		
		bm.updatePosition(testId1, 0, 1);
		
		assertEquals(false, rm.verifyCheck(PlayerType.WHITE));
		
	}
	

}
