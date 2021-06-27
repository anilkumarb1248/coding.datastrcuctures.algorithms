package coding.dsa.ds.stack;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedListStack {
	private Node top;

	public LinkedListStack() {
		top = null;
	}

	public void push(int data) {
		Node node = new Node(data);
		if (top != null) {
			node.next = top;
		}
		top = node;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		} else {
			int topNodeData = top.data;
			top = top.next;
			return topNodeData;
		}

	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		} else {
			return top.data;
		}
	}

	public int size() {
		int size = 0;
		Node topNode = top;
		while (topNode != null) {
			size++;
			topNode = topNode.next;
		}
		return size;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void printStack() {
		System.out.print("Stack elements: ");
		Node topNode = top;
		while (topNode != null) {
			System.out.print(topNode.data + " ");
			topNode = topNode.next;
		}
		System.out.println();
	}
}

public class LinkedListImplementationStack {

	public static void main(String[] args) {

		LinkedListStack stack = new LinkedListStack();
		stack.push(10);
		stack.push(20);
		stack.printStack(); // 20 10
		stack.push(30);
		stack.push(40);
		stack.printStack(); // 40 30 20 10

		System.out.println(stack.peek()); // 40
		System.out.println(stack.peek()); // 40

		stack.pop();
		stack.printStack(); // 30 20 10
		stack.pop();
		stack.printStack(); // 20 10

		System.out.println("Is stack empty: " + stack.isEmpty()); // false
		stack.pop();
		stack.pop();
		System.out.println("Is stack empty: " + stack.isEmpty()); // true
		// stack.pop(); // java.lang.RuntimeException: Stack is empty
		// stack.peek(); // java.lang.RuntimeException: Stack is empty
	}
}
