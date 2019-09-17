package game.managers;

import java.awt.Color;

/**
 * @author duren
 *
 */
public abstract class BoardColorManager {

	protected Color[][] colors;
	protected boolean[][] highlighted;
	protected BoardManager bm;
	
	public BoardColorManager(GameManager gm) {
		
		this.bm = gm.getBoardManager();
		
		colors = new Color[bm.getWidth()][bm.getLength()];
		highlighted = new boolean[bm.getWidth()][bm.getLength()];
		
	}
	
	/**
	 * Returns whether or not the specified space is highlighted.
	 * 
	 * @param x The x-coordinate of the space to check.
	 * @param y The y-coordinate of the space to check.
	 * @return Returns true if the designated space is highlighted. Otherwise, returns false.
	 */
	public boolean isHighlighted(int x, int y) {
		
		return highlighted[x][y];
		
	}
	
	/**
	 * Marks the specified space as highlighted. 
	 * 
	 * @param x The x-coordinate of the space to highlight. 
	 * @param y The y-coordinate of the space to highlight.
	 */
	public void highlight(int x, int y) {
		
		this.highlighted[x][y] = true;
		
	}
	
	/**
	 * Clears a designated space of a highlight.
	 * 
	 * @param x The x-coordinate of the space to clear.
	 * @param y The y-coordiante of the space to clear.
	 */
	public void clearHighlight(int x, int y) {
		
		this.highlighted[x][y] = false;
		
	}
	
	/**
	 * Retrieves the color of the specified space. 
	 * 
	 * @param x The x-coordinate of the space to check.
	 * @param y The y-coordinate of the space to check.
	 * @return Returns the color of the space.
	 */
	public Color getColor(int x, int y) {
		
		return this.colors[x][y];
		
	}
	
	/**
	 * Sets the color of a specified space. 
	 * 
	 * @param color The color to set the space.
	 * @param x The x-coordinate of the space to color.
	 * @param y The y-coordinate of the space to color.
	 */
	public void setColor(Color color, int x, int y) {
		
		this.colors[x][y] = color;
		
	}
	
}
