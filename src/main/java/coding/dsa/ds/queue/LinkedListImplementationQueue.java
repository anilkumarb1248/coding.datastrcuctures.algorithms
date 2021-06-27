package coding.dsa.ds.queue;

class Node {
	String data;
	Node next;

	public Node(String data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedListQueue {
	Node front;
	Node rear;

	public LinkedListQueue() {
		front = null;
		rear = null;
	}

	public void enqueue(String element) {
		Node node = new Node(element);
		if (front == null && rear == null) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
	}

	public String dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			Node frontNode = front;
			String data = frontNode.data;

			if (front == rear) {
				front = null;
				rear = null;
			} else {
				front = frontNode.next;
				frontNode.next = null;
			}
			return data;
		}
	}

	public String peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			return front.data;
		}
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			System.out.print("Queue data: ");
			Node currentNode = front;
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
			System.out.println();
		}
	}
}

public class LinkedListImplementationQueue {

	public static void main(String[] args) {

		LinkedListQueue queue = new LinkedListQueue();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.display(); // Queue data: A B C

		System.out.println("dequeue first call:");
		queue.dequeue();
		queue.display(); // Queue data: B C

		System.out.println("dequeue second call:");
		queue.dequeue();
		queue.display(); // Queue data: C

		System.out.println("dequeue third call:");
		queue.dequeue();
		queue.display(); // Queue is empty

		System.out.println("dequeue fourth call:");
		queue.dequeue(); // Queue is empty

		queue.enqueue("E");
		queue.enqueue("F");
		queue.display(); // Queue data: E F

		System.out.println(queue.peek()); // E - It doesn't delete the element
		queue.display(); // Queue data: E F

	}
}
