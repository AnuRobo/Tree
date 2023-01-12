package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node10{
	int key;
	
	// self referencing structure
	Node10 left, right;
	Node10(int key){
		this.key = key;
	}
}

public class LeftViewBinaryTree {

	private static int maxlevel = 0;
	
	public static void main(String[] args) {
		Node10 root = new Node10(10);
		root.left = new Node10(20);
		root.right = new Node10(30);
		root.left.left = new Node10(40);
		root.left.right = new Node10(50);
		root.right.right = new Node10(70);
		root.right.right.right = new Node10(80);
		
		printLeftView(root, 1); // time complexity O(n)
		System.out.println();
		leftViewLevelOrder(root);
	}

	private static void leftViewLevelOrder(Node10 root) {
		if(root == null) return;
		
		Queue<Node10> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty() == false) {
			int count = q.size();
			for(int i = 0; i<count; i++) {
				Node10 curr = q.poll();
				if(i==0) {
					System.out.print(curr.key+" ");
				}
				if(curr.left!=null) {
					q.add(curr.left);
				}
				if(curr.right!=null) {
					q.add(curr.right);
				}
			}
		}
	}

	// using preorder traversal
	private static void printLeftView(Node10 root, int level) {
		if(root == null) return;
		if(maxlevel < level) {
			System.out.print(root.key+" ");
			maxlevel = level;
		}
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);
	}

}
