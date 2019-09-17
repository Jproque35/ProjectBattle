package game.entities.behaviors;

public class PawnCaptureMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {

		if(newY == oldY + 1) {
			if(newX == oldX + 1 || newX == oldX - 1) {
				return true;
			}
		}
		
		return false;
	}

}
