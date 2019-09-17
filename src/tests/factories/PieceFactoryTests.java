package tests.factories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.entities.GamePiece;
import game.entities.factories.PieceFactory;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

class PieceFactoryTests {

	@Test
	void makeKnightTest() {
		
		GamePiece testKnight = PieceFactory.makePiece(PieceType.KNIGHT, PlayerType.WHITE);
		
		assertEquals(PlayerType.WHITE, testKnight.getOwner());
		assertEquals(PieceType.KNIGHT, testKnight.getType());
	}
	
	@Test
	void makeBishopTest() {
		
		GamePiece testBishop = PieceFactory.makePiece(PieceType.BISHOP, PlayerType.WHITE);
		
		assertEquals(PlayerType.WHITE, testBishop.getOwner());
		assertEquals(PieceType.BISHOP, testBishop.getType());
		
	}

	@Test
	void makeRookTest() {
		
		GamePiece testRook = PieceFactory.makePiece(PieceType.ROOK, PlayerType.WHITE);
		
		assertEquals(PlayerType.WHITE, testRook.getOwner());
		assertEquals(PieceType.ROOK, testRook.getType());
		
	}
	
	@Test
	void makeQueenTest() {
		
		GamePiece testQueen = PieceFactory.makePiece(PieceType.QUEEN, PlayerType.WHITE);
		
		assertEquals(PlayerType.WHITE, testQueen.getOwner());
		assertEquals(PieceType.QUEEN, testQueen.getType());
		
	}
	
	@Test
	void makeKingTest() {
		
		GamePiece testKing = PieceFactory.makePiece(PieceType.KING, PlayerType.WHITE);
		
		assertEquals(PlayerType.WHITE, testKing.getOwner());
		assertEquals(PieceType.KING, testKing.getType());
		
	}
	
	@Test
	void makePawnTest() {
		
		GamePiece testPawn = PieceFactory.makePiece(PieceType.PAWN, PlayerType.WHITE);
		
		assertEquals(PlayerType.WHITE, testPawn.getOwner());
		assertEquals(PieceType.PAWN, testPawn.getType());
		
	}
	
}
