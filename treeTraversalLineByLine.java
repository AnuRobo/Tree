package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node7{
	int key;
	// self referencing structure
	Node7 left, right;
	
	Node7(int key){
		this.key = key;
	}
}
public class treeTraversalLineByLine {

	public static void main(String[] args) {
		Node7 root = new Node7(10);
		root.left = new Node7(20);
		root.right = new Node7(30);
		root.left.left = new Node7(40);
		
//		printLevelOrderLine(root); // O(n)
		
		// we are going to traverse n nodes, for every node it's going to enter into the queue once and it's going to come out of the queue once 
		// entering and coming out of queue are O(1) operations so we do constant work for every node so the time complexity is O(n)
		printLevelOrderLineLoop(root); // O(n)
	}

	private static void printLevelOrderLine(Node7 root) {
		if(root == null) return;
		
		Queue<Node7> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(q.size()>1) {
			Node7 curr = q.poll();
			if(curr == null) {
				System.out.println();
				q.add(null);
				continue;
			}
			
			System.out.print(curr.key+" ");
			if(curr.left != null) q.add(curr.left);
			if(curr.right != null) q.add(curr.right);
		}
	}
	
	private static void printLevelOrderLineLoop(Node7 root) {
		if(root == null) return;
		
		Queue<Node7> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty() == false) {
			int count = q.size();
			
			for(int i = 0; i<count; i++) {
				Node7 curr = q.poll();
				System.out.print(curr.key+" ");
				
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			}
			System.out.println();
		}
	}

}
