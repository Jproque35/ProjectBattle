package game.util;

import java.util.ArrayList;
import java.util.Iterator;

public class ShortestPathNode {

	private int x;
	private int y;
	private int distance;
	private ShortestPathNode prev;
	private ArrayList<ShortestPathNode> children;
	
	/**
	 * A node respresenting a space on the GameBoard. Made specifically for use with the
	 * ShortestPath (Dijkstra's) Algorithm. 
	 * 
	 * @param x The x-coordinate of the space, represented as an int.
	 * @param y The y-coordiante of the space, represented as an int.
	 */
	public ShortestPathNode(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.distance = Integer.MAX_VALUE;
		children = new ArrayList<ShortestPathNode>();
		
	}
	
	/**
	 * Retrieves the x-coordinate of the space represented by this node.
	 * 
	 * @return The x-coordinate of the space represented by this nod, represented as an int.
	 */
	public int getX() {
		
		return x;
		
	}
	
	/**
	 * Retrieves the y-coordinate of the space represented by this node
	 * 
	 * @return The y-coordinate of the space represented by this node, represented as an int.
	 */
	public int getY() {
		
		return y;
		
	}
	
	/**
	 * Retrieves a list of all of the node's children, i.e. spaces that can be traversed from
	 * the node.
	 * 
	 * @return An ArrayList containing the children of this node.
	 */
	public ArrayList<ShortestPathNode> getChildren() {
		
		return children;
		
	}
	
	/**
	 * Adds a child to the node.
	 * 
	 * @param node The node to assign as a child to this node.
	 */
	public void addChild(ShortestPathNode node) {
		
		children.add(node);
		
	}
	
	/**
	 * Retrieves the distance of the node from the root of the tree. Only modified when running
	 * the ShortestPath algorithm.
	 * 
	 * @return
	 */
	public int getDistance() {
		
		return distance;
		
	}
	
	public void setDistance(int distance) {
		
		this.distance = distance;
		
	}
	
	public ShortestPathNode getPrev() {
		
		return prev;
		
	}
	
	public void setPrev(ShortestPathNode prev) {
		
		this.prev = prev;
		
	}
	
	public String toString() {
		
		String childrenString = "";
		
		Iterator<ShortestPathNode> childrenIterator = children.iterator();
		
		while(childrenIterator.hasNext()) {
			
			ShortestPathNode currChild = childrenIterator.next();
			
			childrenString += "<" + currChild.getX() + ", " + currChild.getY() + "> ";
			
		}
		
		return "<" + x + ", " + y + ">" + " Distance: " + distance + " Children: " + childrenString;
		
	}
	
}
