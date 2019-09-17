package game.entities.behaviors;

public class KnightMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {

		if(newX == oldX + 1 || newX == oldX - 1) {
			if(newY == oldY + 2 || newY == oldY - 2) {
				return true;
			}
		}
		
		if(newX == oldX + 2 || newX == oldX - 2) {
			if(newY == oldY + 1 || newY == oldY - 1) {
				return true;
			}
		}
		
		return false;
		
	}

	
	
}
