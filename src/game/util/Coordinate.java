package game.util;

public class Coordinate {

	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public int getX() {
		
		return x;
		
	}
	
	public int getY() {
		
		return y;
		
	}
	
	public boolean equals(Coordinate coord) {
		
		return this.x == coord.getX() && this.y == coord.getY();
		
	}
	
	public String toString() {
		
		return "(" + this.x + ", " + this.y + ")";
		
	}
	
}
