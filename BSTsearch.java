package tree;

class Node16{
	int key;
	
	// self referencing structure
	Node16 left, right;
	
	Node16(int key){
		this.key = key;
	}
}

public class BSTsearch {

	public static void main(String[] args) {
		Node16 root = new Node16(30);
		root.left = new Node16(20);
		root.right = new Node16(40);
		
		root.left.left = new Node16(10);
		root.left.right = new Node16(25);
		
		root.right.left = new Node16(35);
		root.right.right = new Node16(45);
		
		search(root, 46);
	}
	
	// recursive 
	// the worst case time taken by any search is height of tree
	// time complexity O(h)
	// aux space O(h)
	private static void search(Node16 root, int i) {
		if(root == null) {
			System.out.println(i+" Not found");
			return;
		}else if(i==root.key){
			System.out.println("found: "+root.key);
		}else if(i>root.key) {
			search(root.right, i);
		}else{
			search(root.left, i);
		}
	}
	
	// iterative
	// Auxiliary space O(1)
	private boolean searchI(Node16 root, int x) {
		while(root != null) {
			if(root.key == x) {
				return true;
			}else if(root.key < x) {
				root = root.right;
			}else {
				root = root.left;
			}
		}
		return false;
	}

}
