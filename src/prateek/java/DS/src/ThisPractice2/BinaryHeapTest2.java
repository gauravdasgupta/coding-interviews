package ThisPractice2;

import ThisPractice.TreeNode;

public class BinaryHeapTest2 {

	public static boolean isCompleteTree(TreeNode root, int count, int pos) {

		if (root == null)
			return true;
		if (pos >= count)
			return false;

		return isCompleteTree(root.left, count, 2 * pos + 1) && isCompleteTree(root.right, count, 2 * pos + 2);

	}

	public static boolean isMaxHeap(TreeNode root) {
		if (root.left == null && root.right == null)
			return true;
		if (root.left.data <= root.data && root.right == null)
			return true;
		if (root.left.data > root.data || root.right.data > root.data)
			return false;
		else
			return isMaxHeap(root.left) && isMaxHeap(root.right);

	}

	public static int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		else
			return countNodes(root.left) + countNodes(root.right) + 1;

	}

	public static boolean solve(TreeNode root) {
		int count = countNodes(root);
		System.out.println("count is-" + count);

		if (isCompleteTree(root, count, 0) && isMaxHeap(root))
			return true;

		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(10);

		if(solve(root))
			System.out.println("Max Heap");
		else
			System.out.println("Not Max Heap");

	}

}
