package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import game.entities.GamePiece;
import game.entities.Knight;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;
import game.managers.PieceManager;
import game.managers.StandardPieceManager;

class PieceManagerSingleTests {

	@Test
	void containsEmptyTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		assertEquals(p0manager.contains("p0_knight0"), false);
		
	}
	
	@Test
	void addSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		
		p0manager.add("p0_knight0", testKnight);
		assertEquals(p0manager.contains("p0_knight0"), true);
		
	}

	@Test
	void getEmptyTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		assertEquals(p0manager.get("Hail"), null);
		
	}
	
	@Test
	void getSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		assertEquals(p0manager.get(knightId).getType(), PieceType.KNIGHT);
		
	}
	
	@Test
	void removeEmptyTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		assertEquals(p0manager.remove("Hail"), null);
		
	}
	
	@Test
	void removeSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		
		GamePiece testKnightRemoved = p0manager.remove(knightId);
		
		assertEquals(p0manager.contains(knightId), false);
		assertEquals(testKnightRemoved.getType(), PieceType.KNIGHT);
	}
	
	@Test
	void removeGetSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		
		p0manager.remove(knightId);
		
		assertEquals(p0manager.get(knightId), null);
		
	}
	
	@Test
	void initStatusEmptyTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		assertEquals(p0manager.isActive("Hail"), false);
		
	}
	
	@Test
	void initStatusSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void activateSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId,  testKnight);
		p0manager.activate(knightId);
		assertEquals(p0manager.isActive(knightId), true);
		
	}
	
	@Test
	void getActivateSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId,  testKnight);
		p0manager.activate(knightId);
		
		assertEquals(p0manager.get(knightId).getType(), PieceType.KNIGHT);
	}
	
	@Test
	void deactivateSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		p0manager.activate(knightId);
		p0manager.deactivate(knightId);
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void getDeactivateSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		p0manager.activate(knightId);
		p0manager.deactivate(knightId);
		
		assertEquals(p0manager.get(knightId).getType(), PieceType.KNIGHT);
		
	}
	
	@Test
	void addRemoveInitStatusSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		testKnight = p0manager.remove(knightId);
		
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void addRemoveActivateSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		p0manager.activate(knightId);
		testKnight = p0manager.remove(knightId);
		
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void addRemoveDeactivateSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
	
		p0manager.add(knightId, testKnight);
		p0manager.activate(knightId);
		p0manager.deactivate(knightId);
		testKnight = p0manager.remove(knightId);
		
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void getInactiveKeysEmptyTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		Set<String> inactiveKeys = p0manager.getInactiveKeys();
		
		assertEquals(inactiveKeys.isEmpty(), true);
		
	}
	
	@Test
	void getInactiveKeysSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		
		Set<String> inactiveKeys = p0manager.getInactiveKeys();
		
		assertEquals(inactiveKeys.contains(knightId), true);
		
	}
	
	@Test 
	void getActiveKeysEmptyTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		Set<String> activeKeys = p0manager.getActiveKeys();
		
		assertEquals(activeKeys.isEmpty(), true);
		
	}
	
	@Test
	void getActiveKeysSingleTest() {
		
		PieceManager p0manager = new StandardPieceManager();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId,  testKnight);
		p0manager.activate(knightId);
		
		Set<String> activeKeys = p0manager.getActiveKeys();
		
		assertEquals(activeKeys.contains(knightId), true);
		
	}

}
