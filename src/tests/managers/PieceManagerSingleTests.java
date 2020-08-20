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
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		assertEquals(p0manager.contains("p0_knight0"), false);
		
	}
	
	@Test
	void addSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		
		p0manager.add("p0_knight0", testKnight);
		assertEquals(p0manager.contains("p0_knight0"), true);
		
	}

	@Test
	void getEmptyTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		assertEquals(p0manager.get("Hail"), null);
		
	}
	
	@Test
	void getSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		assertEquals(p0manager.get(knightId).getType(), PieceType.KNIGHT);
		
	}
	
	@Test
	void removeEmptyTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		assertEquals(p0manager.remove("Hail"), null);
		
	}
	
	@Test
	void removeSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		
		GamePiece testKnightRemoved = p0manager.remove(knightId);
		
		assertEquals(p0manager.contains(knightId), false);
		assertEquals(testKnightRemoved.getType(), PieceType.KNIGHT);
	}
	
	@Test
	void removeGetSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		
		p0manager.remove(knightId);
		
		assertEquals(p0manager.get(knightId), null);
		
	}
	
	@Test
	void initStatusEmptyTest() {
		
		StandardPieceManager.resetInstance();
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		assertEquals(p0manager.isActive("Hail"), false);
		
	}
	
	@Test
	void initStatusSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void activateSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId,  testKnight);
		p0manager.activate(knightId);
		assertEquals(p0manager.isActive(knightId), true);
		
	}
	
	@Test
	void getActivateSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId,  testKnight);
		p0manager.activate(knightId);
		
		assertEquals(p0manager.get(knightId).getType(), PieceType.KNIGHT);
	}
	
	@Test
	void deactivateSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		p0manager.activate(knightId);
		p0manager.deactivate(knightId);
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void getDeactivateSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		p0manager.activate(knightId);
		p0manager.deactivate(knightId);
		
		assertEquals(p0manager.get(knightId).getType(), PieceType.KNIGHT);
		
	}
	
	@Test
	void addRemoveInitStatusSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		testKnight = p0manager.remove(knightId);
		
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void addRemoveActivateSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		p0manager.activate(knightId);
		testKnight = p0manager.remove(knightId);
		
		assertEquals(p0manager.isActive(knightId), false);
		
	}
	
	@Test
	void addRemoveDeactivateSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
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
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		Set<String> inactiveKeys = p0manager.getInactiveKeys();
		
		assertEquals(inactiveKeys.isEmpty(), true);
		
	}
	
	@Test
	void getInactiveKeysSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId, testKnight);
		
		Set<String> inactiveKeys = p0manager.getInactiveKeys();
		
		assertEquals(inactiveKeys.contains(knightId), true);
		
	}
	
	@Test 
	void getActiveKeysEmptyTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		Set<String> activeKeys = p0manager.getActiveKeys();
		
		assertEquals(activeKeys.isEmpty(), true);
		
	}
	
	@Test
	void getActiveKeysSingleTest() {
		
		StandardPieceManager.resetInstance();
		
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		GamePiece testKnight = new Knight(PlayerType.WHITE);
		String knightId = "p0_knight0";
		
		p0manager.add(knightId,  testKnight);
		p0manager.activate(knightId);
		
		Set<String> activeKeys = p0manager.getActiveKeys();
		
		assertEquals(activeKeys.contains(knightId), true);
		
	}

}
