package data_structures.stack;

public class Stack {

	
	int[] stack = new int[5];
	int index=0;
	
	public void push(int data) {
		stack[index] = data;
		index++;
	}
	
	public int pop() {
		if(isEmpty())
			System.err.println("Stack is Empty");
		int retVal = stack[index];
		stack[index] = 0;
		index--;
		return retVal;
	}
	
	public int peek(int valueAt) {
		return stack[valueAt];
	}
	
	public int size() {
		return index;
	}
	
	public boolean isEmpty() {
		return index<=0;
	}
	
	public void printStack() {
		System.out.println("Values in Stack :");
		
		for(int i : stack)
			System.out.println(i);
		
		System.out.println("----------------------");
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.printStack();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("Size:"+stack.size());
		System.out.println("Is Empty:"+stack.isEmpty());
	}
}
