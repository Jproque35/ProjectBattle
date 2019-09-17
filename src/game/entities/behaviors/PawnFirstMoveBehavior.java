package game.entities.behaviors;

public class PawnFirstMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {
	
		if(newX == oldX && checkY(oldY, newY)) {
			return true;
		}
		
		return false;
	}

	private boolean checkY(int oldY, int newY) {
		
		return newY > oldY && newY <=oldY + 2;
		
	}

}
