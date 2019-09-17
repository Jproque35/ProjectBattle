package game.view.components;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.entities.identities.PlayerType;
import game.managers.GameManager;
import game.managers.TurnManager;

public class StatusBarComponent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel currTurnLabel;
	protected JLabel currPlayerLabel;
	protected int turnNumber;
	protected PlayerType currPlayer; 
	protected GameManager gm;
	protected TurnManager tm;
	
	public StatusBarComponent(GameManager gm) {
		
		this.gm = gm;
		this.tm = gm.getTurnManager();
		currTurnLabel = new JLabel();
		currPlayerLabel = new JLabel();
		
		init();
	}
	
	private void init() {
			
		this.setLayout(new GridLayout());
		this.add(currTurnLabel);
		this.add(currPlayerLabel);
		updateView();
		
	}
	
	private void updateTurnNumber() {
		
		currTurnLabel.setText("Turn Number: " + tm.getCurrentTurn());
		
	}
	
	private void updateCurrentPlayer() {
		
		String currPlayerName = "";
		
		if(tm.getCurrentPlayer() == PlayerType.WHITE) {
			currPlayerName = "White";
		} else if(tm.getCurrentPlayer() == PlayerType.BLACK) {
			currPlayerName = "Black";
		}
		
		currPlayerLabel.setText("Current Player " + currPlayerName);
		
	}
	
	public void updateView() {
		
		updateTurnNumber();
		updateCurrentPlayer();
		
	}
	
}
