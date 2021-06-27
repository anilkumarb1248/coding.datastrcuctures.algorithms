package coding.dsa.ds.linkedlist;

public class SingleLinkedList {

	// head node of list
	private Node<Integer> head;

	// Linked list Node.
	// This inner class is made static so that main() can accessit
	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {

		Node<Integer> firstNode = new Node<>(10);
		Node<Integer> secondNode = new Node<>(20);
		Node<Integer> thirdNode = new Node<>(30);
		Node<Integer> fourthNode = new Node<>(40);
		Node<Integer> fifthNode = new Node<>(50);

		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.head = firstNode;

		linkedList.head.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		fourthNode.next = fifthNode;

		linkedList.printListItems();
	}

	/* This function prints contents of linked list starting from head */
	public void printListItems() {
		Node<Integer> nextNode = head;

		// Loop the nodes until the next is null
		while (nextNode != null) {
			System.out.println(nextNode.data);
			nextNode = nextNode.next;
		}
	}
}
