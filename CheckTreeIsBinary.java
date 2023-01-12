package tree;

class Node12{
	int key;
	
	// self referencing structure
	Node12 left, right;
	
	Node12(int key){
		this.key = key;
	}
}

public class CheckTreeIsBinary {
	
	public static void main(String[] args) {
		Node12 root = new Node12(1);
		root.left = new Node12(2);
		root.right = new Node12(3);
		root.left.left = new Node12(4);
		root.left.right = new Node12(5);
		root.right.left = new Node12(6);
		root.right.right = new Node12(7);
		
		System.out.println(check(root));
	}
 
	private static boolean check(Node12 root) {
		if(root.left == null && root.right==null) {
			return true;
		}
		
		int sum=0;
		if(root.left != null) {
			sum+=1;
		}
		if(root.right != null) {
			sum+=1;
		}
		
		return(sum==2&&check(root.left)&&check(root.right));
	}

}
