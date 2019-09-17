package tests.managers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.managers.*;

class StandardMovementManagerTest {

	@Test
	void checkMoveEmptyTest() {

		GameManager gm = new StandardGameManager();
		MovementManager mm = gm.getMovementManager();
		
		assertEquals(false, mm.checkMove("Corrin", 3, 4));
		
	}
	
	@Test
	void moveEmptyTest() {

		GameManager gm = new StandardGameManager();
		MovementManager mm = gm.getMovementManager();
		
		assertEquals(false, mm.move("Corrin", 1, 3));
		
	}

}
