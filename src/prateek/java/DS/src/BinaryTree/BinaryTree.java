package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}

}

public class BinaryTree {

	Node root;

	void printLevelOrder() {

		int h = height(root);

		for (int i = 1; i <= h; i++) {
			printGivenlevel(root, i);
			System.out.print("\n");

		}

	}

	void printLevelOrder(Node n) {

		Queue<Node> q = new LinkedList<>();
		q.add(n);

		while (true) {
			int count = q.size();

			while (count > 0) {
				Node temp = q.peek();
				q.remove();
				System.out.print(temp.data + " ");

				if (temp.left != null)
					q.add(temp.left);

				if (temp.right != null)
					q.add(temp.right);

				count--;
			}
			System.out.print("\n");
			if (q.isEmpty())
				return;
		}

	}

	void printGivenlevel(Node n, int level) {
		int l = level;

		if (level == 1) {
			System.out.print(n.data + " ");
			return;
		}
		if (n.left != null)
			printGivenlevel(n.left, (l - 1));
		if (n.right != null)
			printGivenlevel(n.right, (l - 1));

	}

	int height(Node r) {
		Node temp = r;

		if (temp == null)
			return 0;

		int lh = height(temp.left);
		int rh = height(temp.right);

		if (lh > rh)
			return (lh + 1);
		else
			return (rh + 1);
	}

	void printInorder(Node n) {
		if (n.left != null)
			printInorder(n.left);
		System.out.print(n.data + " ");

		if (n.right != null)
			printInorder(n.right);

	}

	void printInorderwo() {

	}

	Node lowestCommanAncestor(Node root, Node n1, Node n2) {
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

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.left.left = new Node(8);
		bt.root.left.left.right = new Node(9);

		bt.root.left.right = new Node(5);
		bt.root.right.right = new Node(6);
		bt.root.right.right.right = new Node(11);
		bt.root.right.left = new Node(7);
		bt.root.right.left.left = new Node(10);

		bt.printLevelOrder();
		System.out.println("\n using queue");
		bt.printLevelOrder(bt.root);

		System.out.println("In order ");
		bt.printInorder(bt.root);

		System.out.println("\n lowes comman ancestor is :"
				+ bt.lowestCommanAncestor(bt.root, bt.root.left.left.left, bt.root.left.left).data);

	}

}
