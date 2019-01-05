package ThisPractice2;

import ThisPractice.TreePractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ThisPractice.TreeNode;

public class TreePractice2 {

	public void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.data + ",");
		inOrderTraversal(root.right);

	}

	public void preOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		System.out.print(root.data + ",");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	public void preOrderTraversal2(TreeNode root) {

		TreeNode curr = root;
		Stack<TreeNode> st = new Stack<>();
		while (true) {
			while (curr != null) {
				System.out.print(curr.data + ",");
				st.push(curr);
				curr = curr.left;
			}
			TreeNode temp = st.peek();
			st.pop();

			if (temp.right != null) {
				curr = temp.right;
			}

			if (temp.right == null && st.empty())
				break;
		}

	}

	public void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + ",");

	}

	public static void postOrderTraversal2(TreeNode root) {
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		TreeNode curr = root;
		st1.push(curr);
		TreeNode temp;
		while (!st1.isEmpty()) {
			temp = st1.pop();
			st2.push(temp);
			if (temp.left != null)
				st1.push(temp.left);
			if (temp.right != null)
				st1.push(temp.right);
		}

		while (!st2.isEmpty()) {
			temp = st2.pop();
			System.out.print(temp.data + ",");
		}

	}

	public static void postOrderTraversalRecONEStack(TreeNode root) {
		TreeNode curr = root;
		Stack<TreeNode> st = new Stack<>();

		while (true) {
			while (curr != null) {
				st.push(curr);
				if (curr.right != null)
					st.push(curr);
				curr = curr.left;
			}

			TreeNode temp = st.peek();
			st.pop();

			if (!st.isEmpty() && temp == st.peek())
				curr = temp.right;
			else
				System.out.print(temp.data + ",");

			if (st.empty())
				break;

		}

	}

	public static void inOrderTraversal2(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode curr = root;

		while (true) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}

			TreeNode temp = st.peek();
			st.pop();
			System.out.print(temp.data + ",");

			if (temp.right != null)
				curr = temp.right;

			if (curr == null && st.isEmpty())
				break;

		}
	}

	public static void levelOrderTraversal(TreeNode root) {
		int height = height(root);

		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}

	}

	public static void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;

		if (level == 1) {
			System.out.print(root.data + ",");
			return;
		}
		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);

	}

	public static int height(TreeNode root) {
		if (root == null)
			return 0;

		return (Math.max(height(root.left), height(root.right)) + 1);

	}

	public static void levelOrderTraversal2(TreeNode root) {
		Queue<TreeNode> q=new LinkedList<>();
		TreeNode curr=root;
		q.add(curr);
		int count;
		
		while(q.size()>0)
		{
			count=q.size();
			while(count>0)
			{
				TreeNode temp=q.peek();
				q.poll();
				System.out.print(temp.data+",");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				count--;	
			}
			System.out.println();
			
		}
		
		
	}

	public static void main(String[] args) {

		TreePractice tree = new TreePractice();
		tree.insertRec(5);
		tree.insertRec(9);
		tree.insertRec(1);
		tree.insertRec(3);
		tree.insertRec(12);
		tree.insertRec(7);
		tree.insertRec(0);
		tree.insertRec(22);
		tree.insertRec(11);
		tree.insertRec(4);

		TreePractice2 obj = new TreePractice2();

		System.out.println("In order Traversal is:-");
		obj.inOrderTraversal(tree.getRoot());
		System.out.println();
		obj.inOrderTraversal2(tree.getRoot());
		System.out.println("\n");

		System.out.println("Pre order Traversal is:-");
		obj.preOrderTraversal(tree.getRoot());
		System.out.println();
		obj.preOrderTraversal2(tree.getRoot());
		System.out.println("\n");

		System.out.println("Post order Traversal is:-");
		obj.postOrderTraversal(tree.getRoot());
		System.out.println();
		obj.postOrderTraversal2(tree.getRoot());
		System.out.println();
		obj.postOrderTraversalRecONEStack(tree.getRoot());
		System.out.println("\n");

		System.out.println("Level order Traversal is:-");
		obj.levelOrderTraversal(tree.getRoot());
		obj.levelOrderTraversal2(tree.getRoot());
		System.out.println("\n");

	}
}
