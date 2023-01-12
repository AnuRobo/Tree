package tree;

class Node{
	int key;
	
	// self referencing structure
	Node left;
	Node right;
	
	Node(int key ){
		this.key = key;
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
	}

}
