package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.*;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class EnPassantTest {

	@Test
	void getTypeTest() {
		
		EnPassant testEnPassant = new EnPassant("Corrin_ep", PlayerType.WHITE);
		
		assertEquals(PieceType.ENPASSANT, testEnPassant.getType());
		
	}
	
	@Test
	void getOwnerTest() {
		
		EnPassant testEnPassant = new EnPassant("Corrin_ep", PlayerType.WHITE);
		
		assertEquals(PlayerType.UNALIGNED, testEnPassant.getOwner());
		
	}
	
	@Test
	void checkMoveTest() {
		
		EnPassant testEnPassant = new EnPassant("Corrin_ep", PlayerType.WHITE);
		
		assertEquals(false, testEnPassant.checkMove(0, 0));
		
	}
	
	@Test
	void getParenIdTest() {
		
		EnPassant testEnPassant = new EnPassant("Corrin_ep", PlayerType.WHITE);
		
		assertEquals("Corrin_ep", testEnPassant.getParentId());
		
	}
	
	@Test
	void getParentOwnerTest() {
		
		EnPassant testEnPassant = new EnPassant("Corrin_ep", PlayerType.WHITE);
		
		assertEquals(PlayerType.WHITE, testEnPassant.getParentOwner());
		
	}

}
