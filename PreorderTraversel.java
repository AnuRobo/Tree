package tree;

class Node2{
	int key;
	
	Node2 left;
	Node2 right;
	
	Node2(int key){
		this.key = key;
	}
}

public class PreorderTraversel {

	public static void main(String[] args) {
		Node2 root = new Node2(10);
		root.left = new Node2(20);
		root.right = new Node2(30);
		root.right.left = new Node2(40);
		root.right.right = new Node2(50);
		
		preOrder(root);
	}

	private static void preOrder(Node2 root) {
		if(root!=null) {
			System.out.print(root.key+", ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

}

/*
 * 			10
 * 		  /    \
 *       20    30
 *           /    \
 *          40    50
 *          
 * 10,20,30,40,50
 * 
 * preorder(10)
 * 		|-> print(10)
 * 		|-> preorder(20) 
 * 		|		|-> print(20)
 * 		|		|-> preorder(NULL) 
 * 		|		|-> preorder(NULL)
 * 		|
 * 		|-> preorder(30) 
 * 				|-> print(30)
 * 				|-> preorder(40) 
 * 				|		|-> print(40)
 * 				|		|-> preorder(NULL)
 * 				|		|-> preorder(NULL)
 * 				|
 * 				|-> preorder(50)
 * 						|-> print(50)
 * 						|-> preorder(NULL) 
 * 						|-> preorder(NULL)
 * 
 * -------- Time Complexity : O(n)  we are going to do constant amount of work for every node
 * -------- Auxiliary Space : O(h)
 * 
 * at most you have the number of items in the recursion call stack or function call stack which is proportional to the number of nodes from root to the leaf which is height(h) of binary tree 
 * */
