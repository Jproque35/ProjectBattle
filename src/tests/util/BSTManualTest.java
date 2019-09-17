package tests.util;

import java.util.ArrayList;

import game.entities.Rook;
import game.entities.identities.PlayerType;
import game.managers.*;
import game.util.Algorithms;
import game.util.Coordinate;

public class BSTManualTest {

	public static void main(String[] args) {

		GameManager gm = new StandardGameManager();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		
		String testId = "Corrin";
		pm.add(testId, new Rook(PlayerType.WHITE, 0, 0));
		bm.add(testId, 5, 5);
		
		
		ArrayList<Coordinate> shortestPath = Algorithms.getShortestPath(testId, gm, 5, 0);
		
		System.out.println(shortestPath);
	}

}
