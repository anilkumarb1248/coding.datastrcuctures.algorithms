package coding.dsa.ds.tree;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data) {
		// root = insertElement(root, data);
		insertElementWithLoop(data);
	}

	// Insert an element in the tree using loop
	private void insertElementWithLoop(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
		} else {
			Node insertNode = null;
			Node temp = root;
			while (temp != null) {
				insertNode = temp;
				if (data < temp.data) {
					temp = temp.left;
				} else {
					temp = temp.right;
				}
			}

			if (data < insertNode.data) {
				insertNode.left = newNode;
			} else {
				insertNode.right = newNode;
			}
		}
	}

	// Insert an element in the tree using recursive
	private Node insertElement(Node root, int data) {
		// Return a new node if the tree is empty
		if (root == null) {
			root = new Node(data);
			return root;
		}

		// Traverse to the right place and insert the node
		if (data < root.data) {
			root.left = insertElement(root.left, data);
		} else if (data > root.data) {
			root.right = insertElement(root.right, data);
		}
		return root;
	}

	// In Order means Ascending order
	public void displayInOrder() {
		displayElementsInOrder(root);
		System.out.println();
	}

	private void displayElementsInOrder(Node root) {
		if (root != null) {
			displayElementsInOrder(root.left);
			System.out.print(root.data + " ");
			displayElementsInOrder(root.right);
		}
	}

	// Post Order means Descending order
	public void displayPostOrder() {
		displayElementsPostOrder(root);
		System.out.println();
	}

	private void displayElementsPostOrder(Node root) {
		if (root != null) {
			displayElementsInOrder(root.right);
			System.out.print(root.data + " ");
			displayElementsInOrder(root.left);
		}
	}

	public boolean search(int data) {
		Node foundNode = searchElement(root, data);
		if (foundNode != null && foundNode.data == data)
			return true;
		else
			return false;
	}

	private Node searchElement(Node root, int data) {
		if (root == null || root.data == data) {
			return root;
		} else {
			if (data < root.data) {
				// Key is smaller than root's key
				return searchElement(root.left, data);
			} else {
				// Key is greater than root's key
				return searchElement(root.right, data);
			}
		}
	}

	public void delete(int data) {
		root = deleteElement(root, data);
	}

	// A recursive function to delete an existing key in BST
	private Node deleteElement(Node root, int data) {
		/* Base Case: If the tree is empty */
		if (root == null)
			return root;

		/* Otherwise, recur down the tree */
		if (data < root.data)
			root.left = deleteElement(root.left, data);
		else if (data > root.data)
			root.right = deleteElement(root.right, data);

		// if key is same as root's key, then This is the node to be deleted
		else {
			// node with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// node with two children: Get the inorder
			// successor (smallest in the right subtree)
			root.data = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteElement(root.right, root.data);
		}

		return root;
	}

	int minValue(Node root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

}

public class BinarySearchTreeDemo {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(3);
		tree.insert(8);
		tree.insert(13);
		tree.insert(18);

		tree.displayInOrder(); // 3 5 8 10 13 15 18
		tree.displayPostOrder(); // 13 15 18 10 3 5 8

		System.out.println("Is element 8 found: " + tree.search(8)); // true
		System.out.println("Is element 33 found: " + tree.search(33)); // false

		tree.delete(5);
		tree.displayInOrder(); // 3 8 10 13 15 18
		tree.delete(13);
		tree.displayInOrder(); // 3 8 10 15 18
	}
}
