package datastructurestut;

public class StackImpl {
	int LENGTH_OF_STACK = 0;
	private int [] myStack = null;
	int topOfStack = 0;
	
	public StackImpl(int sizeOfStack) {
		this.LENGTH_OF_STACK = sizeOfStack;
		myStack = new int[LENGTH_OF_STACK];
		topOfStack = 0;
	}
	
	private int sizeOfStack() {
		return (LENGTH_OF_STACK - (topOfStack + 1));		
	}
	
	public void push(int number) throws DataStructureException {
		if(sizeOfStack() < 0) {
			throw new DataStructureException("Your stack is full!");
		}
		myStack[topOfStack] = number;
		topOfStack++;
		
	}
	
	public int pop() throws DataStructureException {		
		if(sizeOfStack() == (LENGTH_OF_STACK-1)) {
			throw new DataStructureException("No more elements in the stack!");
		}	
		topOfStack--;
		int numberToPop = myStack[topOfStack];		
		return numberToPop;
	}
	

}
