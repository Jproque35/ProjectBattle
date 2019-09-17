package tests.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.util.Queue;

class QueueTests {

	@Test
	void peekEmptyTest() {
		
		Queue<String> q = new Queue<String>();
		
		assertEquals(q.peek(), null);
		
	}
	
	@Test
	void enqueueSingleTest() {
		
		Queue<String> q = new Queue<String>();
		
		q.enqueue("Lan");
		assertEquals("Lan", q.peek());
	}
	
	@Test
	void enqueueMultipleTest() {
		
		Queue<String> q = new Queue<String>();
		
		q.enqueue("Lan");
		q.enqueue("Hub");
		q.enqueue("Mayl");
		q.enqueue("Dex");
		
		assertEquals("Lan", q.peek());
		
	}
	
	@Test
	void dequeueEmptyTest() {
		
		Queue<String> q = new Queue<String>();
		
		assertEquals(null, q.dequeue());
		
	}
	
	@Test
	void dequeueSingleTest() {
		
		Queue<String> q = new Queue<String>();
		
		q.enqueue("Lan");
		
		assertEquals("Lan",q.dequeue());
		assertEquals(null, q.peek());
		
	}
	
	@Test
	void dequeueMultipleTest() {
		
		Queue<String> q = new Queue<String>();
		
		q.enqueue("Lan");
		q.enqueue("Hub");
		q.enqueue("Mayl");
		q.enqueue("Dex");
		
		assertEquals("Lan",q.dequeue());
		assertEquals("Hub", q.peek());
		
		assertEquals("Hub", q.dequeue());
		assertEquals("Mayl", q.peek());
		
		assertEquals("Mayl", q.dequeue());
		assertEquals("Dex", q.peek());
		
		assertEquals("Dex", q.dequeue());
		assertEquals(null, q.peek());
	}

}
