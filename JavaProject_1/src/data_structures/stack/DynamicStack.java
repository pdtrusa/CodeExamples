package data_structures.stack;

public class DynamicStack 
{
	int capacity = 2;
	int[] stack = new int[capacity];
	int index=0;
	
	public void push(int data) {
		if(index == capacity)
			expandStack();
		stack[index] = data;
		index++;
	}
	
	public int pop() {
		if(index<=0) { 
			System.err.println("Stack is Empty");
			return 0;
		}
		int retVal = stack[index-1];
		stack[index-1] = 0;
		index--;
		shrinkStack();
		return retVal;
	}
	
	private void expandStack() {
		int[] newStack = new int[capacity*2];
		System.arraycopy(stack, 0, newStack, 0, index);
		stack = newStack;
		capacity *=2;
	}
	
	private void shrinkStack() {
		int length=size();
		if(length <= (capacity/2)/2)
			capacity = capacity/2;
		
		int[] newStack = new int[capacity];
		System.arraycopy(stack, 0, newStack, 0, index);
		stack = newStack;
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
		DynamicStack stack = new DynamicStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		
		stack.printStack();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("Size:"+stack.size());
		System.out.println("Is Empty:"+stack.isEmpty());
	}
}
