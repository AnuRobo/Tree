package tree;

class Node9{
	int key;
	
	// self referencing structure
	Node9 left, right;
	
	Node9(int key){
		this.key = key;
	}
}

public class MaxInBinaryTree {

	public static void main(String[] args) {
		Node9 root = new Node9(10);
		root.left = new Node9(30);
		root.right = new Node9(40);
		root.left.left = new Node9(80);
		root.left.right = new Node9(70);
		root.right.left = new Node9(60);
		root.right.right = new Node9(20);
		
		System.out.println("Max: "+getMax(root));
	}

	private static int getMax(Node9 root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}else {
			return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
		}
	}

}
