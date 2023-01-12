package tree;

// Print Nodes at K distance

class Node5{
	int key;
	// self referencing structure 
	Node5 left;
	Node5 right;
	
	Node5(int key){
		this.key = key;
	}
}

public class NodesKdistance {

	public static void main(String[] args) {
		Node5 root = new Node5(10);
		root.left = new Node5(20);
		root.right = new Node5(30);
		root.left.left = new Node5(40);
		root.left.right = new Node5(50);
		root.right.right = new Node5(70);
		root.right.right.right = new Node5(80);
		int k = 0;
		atKth(root, 0);
	}

	private static void atKth(Node5 root, int k) {
//		if(root!=null) {
//			atKth(root.left, k+1);
//			atKth(root.right, k+1);
//			if(k == 3) {
//				System.out.print(root.key+", ");
//			}
//		}
		
		if( root == null) {
			return;
		}
		
		if(k == 0) {
			System.out.print(root.key+", ");
		}else {
			atKth(root.left, k-1);
			atKth(root.right, k-1);
		}
	}

}

/*
 * 			10
 * 		  /    \
 *       20    30
 *     /    \	 \
 *    40    50	 70
 *    			   \
 *    			   80
 *          
 * 40,50,70
 * 
 * postorder(10) 0
 * 		|-> postorder(20) 1
 * 		|		|-> postorder(40) 2
 * 		|		|		|-> postorder(NULL) 3
 * 		|		|		|-> postorder(NULL) 3
 * 		|		|		|-> print(40)
 * 		|		|
 * 		|		|-> postorder(50) 2
 * 		|				|-> postorder(NULL) 3
 * 		|				|-> postorder(NULL) 3
 * 		|				|-> print(50)
 * 		|
 * 		|-> postorder(30) 1 
 * 				|-> postorder(NULL) 2
 * 				|-> postorder(70) 2
 * 						|-> postorder(NULL) 3
 * 						|-> postorder(NULL) 3
 * 						|-> print(70)
 * 		
 * 
 * atKth(10,2)
 * 		|-> atKth(20,1)
 * 		|		|-> atKth(40,0)
 * 		|		|-> atKth(50,0)
 * 		|-> atKth(30,1)
 * 				|-> atKth(NULL, 0)
 * 				|-> atKth(70,0)
 * */

