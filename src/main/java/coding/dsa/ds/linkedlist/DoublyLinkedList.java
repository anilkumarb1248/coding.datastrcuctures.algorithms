package coding.dsa.ds.linkedlist;

public class DoublyLinkedList {

	private Node<Integer> head;
	private Node<Integer> tail;

	static class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static void main(String[] args) {

		Node<Integer> firstNode = new Node<>(10);
		Node<Integer> secondNode = new Node<>(20);
		Node<Integer> thirdNode = new Node<>(30);
		Node<Integer> fourthNode = new Node<>(40);
		Node<Integer> fifthNode = new Node<>(50);

		DoublyLinkedList list = new DoublyLinkedList();
		list.head = firstNode;
		list.tail = firstNode;

		list.head.next = secondNode;
		secondNode.prev = list.head;
		list.tail = secondNode;

		secondNode.next = thirdNode;
		thirdNode.prev = secondNode;
		list.tail = thirdNode;

		thirdNode.next = fourthNode;
		fourthNode.prev = thirdNode;
		list.tail = fourthNode;

		fourthNode.next = fifthNode;
		fifthNode.prev = fourthNode;
		list.tail = fifthNode;

		list.printElementsForward();
		list.printElementsBackward();
	}

	public void printElementsForward() {
		System.out.println("Printing the elments in Forward direction: ");

		Node<Integer> nextNode = head;
		while (nextNode != null) {
			System.out.print(nextNode.data + " ");
			nextNode = nextNode.next;
		}

	}

	public void printElementsBackward() {
		System.out.println("\n Printing the elments in Backward direction: ");

		Node<Integer> prevNode = tail;
		while (prevNode != null) {
			System.out.print(prevNode.data + " ");
			prevNode = prevNode.prev;
		}
	}

}
