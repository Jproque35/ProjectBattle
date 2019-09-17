package game.util;


import java.util.ArrayList;
import java.util.Iterator;

import game.managers.GameManager;

public class ShortestPath {
	
	/**
	 * Gets an ArrayList of Coordinates that contain all of the spaces to take on the shortest
	 * path.
	 * 
	 * @param id
	 * @param gm
	 * @param x
	 * @param y
	 * @return
	 */
	public ArrayList<Coordinate> getShortestPath(String id, GameManager gm, int x, int y) {
		
		ShortestPathTree tree = new ShortestPathTree(id, gm);
		
		tree.getRoot().setDistance(0);
		
		ArrayList<ShortestPathNode> nodeList = tree.getNodeList();
		
		return getShortestPathAux(nodeList, x, y);
		
	}
	
	/**
	 * Auxiliary function that contains the main execution for the shortest path algorithm.
	 * Given a list of nodes within a tree where each node corresponds to an adjacent space on
	 * the game board, the function finds the shortest path leading to the desired space if it
	 * exists.
	 * 
	 * @param list A list of nodes contained within the tree we are exploring.
	 * @param x The x-coordinate of the space we want to find.
	 * @param y The y-coordinate of the space we want to find.
	 * @return Returns an ArrayList of Coordinates that correspond to the spaces in the
	 * shortest path leading to the specified location. If the specified location cannot be
	 * reached, returns null.
	 */
	private ArrayList<Coordinate> getShortestPathAux(ArrayList<ShortestPathNode> list, int x, int y) {
		
		Iterator<ShortestPathNode> listIterator = list.iterator();
		
		while(listIterator.hasNext()) {
			
			ShortestPathNode currNode = listIterator.next();
			
			setChildDistances(currNode);	
			setChildPrevs(currNode);
			
			if(currNode.getX() == x && currNode.getY() == y) {
				
				return makePathList(currNode);
				
			}
			
		}
		
		return null;
		
	}

	/**
	 * Auxiliary method. Sets the prev field of a designated node's children to the designated
	 * node.
	 * 
	 * @param currNode The node we are working with.
	 */
	private void setChildPrevs(ShortestPathNode currNode) {
		
		Iterator<ShortestPathNode> childIterator = currNode.getChildren().iterator();
		
		while(childIterator.hasNext()) {
			
			ShortestPathNode childNode = childIterator.next();
			childNode.setPrev(currNode);
			
		}
		
	}

	/**Auxiliary method. Sets the distance for all of a designated node's children equal to
	 * the designated node's distance from the root plus one (where one is the distance between
	 * the designated node and its children).
	 * 
	 * @param node The node we are working with.
	 */
	private void setChildDistances(ShortestPathNode node) {

		Iterator<ShortestPathNode> childIterator = node.getChildren().iterator();
		
		while(childIterator.hasNext()) {
			
			ShortestPathNode currNode = childIterator.next();
			int newDist = node.getDistance() + 1;
			
			if(newDist < currNode.getDistance()) {
				
				currNode.setDistance(newDist);
				
			}
			
		}
	}
	
	/**
	 * Converts a node into an ArrayList of Coordinates that lead to the node.
	 * 
	 * @param node The node to start with
	 * @return An ArrayList that contains Coordinates that represent a path to the node.
	 */
	private ArrayList<Coordinate> makePathList(ShortestPathNode node) {
		
		if(node != null) {
			
			ArrayList<Coordinate> desire = new ArrayList<Coordinate>();
			
			ShortestPathNode currNode = node;
			
			while(currNode != null) {
				
				desire.add(new Coordinate(currNode.getX(), currNode.getY()));
				
				currNode = currNode.getPrev();
				
			}
			
			return desire;
			
		}
		
		return null;
		
	}
	
	
}
