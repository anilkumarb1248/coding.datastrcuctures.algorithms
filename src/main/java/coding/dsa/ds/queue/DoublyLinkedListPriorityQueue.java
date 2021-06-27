package coding.dsa.ds.queue;

class Node1 {
	int data;
	Node1 next;
	Node1 prev;

	public Node1(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

// We are inserting the numbers. assuming high priority with max to min numbers
class PriorityQueue {
	private Node1 front;
	private Node1 rear;

	public PriorityQueue() {
		front = null;
		rear = null;
	}

	public void enqueu(int element) {
		Node1 node = new Node1(element);
		if (isEmpty()) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			node.prev = rear;
			rear = node;
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Priority Queue is empty");
			return -1;
		} else {
			Node1 highPriorityNode = getHighPrioryNode();

			if (highPriorityNode.prev == null && highPriorityNode.next == null) {
				front = null;
				rear = null;

			} else if (highPriorityNode.prev == null && highPriorityNode.next != null) {
				front = highPriorityNode.next;
				highPriorityNode.next.prev = null;

			} else if (highPriorityNode.prev != null && highPriorityNode.next == null) {
				rear = highPriorityNode.prev;
				highPriorityNode.prev.next = null;
			} else {
				highPriorityNode.prev.next = highPriorityNode.next;
				highPriorityNode.next.prev = highPriorityNode.prev;
			}

			highPriorityNode.prev = null;
			highPriorityNode.next = null;

			return highPriorityNode.data;
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Priority Queue is empty");
			return -1;
		} else {
			return getHighPrioryNode().data;
		}
	}

	private Node1 getHighPrioryNode() {
		Node1 highPriorityNode = front;
		Node1 currentNode = front;
		while (currentNode != null) {
			if (currentNode.data > highPriorityNode.data) {
				highPriorityNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		return highPriorityNode;
	}

	public boolean isEmpty() {
		return front == null && rear == null;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Priority Queue is empty");
		} else {
			System.out.print("Priority Queue data: [ ");
			Node1 currentNode = front;
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
			System.out.print("] \n");
		}
	}
}

public class DoublyLinkedListPriorityQueue {

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.enqueu(1);
		queue.enqueu(10);
		queue.enqueu(15);
		queue.display(); // Priority Queue data: [ 1 10 15 ]

		queue.enqueu(8);
		queue.enqueu(2);
		queue.display(); // Priority Queue data: [ 1 10 15 8 2 ]

		System.out.println("peek data: " + queue.peek()); // peek data: 15

		System.out.println(queue.dequeue()); // 15
		queue.display(); // Priority Queue data: [ 1 10 8 2 ]

		System.out.println(queue.dequeue()); // 10
		queue.display(); // Priority Queue data: [ 1 8 2 ]

		System.out.println(queue.dequeue()); // 8
		queue.display(); // Priority Queue data: [ 1 2 ]

		System.out.println(queue.dequeue()); // 2
		System.out.println(queue.dequeue()); // 1
		System.out.println(queue.dequeue()); // Priority Queue is empty
		queue.display(); // Priority Queue is empty
	}
}


