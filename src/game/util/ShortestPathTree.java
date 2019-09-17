package game.util;

import java.util.ArrayList;
import java.util.Iterator;

import game.managers.*;

public class ShortestPathTree {
	
	String id;
	GameManager gm;
	PieceManager pm;
	MovementManager mm;
	ShortestPathNode root;
	ArrayList<ShortestPathNode> nodeList;
	
	public ShortestPathTree(String id, GameManager gm) {
		
		this.id = id;
		this.gm = gm;
		this.pm = gm.getPieceManager();
		this.mm = gm.getMovementManager();
		this.nodeList = new ArrayList<ShortestPathNode>();
		
		buildTree();
	}
	
	private void buildTree() {
		
		int x = pm.get(id).getX();
		int y = pm.get(id).getY();
		
		root = new ShortestPathNode(x, y);
		nodeList.add(root);
		ArrayList<Coordinate> visited = new ArrayList<Coordinate>();
		visited.add(new Coordinate(x, y));
		
		buildTreeAux(root, visited);
		
	}
	
	private void buildTreeAux(ShortestPathNode node, ArrayList<Coordinate> l) {
		
		addChildren(node, l);
		
		ArrayList<ShortestPathNode>  children = node.getChildren();
		Iterator<ShortestPathNode> childrenIterator = children.iterator();
		
		while(childrenIterator.hasNext()) {
			
			buildTreeAux(childrenIterator.next(), l);
			
		}
		
	}
	
	private void addChildren(ShortestPathNode node, ArrayList<Coordinate> l) {
		
		int x = node.getX();
		int y = node.getY();
		
		addChildrenAux(node, x + 1, y, l);
		addChildrenAux(node, x + 1, y + 1, l);
		addChildrenAux(node, x, y + 1, l);
		addChildrenAux(node, x - 1, y + 1, l);
		addChildrenAux(node, x - 1, y, l);
		addChildrenAux(node, x - 1, y - 1, l);
		addChildrenAux(node, x, y - 1, l);
		addChildrenAux(node, x + 1, y - 1, l);
		
	}

	private void addChildrenAux(ShortestPathNode node, int x, int y, ArrayList<Coordinate> l) {
		
		if(isChild(x, y) && !checkListContains(l, new Coordinate(x, y))) {
			
			ShortestPathNode newChild = new ShortestPathNode(x, y);
			
			node.addChild(newChild);
			nodeList.add(newChild);
			
			l.add(new Coordinate(x, y));
			
		}
		
	}
	
	private boolean checkListContains(ArrayList<Coordinate> l, Coordinate coord) {
		
		Iterator<Coordinate> coordIterator = l.iterator();
		
		while(coordIterator.hasNext()) {
			
			Coordinate currCoord = coordIterator.next();
			
			if(currCoord.equals(coord)) {
				
				return true;
			}
			
		}
		
		return false;
		
	}
	
	private boolean isChild(int x, int y) {
		
		return mm.checkMove(id, x, y);
		
	}
	
	public ShortestPathNode getRoot() {
		
		return root;
		
	}
	
	public ArrayList<ShortestPathNode> getNodeList() {
		
		ArrayList<ShortestPathNode> desire = new ArrayList<ShortestPathNode>();
		
		Iterator<ShortestPathNode> listIterator = nodeList.iterator();
		
		while(listIterator.hasNext()) {
			
			desire.add(listIterator.next());
			
		}
		
		return desire;
		
	}
	
	public String toString() {
		
		String desire = "";
		toStringAux(root, desire);
		
		return desire;
		
	}
	
	private void toStringAux(ShortestPathNode node, String acc) {
		
		System.out.println(node.toString());
		
		acc += node.toString() + "\n";
		
		ArrayList<ShortestPathNode>  children = node.getChildren();
		Iterator<ShortestPathNode> childrenIterator = children.iterator();
		
		while(childrenIterator.hasNext()) {
			
			toStringAux(childrenIterator.next(), acc);
			
		}
		
	}
	
}
