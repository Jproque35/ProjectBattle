package game.view.components;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import game.managers.BoardManager;
import game.managers.GameManager;

public class GameBoardComponent extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7438262862377342101L;
	
	private ImageIcon background;
	private GameManager gm;
	private BoardManager bm;
	private BoardSpaceComponent[][] buttons;
	
	/**
	 * An object that contains a visual representation of the GameBoard object and whatever it contains.
	 * 
	 * @param window
	 * @param gm
	 */
	public GameBoardComponent(GameManager gm) {
		
		this.gm = gm;
		this.bm = gm.getBoardManager();
		this.buttons = new BoardSpaceComponent[bm.getWidth()][bm.getLength()];
		this.background = new ImageIcon("resources/images/boards/board_standard.png");
		
		init();
	}
	
	/**
	 * Initialize the GameBoardComponent object by assigning a background image and building the 
	 * BoardSpaceComponent objects and adding them to it.
	 */
	private void init() {
		
		this.setIcon(background);
        this.setLayout(new GridLayout(bm.getWidth(), bm.getLength(), 0, 0));
        
        buildSpaces();
        addSpaces();
        
        updateView();
	}

	/**
	 * Auxillary method. Adds all of the built BoardSpaceComponent objects to the GameBoardComponent 
	 * object so that they can be interacted with.
	 */
	private void addSpaces() {
		for(int i = bm.getWidth() - 1; i >= 0; i--) {
        	
        	for(int j = bm.getLength() - 1; j >= 0; j--) {
        		
        		this.add(buttons[j][i]);
        		
        	}
        	
        }
	}

	/**
	 * Auxilary method. Creates all of the necessary BoardSpaceComponents and stores them to be used
	 * later.
	 */
	private void buildSpaces() {
		for(int i = 0; i < bm.getWidth(); i++) {
        	
        	for(int j = 0; j < bm.getLength(); j++) {
        		
        		buttons[i][j] = new BoardSpaceComponent(gm, this, i, j);
        		
        	}
        	
        }
	}
	
	/**
	 * Updates the images displayed by the GameBoardComponent object and any objects it contains.
	 */
	public void updateView() {
		
        for(int i = 0; i < bm.getWidth(); i++) {
        	
        	for(int j = 0; j < bm.getLength(); j++) {
        		
        		buttons[i][j].updateView();
        		
        	}
        	
        }
		
	}
	
}
