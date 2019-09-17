package tests.managers;

import java.util.Iterator;
import java.util.Set;

import game.entities.GamePiece;
import game.entities.identities.PlayerType;
import game.entities.*;
import game.managers.PieceManager;
import game.managers.StandardPieceManager;

public class PieceManagerManualTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Instantiating the piece manager and pieces
		 */
		
		PieceManager p0manager = new StandardPieceManager();
		
		String knightId0 = "p0_knight0";
		GamePiece testKnight0 = new Knight(PlayerType.WHITE);
		
		String bishopId0 = "p0_bishop0";
		GamePiece testBishop0 = new Bishop(PlayerType.WHITE);
		
		String rookId0 = "p0_rook0";
		GamePiece testRook0 = new Rook(PlayerType.WHITE);
		
		String queenId0 = "p0_queen0";
		GamePiece testQueen0 = new Queen(PlayerType.WHITE);
		
		String kingId0 = "p0_king0";
		GamePiece testKing0 = new King(PlayerType.WHITE);
		
		String pawnId0 = "p0_pawn0";
		GamePiece testPawn0 = new Pawn(PlayerType.WHITE);
		
		/*
		 * Manipulate the contents of the piece manager
		 */
		
		p0manager.add(knightId0, testKnight0);
		p0manager.add(bishopId0, testBishop0);
		p0manager.add(rookId0, testRook0);
		p0manager.add(queenId0, testQueen0);
		p0manager.add(kingId0, testKing0);
		p0manager.add(pawnId0, testPawn0);
		
		p0manager.activate(rookId0);
		p0manager.remove(kingId0);
		
		/**
		 * Printing the keys of the piece manager
		 */
		
		Set<String> activeKeys = p0manager.getActiveKeys();
		Set<String> inactiveKeys = p0manager.getInactiveKeys();
		
		System.out.println("Active set: " + activeKeys);
		System.out.println("Inactive Set: " + inactiveKeys);
		
		Iterator<String> activeIterator = activeKeys.iterator();
		Iterator<String> inactiveIterator = inactiveKeys.iterator();
		
		System.out.println("*****Active Keys*****");
		while(activeIterator.hasNext()) {
			System.out.println(activeIterator.next());
		}
		
		System.out.println("*****Inactive Keys*****");
		while(inactiveIterator.hasNext()) {
			System.out.println(inactiveIterator.next());
		}

	}

}
