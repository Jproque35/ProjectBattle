package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.*;
import game.entities.identities.PlayerType;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.PieceManager;
import game.managers.StandardGameManager;
import game.managers.StandardPieceManager;

class StandardBoardManagerTest {

	@Test()
	void getLengthTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		BoardManager bm = gm.getBoardManager();
		
		assertEquals(8, bm.getLength());
		
	}

	@Test()
	void getLWidthTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		BoardManager bm = gm.getBoardManager();
		
		assertEquals(8, bm.getWidth());
		
	}
	
	@Test
	void containsEmpty() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		BoardManager bm = gm.getBoardManager();
		
		assertEquals(false, bm.contains("Corrin"));
		
	}
	
	@Test
	void getEmptyTes() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		BoardManager bm = gm.getBoardManager();
		
		assertEquals(null, bm.get(0, 0));
		
	}
	
	@Test
	void removeEmptyTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		BoardManager bm = gm.getBoardManager();
		
		assertEquals(null, bm.remove(0, 0));
		
	}
	
	@Test
	void addNotInPieceManagerTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		BoardManager bm = gm.getBoardManager();
		
		bm.add("Corrin", 0, 0);
		
		assertEquals(false, bm.contains("Corrin"));
		
	}
	
	@Test
	void addSingleTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("Corrin", new Knight(PlayerType.WHITE));
		bm.add("Corrin", 5, 5);
		
		assertEquals(true, bm.contains("Corrin"));
		assertEquals(true, pm.isActive("Corrin"));
		assertEquals(5, pm.get("Corrin").getX());
		assertEquals(5, pm.get("Corrin").getY());
		
	}
	
	@Test
	void getSingleTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("Corrin", new Knight(PlayerType.WHITE));
		bm.add("Corrin", 5, 5);
		
	}
	
	@Test
	void removeSingleTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("Corrin", new Knight(PlayerType.WHITE));
		bm.add("Corrin", 5, 5);
		
		assertEquals("Corrin", bm.remove(5,  5));
		assertEquals(false, pm.isActive("Corrin"));
		
	}
	
	@Test
	void updatePositionSingleTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("Corrin", new Knight(PlayerType.WHITE));
		bm.add("Corrin", 5, 5);
		
		bm.updatePosition("Corrin", 0, 0);
		
		assertEquals(0, pm.get("Corrin").getX());
		assertEquals(0, pm.get("Corrin").getY());
		
	}
	
	@Test
	void updatePositionOverriteTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("Corrin", new Knight(PlayerType.WHITE));
		bm.add("Corrin", 5, 5);
		
		pm.add("Edelgard", new Knight(PlayerType.BLACK));
		bm.add("Edelgard", 0, 0);
		
		bm.updatePosition("Corrin", 0, 0);
		
		assertEquals(0, pm.get("Corrin").getX());
		assertEquals(0, pm.get("Corrin").getY());
		assertEquals(false, pm.isActive("Edelgard"));
		
	}
	
	@Test
	void removeEnPassantTest() {
		
		TestFunctions.resetManagers();
		
		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		pm.add("Corrin", new Pawn(PlayerType.WHITE));
		pm.add("Corrin_ep", new EnPassant("Corrin", pm.get("Corrin").getOwner()));
		
		pm.add("Edelgard", new Pawn(PlayerType.BLACK));
		
		bm.add("Corrin", 3, 3);
		bm.add("Corrin_ep", 3, 2);
		bm.add("Edelgard", 0, 0);
		
		assertEquals(true, pm.isActive("Corrin"));
		assertEquals(true, pm.isActive("Corrin_ep"));
		
		bm.updatePosition("Edelgard", 3, 2);
		
		assertEquals(false, pm.isActive("Corrin"));
		assertEquals(false, pm.isActive("Corrin_ep"));
		
	}
}
