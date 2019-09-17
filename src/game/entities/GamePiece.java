package game.entities;

import game.entities.behaviors.MoveBehavior;
import game.entities.identities.PieceType;
import game.entities.identities.PlayerType;

public abstract class GamePiece {

	protected PlayerType owner;
	protected int x;
	protected int y;
	protected PieceType type;
	protected MoveBehavior mb;
	protected String imgPath;
	protected boolean hasMoved;
	
	public GamePiece(PlayerType owner) {
		
		this.owner = owner;
		this.x = -1;
		this.y = -1;
		this.hasMoved = false;
		this.imgPath = null;
		
	}
	
	public GamePiece(PlayerType owner, int x, int y) {
		this.owner = owner;
		this.x = x;
		this.y = y;
		this.hasMoved = false;
		this.imgPath = null;
	}
	
	public GamePiece(PlayerType owner, int x, int y, String imgPath) {
		this.owner = owner;
		this.x = x;
		this.y = y;
		this.hasMoved = false;
		this.imgPath = imgPath;
	}
	
	protected abstract void init();
	
	/**
	 * Retrieves the path to the image file that represents the GamePiece object. 
	 * 
	 * @return Returns the path to the image file.
	 */
	public String getImage() {
		
		return imgPath;
		
	}
	
	/**
	 * Sets the path to the piece's image file
	 * 
	 * @param imgPath The new path for the image file
	 */
	public void setImage(String imgPath) {
		
		this.imgPath = imgPath;
		
	}
	
	/**
	 * Returns whether or not the Pawn has moved during the course of the game.
	 * 
	 * @return Returns true if the Pawn has moved. Otherwise, returns false.
	 */
	public boolean hasMoved() {
		
		return hasMoved;
		
	}
	
	/**
	 * Marks the Pawn as having moved and changes its MovementBehavior accordingly.
	 */
	public void setMoved() {
		
		hasMoved = true;
		
	}
	
	/**
	 * Sets the Pawn's hasMoved flag to false and sets its MovementBehavior back to its initial one.
	 */
	public void setUnmoved() {
		
		hasMoved = false;
		
	}
	
	/**
	 * Checks if the piece can move to the specified (x, y) coordinatae
	 * 
	 * @param x The x-position to move to
	 * @param y The y-position to move to
	 * @return Whether or not the piece can move to the specified position
	 */
	public boolean checkMove(int x, int y) {
		
		return mb.checkMove(this.x, this.y, x, y);
		
	}
	
	/**
	 * Retrieves the owner of the piece.
	 * 
	 * @return Returns the owner of the GamePiece object, represented as an int.
	 */
	public PlayerType getOwner() {
		
		return this.owner;
		
	}
	
	/**
	 * Retrieve the type of the piece 
	 * 
	 * @return The type of the piece
	 */
	public PieceType getType() {
		
		return this.type;
		
	}
	
	/**
	 * Sets the x-position of the piece
	 * 
	 * @param x The new x-position
	 */
	public void setX(int x) {
		
		this.x = x;
		
	}
	
	/**
	 * Sets the y-position of the piece
	 * 
	 * @param y The new y-position
	 */
	public void setY(int y) {
		
		this.y = y;
		
	}
	
	/**
	 * Retrieves the x-position of the piece
	 * 
	 * @return The current x-position of the piece
	 */
	public int getX() {
		
		return this.x;
		
	}
	
	/**
	 * Retrieves the y-position of the piece
	 * 
	 * @return The current y-position of the piece
	 */
	public int getY() {
		
		return this.y;
		
	}
	
	/**
	 * Sets the move behavior of the piece
	 * 
	 * @param mb THe move behavior to give to the piece
	 */
	public void setMoveBehavior(MoveBehavior mb) {
		
		this.mb = mb;
		
	}
	
	/**
	 * Returns a string containing information about the piece.
	 */
	public String toString() {
		
		return "Type: " + this.type + ", Owner: " + this.owner + ", Position: " + "(" + this.x + ", " + this.y + ")";
		
	}
	
}
