package coding.dsa.ds.queue;

import java.util.Arrays;

class ArrayQueue {

	int front;
	int rear;
	String[] array;
	int capacity;

	public ArrayQueue(int size) {
		array = new String[size];
		front = -1;
		rear = -1;
		capacity = size;
	}

	public void enqueue(String element) {
		if (isFull()) {
			System.out.println("Queue is full");
		} else {
			if (front == -1)
				front = 0;
			rear++;
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
			if (front < rear) {
				front++;
			} else {
				front = -1;
				rear = -1;
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
		return front == -1;
	}

	public boolean isFull() {
		return front == 0 && rear == capacity - 1;
	}

	public void display() {
		// Need to loop and display the elements.
		// For simplicity using Arrays class

//		if (isEmpty()) {
//			System.out.println("Queue is empty");
//		} else {
//			for (int index = front; index <= rear; index++) {
//				System.out.println(array[index]);
//			}
//		}

		System.out.println(Arrays.toString(array));
	}
}

public class ArrayImplementationQueue {
	public static void main(String[] args) {

		ArrayQueue queue = new ArrayQueue(3);
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.display(); // [A, B, C]
		queue.enqueue("D"); // Queue is full

		System.out.println("dequeue first call:");
		queue.dequeue();
		queue.display(); // [null, B, C]

		System.out.println("dequeue second call:");
		queue.dequeue();
		queue.display(); // [null, null, C]

		System.out.println("dequeue third call:");
		queue.dequeue();
		queue.display(); // [null, null, null]

		System.out.println("dequeue fourth call:");
		queue.dequeue(); // Queue is empty

		queue.enqueue("E");
		queue.enqueue("F");
		queue.display(); // [E, F, null]

		System.out.println(queue.peek()); // E - It doesn't delete the element
		queue.display(); // [E, F, null]

	}
}
