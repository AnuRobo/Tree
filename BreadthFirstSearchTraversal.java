package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node6{
	int key;
	
	// self referencing structure
	Node6 left, right;
	Node6(int key){
		this.key = key;
	}
}

public class BreadthFirstSearchTraversal {

	public static void main(String[] args) {
		Node6 root = new Node6(10);
		root.left = new Node6(20);
		root.right = new Node6(30);
		root.left.left = new Node6(40);
		root.left.right = new Node6(50);
		root.right.left = new Node6(60);
		root.right.right = new Node6(70);
		
		int height = heightTree(root);
		System.out.println(height);

		for(int i=0; i<height; i++) {			// by me
			bfs(root, i);
		}
		System.out.println();
		
		// --------------------------------------------------------------
		bfsQ(root); // O(n)
	}


	private static int heightTree(Node6 root) {
		if(root == null) {
			return 0;
		}else {
			return Math.max(heightTree(root.left), heightTree(root.right)+1);
		}
	}
	
	private static void bfs(Node6 root, int k) {
		
		if(k == 0) {
			System.out.print(root.key+" ");
		}else {
			bfs(root.left, k-1);
			bfs(root.right, k-1);
		}
	}
	
	private static void bfsQ(Node6 root) {
		if(root == null) return;
		
		Queue<Node6> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty() == false) {
			Node6 curr = q.poll();
//			System.out.print(curr.key+" ");
			System.out.println(q);
			if(curr.left != null) q.add(curr.left);
			if(curr.right != null) q.add(curr.right);
		}
	}

	
}
