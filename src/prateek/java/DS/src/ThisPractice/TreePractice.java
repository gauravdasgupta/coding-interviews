package ThisPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreePractice {
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	void preorderTraversal(TreeNode root) {

		if (root == null)
			return;
		System.out.print(root.data + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	void preOrderTraversalRec(TreeNode n) {
		TreeNode curr = n;
		Stack<TreeNode> st = new Stack<>();
		while (true) {
			while (curr != null) {
				System.out.print(curr.data + " ");
				st.push(curr);
				curr = curr.left;
			}
			TreeNode temp = st.peek();

			st.pop();
			if (temp.right != null)
				curr = temp.right;
			if (temp.right == null && st.isEmpty()) {
				break;
			}
		}
	}

	void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	void inOrderTraversalRec(TreeNode n) {
		TreeNode curr = n;
		Stack<TreeNode> st = new Stack<>();

		while (true) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			TreeNode temp = st.peek();

			st.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null)
				curr = temp.right;
			if (temp.right == null && st.isEmpty())
				break;
		}

	}

	void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	void postOrderTraversalRec(TreeNode n) {
		TreeNode curr = n;
		TreeNode temp;
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		st1.push(curr);
		while (!st1.isEmpty()) {
			temp = st1.peek();
			st1.pop();
			st2.push(temp);

			if (temp.left != null)
				st1.push(temp.left);
			if (temp.right != null)
				st1.push(temp.right);
		}
		while (!st2.isEmpty()) {
			temp = st2.peek();
			System.out.print(temp.data + " ");
			st2.pop();
		}
	}

	void postOrderTraversalRecONEStack(TreeNode n) {
		TreeNode curr = n;
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
				System.out.print(temp.data + " ");

			if (st.isEmpty())
				break;
		}

	}

	int height(TreeNode n) {
		if (n == null)
			return 0;
		int lheight = height(n.left);
		int rheight = height(n.right);

		return (lheight > rheight ? lheight + 1 : rheight + 1);
	}

	void levelOrderTraversal(TreeNode n) {
		int height = height(n);
		for (int i = 1; i <= height; i++) {
			printGivenLevel(n, i);
			System.out.print("\n");
		}
	}

	void printGivenLevel(TreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
			return;
		}
		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);
	}

	void levelOrderTraversalRec(TreeNode n) {
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode curr = n;
		q.add(curr);
		while (q.size() > 0) {
			int tempCount = q.size();
			while (tempCount > 0) {
				TreeNode temp = q.poll();
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				System.out.print(temp.data + " ");
				tempCount--;
			}
			System.out.print("\n");
		}

	}

	void insert(int data) {
		if (root == null) {
			root = new TreeNode(data);
			return;
		}

		TreeNode newn = new TreeNode(data);
		TreeNode curr, parent;
		curr = parent = root;
		while (curr != null) {
			parent = curr;
			if (curr.data < data)
				curr = curr.right;
			else
				curr = curr.left;
		}

		if (parent.data < data)
			parent.right = newn;
		else
			parent.left = newn;
	}

	public void insertRec(int data) {
		if (root == null) {
			root = new TreeNode(data);
			return;
		}
		insertRecAtNode(root, data);
	}

	void insertRecAtNode(TreeNode n, int data) {
		if (n.data < data && n.right == null) {
			n.right = new TreeNode(data);
			return;
		} else if (n.data >= data && n.left == null) {
			n.left = new TreeNode(data);
			return;
		}

		if (n.data < data)
			insertRecAtNode(n.right, data);
		else if (n.data >= data)
			insertRecAtNode(n.left, data);
	}

	public TreeNode lowestCommanAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == n1 || root == n2)
			return root;
		if (root == null)
			return null;

		TreeNode left = lowestCommanAncestor(root.left, n1, n2);
		TreeNode right = lowestCommanAncestor(root.right, n1, n2);

		if (left == null && right == null)
			return null;

		if (left != null && right != null)
			return root;
		return left == null ? right : left;
	}

	boolean isBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		boolean left = isBST(root.left, min, root.data);
		boolean right = isBST(root.right, root.data, max);

		return (left && right);
	}

	boolean rootToLeafSum(TreeNode root, int sum, List<TreeNode> l) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				l.add(root);
				return true;
			} else
				return false;
		}

		boolean left = rootToLeafSum(root.left, sum - root.data, l);
		boolean right = rootToLeafSum(root.right, sum - root.data, l);

		if (left || right) {
			l.add(root);
			return true;
		}

		// if(!left && !right)
		return false;
	}

	private static void mirrorTree(TreeNode root) {
		if (root == null)
			return;
		TreeNode temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTree(root.left);
		mirrorTree(root.right);
	}

	public static boolean isHeightBalanced(TreeNode root) {
		if (root == null)
			return true;

		int lheight = heightStatic(root.left);
		int rheight = heightStatic(root.right);

		if (Math.abs(lheight - rheight) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right))
			return true;
		return false;
	}

	public static int heightStatic(TreeNode root) {
		if (root == null)
			return 0;
		int lh = heightStatic(root.left);
		int rh = heightStatic(root.right);

		return (1 + Math.max(lh, rh));
	}

	public static void main(String[] args) {

		TreePractice tree = new TreePractice();
		/*
		 * tree.root = tree.new Node(1);
		 * 
		 * tree.root.left = tree.new Node(2); tree.root.right = tree.new Node(3);
		 * tree.root.left.left = tree.new Node(4); tree.root.left.left.right = tree.new
		 * Node(6); tree.root.left.right = tree.new Node(5);
		 */

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
		TreeNode n1 = tree.root.left.left;
		TreeNode n2 = tree.root.left.right.right;
		TreeNode lca = tree.lowestCommanAncestor(tree.root, tree.root.left.left, tree.root.left.right.right);
		System.out.println("1-" + n1.data + " 2-" + n2.data + " and lca is-" + lca.data);

		if (tree.isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			System.out.println("Given ThisTree is Binary Search tree");
		} else
			System.out.println("Given ThisTree is not Binary Search tree");
		List<TreeNode> l = new ArrayList<>();

		if (tree.rootToLeafSum(tree.root, 48, l)) {
			System.out.print("\n");
			for (TreeNode ele : l)
				System.out.print(ele.data + ",");
			System.out.print("\n");

		}

		/*
		 * tree.insert(5); tree.insert(9); tree.insert(1); tree.insert(3);
		 * tree.insert(12); tree.insert(7);
		 */

		System.out.println("Preorder Traversal- recur,iterative");
		tree.preorderTraversal(tree.root);
		System.out.println();
		tree.preOrderTraversalRec(tree.root);

		System.out.println("\n");

		System.out.println("Inorder Traversal- recur,iterative");
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.inOrderTraversalRec(tree.root);

		System.out.println("\n");

		System.out.println("PostOrder Traversal- recur,iterative");
		tree.postOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversalRec(tree.root); // https://www.youtube.com/watch?v=qT65HltK2uE&index=10&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu
		System.out.println();
		tree.postOrderTraversalRecONEStack(tree.root);

		System.out.println("\nHeight of tree is - " + tree.height(tree.root));

		System.out.println("Rec level order traversal is- ");
		tree.levelOrderTraversal(tree.root);
		System.out.println("level order traversal is- ");
		tree.levelOrderTraversalRec(tree.root);

		System.out.println("Mirroring tree: ");
		mirrorTree(tree.root);
		System.out.println("Inorder Traversal- recur,iterative");
		tree.inOrderTraversal(tree.root);

		System.out.print("Is this tree is height balanced:--" + isHeightBalanced(tree.root));
	}

}