package ThisPractice2;

import java.util.*;
import java.util.Map.Entry;

class TNode {
	int data;
	TNode left, right;

	public TNode(int data) {
		this.data = data;
	}

	int hl;
}

public class BottomViewOfTree2 {

	public static void solveRec(TNode root, Map<Integer, TNode> mp) {
		int height = height(root);

		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i, 0, mp);
			System.out.println();
		}

	}

	public static void printGivenLevel(TNode root, int verlevel, int horLevel, Map<Integer, TNode> mp) {
		if (root == null)
			return;
		if (verlevel == 1) {
			System.out.print(root.data + ",");
			mp.put(horLevel, root);
			return;
		}

		printGivenLevel(root.left, verlevel - 1, horLevel - 1, mp);
		printGivenLevel(root.right, verlevel - 1, horLevel + 1, mp);

	}

	public static int height(TNode root) {
		if (root == null)
			return 0;
		else
			return (Math.max(height(root.left), height(root.right)) + 1);

	}

	public static void solve(TNode root, Map<Integer, TNode> mp) {
		Queue<TNode> q = new LinkedList<>();
		q.add(root);
		int oSize = q.size();

		while (q.size() > 0) {
			int count = q.size();
			while (count > 0) {
				TNode tempN = q.peek();
				q.poll();
				System.out.print(tempN.data + ",");
				mp.put(tempN.hl, tempN);

				if (tempN.left != null) {
					q.add(tempN.left);
					tempN.left.hl = tempN.hl - 1;
				}
				if (tempN.right != null) {
					q.add(tempN.right);
					tempN.right.hl = tempN.hl + 1;
				}
				count--;

			}
			System.out.println();

		}

	}

	public static void main(String[] args) {
		TNode root = new TNode(20);

		root.left = new TNode(8);
		root.left.left = new TNode(5);

		root.left.right = new TNode(3);
		root.left.right.left = new TNode(10);
		root.left.right.right = new TNode(14);

		root.right = new TNode(22);
		root.right.left = new TNode(4);
		root.right.right = new TNode(25);

		Map<Integer, TNode> mp = new TreeMap<>();
		solveRec(root, mp);

		System.out.println("Bottom View Rec is");
		for (Entry<Integer, TNode> es : mp.entrySet()) {
			System.out.println(es.getKey() + ">>>" + es.getValue().data);

		}

		mp.clear();

		solve(root, mp);
		System.out.println("Bottom View is");
		for (Entry<Integer, TNode> es : mp.entrySet()) {
			System.out.println(es.getKey() + ">>>" + es.getValue().data);

		}
	}
}
