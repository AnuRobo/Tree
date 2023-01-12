package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node8{
	int key;
	
	// self referencing structure
	Node8 left, right;
	
	Node8(int key){
		this.key = key;
	}
}

public class SizeOfBinaryTree {

	public static void main(String[] args) {
		Node8 root = new Node8(10);
		root.left = new Node8(20);
		root.right = new Node8(30);
		root.left.left = new Node8(40);
		root.left.right = new Node8(50);
		root.right.left = new Node8(60);
		root.right.right = new Node8(70);
		
		System.out.println("Size of binary tree is: "+binarySize(root));
	}

	private static int binarySize(Node8 root) {
		if(root == null) return 0;
		else {
			return 1+binarySize(root.left)+binarySize(root.right);
		}
//		Queue<Node8> q = new LinkedList<>();
//		q.add(root);
//		
//		while(q.isEmpty() == false) {
////			System.out.println(q.size());
////			s+=q.size();
//			Node8 curr = q.poll();
//			s++;
//			if(curr.left!=null) q.add(curr.left);
//			if(curr.right!=null) q.add(curr.right);
//		}
//		return s;
	}

}
