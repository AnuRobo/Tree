package tree;

class Node1{
	int key;
	
	Node1 left;
	Node1 right;
	
	Node1(int key){
		this.key = key;
	}
}

public class InorderTraversel {

	public static void main(String[] args) {
		Node1 root = new Node1(10);
		root.left = new Node1(20);
		root.right = new Node1(30);
		root.right.left = new Node1(40);
		root.right.right = new Node1(50);
		
		inOrder(root);
	}

	private static void inOrder(Node1 root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.key+", ");
			inOrder(root.right);
		}
	}

}

/*
 * Left Root Right
 * 
 * 			10
 * 		  /    \
 *       20    30
 *           /    \
 *          40    50
 *          
 * 20,10,40,30,50
 * 
 * inorder(10)
 * 		|-> inorder(20) // left
 * 		|		|-> inorder(NULL) // left
 * 		|		|-> print(20)
 * 		|		|-> inorder(NULL) // right
 * 		|		
 * 		|-> print(10)
 * 		|
 * 		|-> inorder(30) // right to 10
 * 				|-> inorder(40) // left to 30
 * 				|		|-> inorder(NULL) // left to 40
 * 				|		|-> print(40)
 * 				|		|-> inorder(NULL) // right to 40
 * 				|
 * 				|-> print(30)
 * 				|
 * 				|-> inorder(50) // right to 30
 * 						|-> inorder(NULL) // left to 50
 * 						|-> print(50)
 * 						|-> inorder(NULL)
 * 
 * -------- Time Complexity : O(n)
 * -------- Auxiliary Space : O(h)
 * 
 * at most you have the number of items in the recursion call stack or function call stack which is proportional to the number of nodes from root to the leaf which is height(h) of binary tree 
 * */
