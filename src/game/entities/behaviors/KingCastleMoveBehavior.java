package game.entities.behaviors;

public class KingCastleMoveBehavior implements MoveBehavior {

	@Override
	public boolean checkMove(int oldX, int oldY, int newX, int newY) {
		
		if(oldY == newY) {
			
			if(Math.abs(newX - oldX) == 2) {
				
				return true;
				
			}
			
			
		}
		
		return false;
	}

}
