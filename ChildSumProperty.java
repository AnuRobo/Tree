package tree;

import java.util.LinkedList;
import java.util.Queue;

class Node11{
	int key;
	
	// self referencing structure
	Node11 left, right;
	
	Node11(int key){
		this.key = key;
	}
}

public class ChildSumProperty {

	private static boolean flag;
	public static void main(String[] args) {
//		Node11 root = new Node11(20);
//		root.left = new Node11(8);
//		root.right = new Node11(12);
//		root.left.left = new Node11(3);
//		root.left.right = new Node11(5);
		
		Node11 root = new Node11(4);
		root.left = new Node11(1);
		root.right = new Node11(3);
		root.right.left = new Node11(1);
		root.right.right = new Node11(2);
		
//		System.out.println(childSum(root)?"Yes":"No");
		System.out.println(cSum(root)?"Yes":"No");
	}

	private static boolean cSum(Node11 root) {
		if(root == null) return true;
		
		if(root.left == null && root.right==null) {
			return true;
		}
		
		int sum = 0;
		if(root.left != null) {
			sum+=root.left.key;
		}
		if(root.right != null) {
			sum+=root.right.key;
		}
		return (root.key == sum && cSum(root.left) && cSum(root.right));
	}
	
	private static boolean childSum(Node11 root) {
//		if(root == null) return false;
		
		Queue<Node11> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty()==false) {
			Node11 curr = q.poll();
			int lChild;
			int rChild;
			System.out.println(curr.key);
			if(curr.left==null) {
				lChild = 0;
			}else{
				lChild = curr.left.key;
				System.out.println("left- "+lChild);
			}
			
			if(curr.right==null) {
				rChild = 0;
			}else{
				rChild = curr.right.key;
				System.out.println("right- "+rChild);
			}
			
//			if(lChild == null || rChild == null) {
//				
//			}
//			int par = curr.key;
			System.out.println("sum "+(lChild + rChild));
//			System.out.println((lChild + rChild)==curr.key && (lChild + rChild)!=0);
			if((lChild + rChild)==curr.key && (lChild + rChild)!=0) {
				flag = true;
			}else if((lChild+rChild)==0) {
				flag = true;
			}else {
				flag = false;
				break;
			}
			System.out.println(flag);
			System.out.println();
			
			if(curr.left!=null) q.add(curr.left);
			if(curr.right!=null) q.add(curr.right);
		}
		return flag;
	}

}
