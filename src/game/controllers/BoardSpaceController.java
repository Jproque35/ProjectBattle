package game.controllers;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game.managers.BoardColorManager;
import game.managers.BoardManager;
import game.managers.GameManager;
import game.managers.MovementManager;
import game.managers.PieceManager;
import game.managers.StandardMovementManager;
import game.managers.TurnManager;

public class BoardSpaceController extends MouseAdapter {

	private GameManager gm;
	private PieceManager pm;
	private MovementManager mm;
	private BoardManager bm;
	private TurnManager tm;
	private BoardColorManager bcm;
	private int x;
	private int y;
	
	public BoardSpaceController(GameManager gm, int x, int y) {
		
		this.gm = gm;
		this.pm = gm.getPieceManager();
		this.mm = gm.getMovementManager();
		this.bm = gm.getBoardManager();
		this.tm = gm.getTurnManager();
		this.bcm = gm.getBoardColorManager();
		this.x = x;
		this.y = y;
		
	}
	
	
    @Override
    public void mouseEntered(MouseEvent e) {
    	
    	String currId = tm.getCurrentPiece();
    	
    	if(currId.equals("")) {
    		
    		if(validPiece(bm.get(x, y))) {
    			
    			colorSpace(Color.yellow);
    			
    		} else if(!bm.isEmpty(x, y)){
    			
    			colorSpace(Color.red);
    			
    		} else {
    			
    			colorSpace(Color.yellow);
    			
    		}
    		
    	} else if(!currId.equals("") && mm.checkMove(currId, x, y)) {
    		
    		colorSpace(Color.yellow);
    		
    	} else if(!currId.equals("") && !mm.checkMove(currId, x, y)) {

    		colorSpace(Color.red);
    		
    	}
    		
    	gm.updateView();

    }

	private void colorSpace(Color color) {
		bcm.setColor(color, x, y);
		bcm.highlight(x, y);
	}

    @Override
    public void mouseExited(MouseEvent e) {
    	
    	bcm.clearHighlight(x, y);
   
    	gm.updateView();
    	
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    	
    	String currId = tm.getCurrentPiece();
    	
    	if(currId.equals("") && validPiece(bm.get(x, y))) {
    		
    		tm.setCurrentPiece(bm.get(x, y));
    		
    	} else if(!currId.equals("") && mm.checkMove(currId, x, y)) {
    		
    		if(!((StandardMovementManager) mm).moveCausesCheck(currId, x, y)) {

        		mm.move(currId, x, y);
        		tm.setCurrentPiece("");
        		tm.nextTurn();    
    			
    		} else {
    			
    			System.out.println("This movement causes check; illegal move");
    			
    		}
    		
    	} else if(!currId.equals("") && !mm.checkMove(currId,  x,  y)) {
    		
    		tm.setCurrentPiece("");
    		
    	}else if(currId.equals(bm.get(x, y))) {

    		tm.setCurrentPiece("");
    		
    	}
    	
    	gm.updateView();
    }
    
    private boolean validPiece(String id) {
    	
    	if(pm.contains(id)) {
    		
    		return pm.get(id).getOwner() == tm.getCurrentPlayer();
    		
    	}
    	
    	return false;
    	
    }
}
