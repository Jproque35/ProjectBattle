package game.entities.behaviors;

public class KingMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {

		if(newX == oldX + 1 && newY == oldY) {
			return true;
		}
		
		if(newX == oldX + 1 && newY == oldY + 1) {
			return true;
		}
		
		if(newX == oldX && newY == oldY + 1) {
			return true;
		}
		
		if(newX == oldX - 1 && newY == oldY + 1) {
			return true;
		}
		
		if(newX == oldX - 1 && newY == oldY) {
			return true;
		}
		
		if(newX == oldX - 1 && newY == oldY - 1) {
			return true;
		}
		
		if(newX == oldX && newY == oldY - 1) {
			return true;
		}
		
		if(newX == oldX + 1 && newY == oldY - 1) {
			return true;
		}
		
		return false;
	}

}
