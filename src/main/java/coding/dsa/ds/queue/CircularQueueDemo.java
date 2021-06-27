package coding.dsa.ds.queue;

import java.util.Arrays;

class CircularQueue {
	int front;
	int rear;
	String[] array;
	int capacity;

	public CircularQueue(int size) {
		array = new String[size];
		front = -1;
		rear = -1;
		capacity = size;
	}

	public void enqueue(String element) {

		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			if (front == -1 && rear == -1) {
				front = 0;
				rear = 0;
			} else if (front > 0 && rear == capacity - 1) {
				rear = 0;
			} else {
				rear++;
			}
			array[rear] = element;
		}
	}

	public String dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			String element = array[front];
			array[front] = null;
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == capacity - 1) {
				front = 0;
			} else {
				front++;
			}
			return element;
		}
	}

	public String peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		} else {
			return array[front];
		}
	}

	public boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	public boolean isFull() {
		if (front == 0 && rear == capacity - 1) {
			return true;
		} else if (front > 0 && rear + 1 == front) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		System.out.println(Arrays.toString(array));
	}
}

public class CircularQueueDemo {

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(5);
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		queue.enqueue("E");
		queue.display(); // [A, B, C, D, E]

		queue.enqueue("F"); // Queue is full

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.display(); // [null, null, null, D, E]

		queue.enqueue("G");
		queue.enqueue("H");
		queue.display(); // [G, H, null, D, E]
		queue.enqueue("I");
		queue.display(); // [G, H, I, D, E]
		queue.enqueue("J"); // Queue is full

		queue.dequeue();
		queue.dequeue();
		queue.display(); // [G, H, I, null, null]

		queue.dequeue();
		queue.display(); // [null, H, I, null, null]

		queue.dequeue();
		queue.dequeue();
		queue.display(); // [null, null, null, null, null]
		queue.dequeue(); // Queue is empty

		queue.enqueue("K");
		queue.enqueue("L");
		queue.enqueue("M");
		queue.display(); // [K, L, M, null, null]

		System.out.println(queue.peek()); // K - it doesn't delete element
		queue.display(); // // [K, L, M, null, null]
	}
}
