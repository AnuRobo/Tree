package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node14{
	int key;
	
	// self referencing structure 
	Node14 left, right;
	
	Node14(int key){
		this.key = key;
	}
}

public class MaxWidthBinaryTree {

	private static int wid;
	
	public static void main(String[] args) {
		Node14 root = new Node14(10);
		root.left = new Node14(20);
		root.right = new Node14(30);
		root.left.left = new Node14(40);
		root.left.right = new Node14(50);
		root.right.right = new Node14(60);
		root.right.left = new Node14(70);
		
		System.out.println(width(root));
//		System.out.println(wid);
	}

	private static int width(Node14 root) {
		if(root == null) {
			return 0;
		}
		
		Queue<Node14> q = new LinkedList<>();
		q.add(root);
		int res = 0;
		while(q.isEmpty()==false) {
			int count = q.size();
			res = Math.max(res, count);
			
			for(int i = 0; i< count;i++) {				
				Node14 curr = q.poll();
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			}
		}
		return res;
	}

}
