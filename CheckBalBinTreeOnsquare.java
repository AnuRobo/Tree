package tree;

class Node13{
	int key;
	
	// self referencing structure
	Node13 left, right;
	Node13(int key){
		this.key = key;
	}
}

public class CheckBalBinTreeOnsquare {

	public static void main(String[] args) {
		Node13 root = new Node13(10);
		root.left = new Node13(5);
		root.right = new Node13(30);
		root.right.left = new Node13(15);
		root.right.right = new Node13(20);
		
		System.out.println("Binary tree is balanced or not?");
		System.out.println(isBalanced(root)?"Yes":"No");
	}
	
	// O(n^2)
	private static boolean isBalanced(Node13 root) {
		if(root == null) return true;
		
		int lh = height(root.left);
		int rh = height(root.right);
//		System.out.println(lh+","+rh);
		
		return (Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right));
	}
	
	private static int height(Node13 node) {
		if(node == null) {
			return 0;
		}else {
			return Math.max(height(node.left), height(node.right))+1;
		}
	}
	
	// O(n)
	private static int isBalancedOpt(Node13 root) {
		if(root == null) return 0;
		
		int lh = isBalancedOpt(root.left); // Check for left subtree, Also get the left height
		if(lh == -1) return -1;
		
		int rh = isBalancedOpt(root.right); // Check for right subtree, Also get the right height
		if(rh == -1) return -1;
		
		if(Math.abs(lh-rh) >1) return -1;
		else return Math.max(lh, rh)+1;
	}

}


/*
 * 			  2 8 -1
 * 			 /      \
 * 		  1 12 1  0 15 2	
 * 		 /      \       \
 * 	  0 13 0  0 14 0  0 16 1
 * 					        \
 * 					      0 17 0
 * */