package ThisBinaryTree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//import ThisTree.Node;

//https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	void printPostOrder(Node node) {

		if (node == null)
			return;
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
	}

	void printPreOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	void printInOrder(Node node) {
		if (node == null)
			return;

		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	void printInOrderwo() {
		Node curr = root;
		Stack<Node> st = new Stack<>();
		while (true) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			Node temp = st.peek();
			System.out.print(temp.data + " ");
			st.pop();
			if (temp.right != null)
				curr = temp.right;
			if (temp.right == null && st.isEmpty())
				break;
		}
	}

	void printInOrderMorris() {
		Node curr = root;

		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			} else {
				Node pre = curr.left;
				while (pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre.right = null;
					System.out.print(curr.data + " ");
					curr = curr.right;
				}
			}
		}
	}

	void printPreOrderMorris() {
		Node curr = root;

		while (curr != null) {

			if (curr.left == null) {
				System.out.print(curr.data + " ");
				curr = curr.right;
			} else {
				Node pre = curr.left;

				while (pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				if (pre.right == curr) {
					pre.right = null;
					curr = curr.right;
				} else {
					System.out.print(curr.data + " ");
					pre.right = curr;
					curr = curr.left;
				}

			}

		}

	}

	void printLevelOrder() {

		int h = height(root);
		for (int i = 0; i < h; i++) {
			printGivenLevel(root, i);
			System.out.print("\n");
		}
		// System.out.println(height(root));
	}

	void printGivenLevel(Node node, int level) {
		if (node == null)
			return;

		if (level == 0) {
			System.out.print(node.data + " ");
			return;
		}
		printGivenLevel(node.left, level - 1);
		printGivenLevel(node.right, level - 1);
	}

	int height(Node node) {
		if (node == null)
			return 0;

		int lheight = height(node.left);
		int rheight = height(node.right);

		if (lheight > rheight)
			return lheight + 1;
		else
			return rheight + 1;

	}

	void printLevelOrderwo() {
		Node st = root;
		Queue<Node> q = new LinkedList<>();
		q.add(st);
		System.out.println("\n Level Order traverse using ThisQueue");

		while (true) {
			int count = q.size();

			while (count > 0) {
				Node tmp = q.peek();
				q.remove();
				System.out.print(tmp.data + " ");
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);

				count--;

			}
			System.out.print("\n");
			if (q.isEmpty())
				break;
		}
	}

	void printPreOrderwo(Node n) {
		Stack<Node> st = new Stack<>();

		Node curr = n;

		while (true) {

			while (curr != null) {
				System.out.print(curr.data + " ");
				st.push(curr);
				curr = curr.left;
			}
			Node temp = st.peek();
			st.pop();

			if (temp.right != null) {
				curr = temp.right;
			}

			if (temp.right == null && st.isEmpty())
				break;
		}

	}

	void insert(int key) {
		if (root == null) {
			root = new Node(key);
			return;
		}
		Node parent, curr;
		parent = curr = root;

		while (curr != null) {
			parent = curr;
			if (curr.data < key) {
				curr = curr.right;
			} else
				curr = curr.left;
		}

		if (parent.data < key)
			parent.right = new Node(key);
		else
			parent.left = new Node(key);

	}

	void insertR(int key) {
		insertRecursively(root, key);

	}

	private void insertRecursively(Node n, int key) {
		if (n == null) {
			n = new Node(key);
			return;
		} else if (n.data < key)
			insertRecursively(n.right, key);
		else
			insertRecursively(n.left, key);

	}

	public Node search(int key) {
		Node n = root;
		return searchR(n, key);

	}

	Node searchR(Node n, int key) {
		if (n == null || n.data == key)
			return n;
		else if (n.data < key)
			return searchR(n.right, key);
		else
			return searchR(n.left, key);

	}

	void printPostOrder() {
		printPostOrder(root);
	}

	void printPreOrder() {
		printPreOrder(root);
	}

	void printInOrder() {
		printInOrder(root);
	}

	public Node lowestCommanAncestor(Node root, Node n1, Node n2) {
		if (root == n1 || root == n2)
			return root;
		if (root == null)
			return null;
		Node left = lowestCommanAncestor(root.left, n1, n2);
		Node right = lowestCommanAncestor(root.right, n1, n2);

		if (left != null && right != null)
			return root;
		if (left == null && right == null)
			return null;

		return left == null ? right : left;
	}

	Node lowestCommanAncestorBT(Node root, int n1, int n2) {
		if (root.data > Math.max(n1, n2))
			return lowestCommanAncestorBT(root.left, n1, n2);
		else if (root.data < Math.min(n1, n2))
			return lowestCommanAncestorBT(root.right, n1, n2);
		else
			return root;

	}

	boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;

		boolean left = isBST(root.left, min, root.data);
		boolean right = isBST(root.right, root.data, max);

		return left && right;
	}

	boolean roottoLeafSum(Node root, int sum, List<Node> l) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null) {
			if (root.data == sum) {
				l.add(root);
				return true;
			} else
				return false;
		}

		boolean left = roottoLeafSum(root.left, sum - root.data, l);
		boolean right = roottoLeafSum(root.right, sum - root.data, l);

		if (left || right) {
			l.add(root);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		// System.out.println("\n LCA is:" +bt.lowestCommanAncestor(bt.root,
		// bt.root.left.left.right, bt.root.left.left.right.left).data);

		bt.insert(5);
		bt.insert(8);
		bt.insert(1);
		bt.insert(7);
		bt.insert(999);
		// bt.insertR(99);
		// bt.insertR(188);
		bt.insert(55);
		// bt.insertR(-88);

		Node s = bt.search(55);
		System.out.println("searched element : " + s.data);

		List<Node> l = new LinkedList<>();

		int sum = 1067;
		if (bt.roottoLeafSum(bt.root, sum, l)) {
			System.out.println("\n" + sum + " as a sum exists in the tree from root to leaf:");
			for (Node x : l) {
				System.out.print(x.data + " ");
			}
			System.out.println("\n");

		}

		System.out.println(bt.isBST(bt.root, Integer.MIN_VALUE, Integer.MAX_VALUE) == true ? "BST" : "Not BST");
		System.out.println("\n LCA is:" + bt.lowestCommanAncestorBT(bt.root, 55, 7).data);

		System.out.println("Preorder traversal of binary tree is ");
		bt.printPreOrder();

		System.out.println("\nInorder traversal of binary tree is ");
		bt.printInOrder();

		System.out.println("\nInorder traversal of binary tree wo recursion is  ");
		bt.printInOrderwo();

		System.out.println("\nInorder traversal of binary tree using Morris traversal");
		bt.printInOrderMorris();

		System.out.println("\nPostorder traversal of binary tree is ");
		bt.printPostOrder();

		// System.out.println("Height is"+bt.height(bt.root) );

		System.out.println("\nLevelorder traversal of binary tree is ");
		bt.printLevelOrder();

		bt.printLevelOrderwo();

		System.out.println("\nPreorder traversal of binary tree is using loops");
		bt.printPreOrderwo(bt.root);

		System.out.println("\nPreorder traversal of binary binary tree USING MORRIS");
		bt.printPreOrderMorris();
	}

}
