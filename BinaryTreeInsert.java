package tree;

class Node17{
	int key;
	
	// self referencing structure
	Node17 left, right;
	
	Node17(int key){
		this.key = key;
	}
}

public class BinaryTreeInsert {

	public static void main(String[] args) {
		Node17 root = new Node17(10);
		root.left = new Node17(5);
		root.right = new Node17(15);
		root.right.left = new Node17(12);
		root.right.right = new Node17(18);

		preTraversal(root);
		
		System.out.println();
		
		// recurring
		Node17 rootN = insert(root, 20);
		preTraversal(rootN);

		System.out.println();
		
		Node17 rootNI = insertI(root, 17);
		preTraversal(rootNI);
	}

	private static Node17 insert(Node17 root, int i) {
		if(root == null) {
			return new Node17(i);
		}
		
		if(root.key > i) {
			root.left = insert(root.left, i);
		}else if(root.key < i) {
			root.right = insert(root.right, i);
		}
		
		return root;
	}
	
	// Iterative
	private static Node17 insertI(Node17 root, int x) {
		Node17 temp = new Node17(x);
		Node17 parent = null;
		Node17 curr = root;
		
		while(curr != null) {
			parent = curr;
			
			if(curr.key > x) {
				curr = curr.left;
			}else if(curr.key < x) {
				curr = curr.right;
			}else {
				return root;
			}
		} // end of while loop
		
		if(parent == null) {
			return temp;
		}
		if(parent.key > x) {
			parent.left = temp;
		}else {
			parent.right = temp;
		}
		
		return root;
	}
	
	
	private static void preTraversal(Node17 root) {
		if(root != null) {
			System.out.print(root.key+" ");
			preTraversal(root.left);
			preTraversal(root.right);
		}
	}
	
	

}
