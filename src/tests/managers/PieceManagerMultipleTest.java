package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.*;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;
import game.managers.PieceManager;
import game.managers.StandardPieceManager;

class PieceManagerMultipleTest {

	@Test
	void addMultipleTest() {
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		String knightId0 = "p0_knight0";
		GamePiece testKnight0 = new Knight(PlayerType.WHITE);
		
		String bishopId0 = "p0_bishop0";
		GamePiece testBishop0 = new Bishop(PlayerType.WHITE);
		
		String rookId0 = "p0_rook0";
		GamePiece testRook0 = new Rook(PlayerType.WHITE);
		
		p0manager.add(knightId0, testKnight0);
		p0manager.add(bishopId0, testBishop0);
		p0manager.add(rookId0, testRook0);
		
		assertEquals(p0manager.contains(knightId0), true);
		assertEquals(p0manager.contains(bishopId0), true);
		assertEquals(p0manager.contains(rookId0), true);
		
	}
	
	@Test 
	void getMultipleTest() {
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		String knightId0 = "p0_knight0";
		GamePiece testKnight0 = new Knight(PlayerType.WHITE);
		
		String bishopId0 = "p0_bishop0";
		GamePiece testBishop0 = new Bishop(PlayerType.WHITE);
		
		String rookId0 = "p0_rook0";
		GamePiece testRook0 = new Rook(PlayerType.WHITE);
		
		p0manager.add(knightId0, testKnight0);
		p0manager.add(bishopId0, testBishop0);
		p0manager.add(rookId0, testRook0);
		
		assertEquals(p0manager.get(knightId0).getType(), PieceType.KNIGHT);
		assertEquals(p0manager.get(bishopId0).getType(), PieceType.BISHOP);
		assertEquals(p0manager.get(rookId0).getType(), PieceType.ROOK);
		
	}
	
	@Test
	void getRemoveAllMultipleTest() {
		
		PieceManager p0manager = StandardPieceManager.getInstance();
		
		String knightId0 = "p0_knight0";
		GamePiece testKnight0 = new Knight(PlayerType.WHITE);
		
		String bishopId0 = "p0_bishop0";
		GamePiece testBishop0 = new Bishop(PlayerType.WHITE);
		
		String rookId0 = "p0_rook0";
		GamePiece testRook0 = new Rook(PlayerType.WHITE);
		
		p0manager.add(knightId0, testKnight0);
		p0manager.add(bishopId0, testBishop0);
		p0manager.add(rookId0, testRook0);
		
		testKnight0 = p0manager.remove(knightId0);
		testBishop0 = p0manager.remove(bishopId0);
		testRook0 = p0manager.remove(rookId0);
		
	}

}
