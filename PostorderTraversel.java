package tree;

class Node3{
	int key;
	
	Node3 left;
	Node3 right;
	
	Node3(int key){
		this.key = key;
	}
}

public class PostorderTraversel {

	public static void main(String[] args) {
		Node3 root = new Node3(10);
		root.left = new Node3(20);
		root.right = new Node3(30);
		root.right.left = new Node3(40);
		root.right.right = new Node3(50);
		
		postOrder(root);
	}

	private static void postOrder(Node3 root) {
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.key+", ");
		}
	}

}

/*
 * left right root
 * 
 * 			10
 * 		  /    \
 *       20    30
 *           /    \
 *          40    50
 *          
 * 20,40,50,30,10
 * 
 * postorder(10)
 * 		|-> postorder(20) 
 * 		|		|-> postorder(NULL) 
 * 		|		|-> postorder(NULL)
 * 		|		|-> print(20)
 * 		|
 * 		|-> postorder(30) 
 * 		|		|-> postorder(40)
 * 		|		|		|-> postorder(NULL)
 * 		|		|		|-> postorder(NULL)
 * 		|		|		|-> print(40)
 * 		|		|
 * 		|		|-> postorder(50)
 * 		|		|		|-> postorder(NULL) 
 * 		|		|		|-> postorder(NULL)
 * 		|		|		|-> print(50)
 * 		|		|
 * 		|		|-> print(30)
 * 		|
 * 		|-> print(10)
 * -------- Time Complexity : O(n)  we are going to do constant amount of work for every node
 * -------- Auxiliary Space : O(h)
 * 
 * at most you have the number of items in the recursion call stack or function call stack which is proportional to the number of nodes from root to the leaf which is height(h) of binary tree 
 * */
