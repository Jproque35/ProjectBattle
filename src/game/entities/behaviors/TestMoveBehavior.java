package game.entities.behaviors;

public class TestMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {

		return (newX >= 0) && (newY >= 0);
		
	}

}
