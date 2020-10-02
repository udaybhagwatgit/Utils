package datastructurestut;

public class Caller {

	public static void main(String[] args) {
		//runStack();
		runQueue();
	}
	
	public static void runStack() {
		StackImpl stackImpl = new StackImpl(4);
		try {
			//System.out.println(stackImpl.pop());
			

			stackImpl.push(1);
			stackImpl.push(2);
			stackImpl.push(3);
			System.out.println(stackImpl.pop());
			System.out.println(stackImpl.pop());
			stackImpl.push(4);
			System.out.println(stackImpl.pop());
			System.out.println(stackImpl.pop());

		} catch (DataStructureException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void runQueue() {
		QueueImpl queueImpl = new QueueImpl(13);
		try {
			queueImpl.enQueue(1);
			queueImpl.enQueue(2);
			queueImpl.enQueue(3);
			queueImpl.enQueue(4);
			queueImpl.enQueue(5);
			queueImpl.enQueue(6);
			queueImpl.enQueue(7);
			queueImpl.enQueue(8);
			queueImpl.enQueue(9);
			queueImpl.enQueue(10);
			queueImpl.enQueue(11);
			queueImpl.enQueue(12);
			queueImpl.enQueue(13);
			

			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			queueImpl.enQueue(14);
			queueImpl.enQueue(15);
			queueImpl.enQueue(16);
			queueImpl.enQueue(17);
			queueImpl.enQueue(18);
			queueImpl.enQueue(19);
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			queueImpl.enQueue(20);
			queueImpl.enQueue(21);
			queueImpl.enQueue(22);
			queueImpl.enQueue(23);
			queueImpl.enQueue(24);
			queueImpl.enQueue(25);
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			
			
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			System.out.println(queueImpl.deQueue());
			
			//System.out.println(queueImpl.deQueue());
		} catch (DataStructureException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
