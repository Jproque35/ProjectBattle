package game.entities.behaviors;

public class BishopMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {
		
		if(newX != oldX && newY != oldY) {
			if(Math.abs(newX - oldX) == Math.abs(newY - oldY)) {
				return true;
			}
		}
		
		return false;
	}
	
}