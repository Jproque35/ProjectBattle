package game.util;

import java.util.ArrayList;

import game.managers.GameManager;

public class Algorithms {

	public static ArrayList<Coordinate> getShortestPath(String id, GameManager gm, int x, int y) {
		
		ShortestPath shortestPath = new ShortestPath();
		return shortestPath.getShortestPath(id, gm, x, y);
		
	}
	
}
