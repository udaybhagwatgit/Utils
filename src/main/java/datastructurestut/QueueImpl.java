package datastructurestut;

public class QueueImpl {

	private int SIZE_OF_QUEUE;
	private int[] myQueue = null;
	
	private int head = -1;
	private int tail = -1;
	
	public QueueImpl(int size) {
		this.SIZE_OF_QUEUE = size;
		myQueue = new int[SIZE_OF_QUEUE];
	}
	
	public boolean isEmpty() {
		return (head == -1);
	}
	
	public int sizeOfQueue() {
		if(head == -1 && tail == -1) {
			return 0;
		}
		return tail - (head + 1);
	}
	
	public void enQueue(int n) throws DataStructureException {
		if(sizeOfQueue() == SIZE_OF_QUEUE) {
			throw new DataStructureException("QUEUE is Full");
		}
		if(tail == SIZE_OF_QUEUE - 1) {
			tail = -1;
		}
		tail++;
		myQueue[tail] = n;
	}
	
	public int deQueue() throws DataStructureException {
		if(sizeOfQueue() == 0 && head > tail) {
			throw new DataStructureException("QUEUE is Empty");
		}
		if(head == SIZE_OF_QUEUE - 1 && tail > 0) {
			head = -1;
		}
		head++;
		int item = myQueue[head];
		return item;
	}
}
