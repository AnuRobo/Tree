package tree;

class Node4{
	int key;
	// self referencing structure
	Node4 left;
	Node4 right;
	
	Node4(int key){
		this.key = key;
	}
}

public class HeightOfTree {

	public static void main(String[] args) {
		Node4 root = new Node4(10);
		root.left = new Node4(8);
		root.right = new Node4(30);
		root.right.left = new Node4(40);
		root.right.right = new Node4(50);
		
		System.out.println(height(root));
	}
	
	static int height(Node4 root) {
		if(root == null) {
			return 0;
		}else {
			return Math.max(height(root.left), height(root.right))+1;
		}
	}

}


/*
 * height(10)
 * 		|
 * 		|-> height(8)
 * 		|		|-> height(NULL)
 * 		|		|-> height(NULL)
 * 		|
 * 		|-> height(30)
 * 				|
 * 				|-> height(40)
 * 				|		|-> height(NULL)
 * 				|		|-> height(NULL)
 * 				|
 * 				|-> height(50)
 * 						|-> height(NULL)
 * 						|-> height(NULL)
 * 
 * 
 * Time Complexity - we simply traverse through every values by left to right. So the time complexity is constant work for
 * 						every node. And if there are n nodes you O(n).
 * 
 *  Auxiliary space - O(H) 
 * */
 