package tests.managers;

import game.entities.*;
import game.entities.identities.PlayerType;
import game.managers.*;

public class StandardMovementManagerManualTest {

	public static void main(String[] args) {

		GameManager gm = StandardGameManager.getInstance();
		PieceManager pm = gm.getPieceManager();
		BoardManager bm = gm.getBoardManager();
		MovementManager mm = gm.getMovementManager();
		
		String testId = "Corrin";
		pm.add(testId, new Knight(PlayerType.WHITE));
		
		String dummyId = "Edelgard";
		pm.add(dummyId, new Pawn(PlayerType.WHITE));
		
		bm.add(testId, 0, 0);
		bm.add(dummyId, 1, 2);
		
		System.out.println(mm.move(testId, 1, 2));

		System.out.println(mm.move(testId, 1, 3));
		
	}
	
}
