package game.entities.behaviors;

public class PawnAlternateSecondMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {

		if(newX == oldX && newY == oldY - 1) {
			return true;
		}
		
		return false;
	}

}
