package tests.util;

import game.util.Coordinate;
import game.util.Queue;

public class QueueManualTest {
	
	public static void main(String[] args) {
		
		Queue<Coordinate> q = new Queue<Coordinate>();
		
		q.enqueue( new Coordinate(0, 1) );
		q.enqueue( new Coordinate(5, 5) );
		q.enqueue( new Coordinate(2, 7) );
		
		q.dequeue();
		q.dequeue();
		
		System.out.println(q.toString());
		
	}
	
}
