package data_structures.queue;

public class Queue 
{
	int[] queue = new int[5];
	int front;
	int rear;
	int size;
	
	public void enQueue(int data) {
		queue[rear] = data;
		rear++;
		size++;
	}
	
	public int deQueue() {
		int retVal = queue[front];
		front++;
		size--;
		return retVal;
	}
	
	public void printQueue() {
		System.out.println("Elements in Queue :");
		
		for(int i : queue) 
			System.out.println("value : "+i);
		
		System.out.println("-----------------");
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.printQueue();
		
		System.out.println("Deque : "+queue.deQueue());
	}

	
}
