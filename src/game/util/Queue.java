package game.util;

public class Queue<E> {

	private QueueNode<E> head;
	private int size;
	
	public Queue() {
		
		head = null;
		size = 0;
		
	}
	
	/**
	 * Appends an element to the end of the queue.
	 * 
	 * @param data The element to add to the end of the queue.
	 */
	public void enqueue(E data) {
		
		if(head == null) {
			
			head = new QueueNode<E>(data);
			
		} else {
			
			QueueNode<E> currNode = head;
			
			while(currNode.getNext() != null) {
				
				currNode = currNode.getNext();
				
			}
			
			currNode.setNext(new QueueNode<E>(data));
			
		}
		
		size++;
		
	}
	
	/**
	 * Returns the element at the head of the queue without removing it.
	 * 
	 * @return The element at the head of the queue.
	 */
	public E peek() {
		
		if(head != null) {
			
			return head.getData();
			
		}
		
		return null;
		
	}
	
	/**
	 * Removes the element at the head of the queue and returns it.
	 * 
	 * @return The element removed from the head of the queue.
	 */
	public E dequeue() {
		
		if(head != null) {
			
			E desire = head.getData();
			
			head = head.getNext();
			
			size--;
			
			return desire;
			
		}
		
		return null;
		
	}
	
	/**
	 * Checks whether or not the queue is empty.
	 * 
	 * @return Returns true if the queue is empty. Returns true otherwise.
	 */
	public boolean isEmpty() {
		
		return head == null;
		
	}
	
	public String toString() {
		
		String desire = "";
		
		QueueNode<E> currNode = head;
		
		while(currNode != null) {
			
			desire += currNode.getData().toString() + "\n";
			
			currNode = currNode.getNext();
		}
		
		return desire;
		
	}
	
}
