package tree;

class Node15{
	int key;
	
	// self referencing structure
	Node15 left, right;
	
	Node15(int key){
		this.key = key;
	}
}

public class BinaryTreeToDLL {

	public static void main(String[] args) {
		Node15 root = new Node15(10);
		root.left = new Node15(5);
		root.right = new Node15(20);
		root.right.left = new Node15(30);
		root.right.right = new Node15(35);
		
		toDll(root);
	}

	private static void toDll(Node15 root) {
		if(root!=null) {
			toDll(root.left);
			toDll(root.right);
			
		}
	}

}
