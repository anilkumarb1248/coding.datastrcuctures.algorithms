package coding.dsa.ds.stack;

import java.util.Arrays;

class ArrayStack {
	private int array[];
	private int top;
	private int capacity;

	public ArrayStack(int size) {
		this.array = new int[size];
		this.capacity = size;
		top = -1;
	}

	public boolean push(int element) {
		if (isFull()) {
			// throw new RuntimeException("Stack is full");
			return false;
		}
		array[++top] = element;
		return true;
	}

	public int pop() {
		if (isEmpty()) {
			// throw new RuntimeException("Stack is empty");
			return -1;
		}
		return array[top--];
	}

	public int peek() {
		if (isEmpty()) {
			// throw new RuntimeException("Stack is empty");
			return -1;
		}
		return array[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public void printStack() {
		System.out.print("Stack elements: ");
		for (int i = 0; i <= top; i++) {
			if (i == top)
				System.out.print(array[i]);
			else
				System.out.print(array[i] + ", ");
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}
}

public class ArrayImplementationStack {

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack(3);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.printStack(); // 10, 20, 30
		stack.push(40); // Not inserted - stack is full
		System.out.println(stack.push(50));// returned false as no insertion
		stack.printStack(); // 10, 20, 30
		System.out.println("Is stack full: " + stack.isFull()); // true

		System.out.println(stack.peek()); // 30
		System.out.println(stack.peek()); // 30

		stack.pop();
		stack.pop();
		stack.printStack(); // 10
		System.out.println("Is stack empty: " + stack.isEmpty()); // false
		stack.push(100);
		stack.printStack();// 10, 100
		stack.pop();
		stack.pop();

		System.out.println("Is stack empty: " + stack.isEmpty()); // true
		System.out.println(stack.peek()); // -1
	}
}
