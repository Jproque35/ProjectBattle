package game.view.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import game.controllers.BoardSpaceController;
import game.managers.BoardColorManager;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.TurnManager;

public class BoardSpaceComponent extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5530240700433795092L;
	
	protected int x;
	protected int y;
	protected GameManager gm;
	protected GameBoardComponent parentView;
	protected TurnManager tm;
	protected BoardManager bm;
	protected MovementManager mm;
	protected BoardColorManager bcm;
	protected PieceManager pm;
    
    public BoardSpaceComponent(GameManager gm, GameBoardComponent parentView, int x, int y) {
    	
    	super();
    	this.x = x;
    	this.y = y;
    	this.gm = gm;
    	this.parentView = parentView;
    	this.mm = gm.getMovementManager();
    	this.pm = gm.getPieceManager();
    	this.bm = gm.getBoardManager();
    	this.tm = gm.getTurnManager();
    	this.bcm = gm.getBoardColorManager();
    	
    	init();
    	
    }
    
    /**
     * Sets the image displayed on the board space.
     * 
     * @param image A String containing the path to the image file to set.
     */
    public void setImage(String image) {
    	
    	setIcon(new ImageIcon(image));
    	
    }
    
    /**
     * Initialization method called upon creation. Sets up the necessary information for the BoardSpace
     * to use during the game. 
     */
    private void init() {
        setBorder(null);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        
        addMouseListener(new BoardSpaceController(gm, x, y));
    }
    
    public void updateView() {
    	
		if(!bm.isEmpty(x,y)) {
			
			String currId = bm.get(x, y);
			
			this.setImage( pm.get(currId).getImage() );
			
		} else {
			
			this.setImage(null);
			
		}
		
    	if(bcm.isHighlighted(x, y)) {
    		
    		this.setBackground(bcm.getColor(x, y));
    		this.setOpaque(true);
    		
    	} else {
    		
    		this.setOpaque(false);
    		
    	}
    	
    	if(!tm.getCurrentPiece().equals("") && sameCoords()) {
    		
    		this.setBackground(Color.cyan);
    		this.setOpaque(true);
    		
    	}
    	
    }

	private boolean sameCoords() {
		return pm.get(tm.getCurrentPiece()).getX() == x 
    			&& pm.get(tm.getCurrentPiece()).getY() == y;
	}

}
