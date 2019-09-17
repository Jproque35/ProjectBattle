package game.main;

import java.awt.EventQueue;

import game.managers.GameManager;
import game.managers.StandardGameManager;
import game.view.MainWindow;

public class ProjectBattle {

	public static void main(String[] args) {
		GameManager gm = new StandardGameManager();
		MainWindow view = new MainWindow(gm);
		gm.init(view);
		//view.setVisible(true);
		
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                view.setVisible(true);
            }
        });
        
	}
	
}
