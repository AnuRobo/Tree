package tree;


/*
 * THREE CASES
 * -- 1 When the key to be deleted is a leaf node. In that case we simply delete the node.
 * -- 2 If it has only one child, then we replace it with that child
 * -- 3 If it has two children, then we find the inorder successor 
 * */


class Node18{
	int key;
	
	// self referencing structure
	Node18 left, right;
	
	Node18(int key){
		this.key = key;
	}
}

public class BstDeletion {

	public static void main(String[] args) {
		Node18 root = new Node18(50);
		root.left = new Node18(30);
		root.right = new Node18(70);
		
		root.right.left = new Node18(60);
		root.right.right = new Node18(80);
		
		root.left.right = new Node18(40);
		
		delNode(root, 30);
	}

	private static Node18 delNode(Node18 root, int x) {
		if(root == null) return null;
		
		if(x < root.key) {
			root.left = delNode(root.left, x);
		}else if(x > root.key) {
			root.right = delNode(root.right, x);
		}else {
			if(root.left == null) return root.right;
			else if(root.right == null) return root.left;
			else {
				Node18 succ = getSucc(root);
				root.key = succ.key;
				root.right = delNode(root.right, succ.key);
			}
		}
		return root;
	}

	private static Node18 getSucc(Node18 root) {
		Node18 curr = root.right;
		while(curr != null && curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

}
