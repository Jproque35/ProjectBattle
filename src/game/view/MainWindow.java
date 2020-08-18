package game.view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.managers.*;
import game.view.components.GameBoardComponent;
import game.view.components.StatusBarComponent;

public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1535066447031170268L;
	
	private GameBoardComponent boardView;
	private StatusBarComponent statusBarView;
	private NotificationManager nm;
	
	/**
	 * The MainWindow object serves as the primary container for presenting information about the game.
	 * It houses several sub-components, each of which is responsible for displaying specific information
	 * to the user.
	 * 
	 * @param gm The primary GameManager object that the MainWindow bject will work with.
	 */
	public MainWindow(GameManager gm) {
	;
		this.boardView = new GameBoardComponent(gm);
		this.statusBarView = new StatusBarComponent(gm);
		this.nm = gm.getNotificationManager();
		
		init();
		
	}
	
	/**
	 * Initializes any necessary functions to display in the MainWindow object.
	 */
	private void init() {
        
		this.setResizable(false);
		this.setTitle("Untitled Chess Game");
		
        JPanel testPanel = new JPanel();
        testPanel.setLayout(new BoxLayout(testPanel, 1));
        
        testPanel.add(boardView);
        boardView.setAlignmentX(Component.CENTER_ALIGNMENT);
        testPanel.add(statusBarView);
        this.add(testPanel);
        
        this.pack();
	}
	
	/**
	 * Updates all of the individual components contained within the MainWindow object.
	 */
	public void updateView() {
		
		boardView.updateView();
		statusBarView.updateView();
		
		
		if(nm.isNotificationReady()) {
			
			JOptionPane.showMessageDialog(this, nm.sendNotification());
			
		}
		
		
	}
	
}
