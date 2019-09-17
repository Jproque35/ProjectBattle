package game.entities.behaviors;

public class RookMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {

		if(oldX == newX && oldY != newY) {
			return true;
		}
		
		if(oldX != newX && oldY == newY) {
			return true;
		}
		
		return false;
		
	}
	
}
