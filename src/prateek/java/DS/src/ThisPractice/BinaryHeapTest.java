package ThisPractice;

class Node {
	int data;
	Node left, right;

	Node(int key) {
		this.data = key;
		left = right = null;
	}
}

public class BinaryHeapTest {

	public static int count(Node root) {
		if (root == null)
			return 0;
		return (1 + count(root.left) + count(root.right));
	}

	public static boolean isCompleteTree(Node root, int n, int i) {
		if (root == null)
			return true;
		if (i >= n)
			return false;
		return isCompleteTree(root.left, n, 2 * i + 1) && isCompleteTree(root.left, n, 2 * i + 2);
	}

	public static boolean isMaxHeap(Node root) {
		if (root.left == null && root.right==null )
			return true;
		if(root.right==null && root.left.data<root.data)
			return true;
		if(root.data<root.left.data || root.data<root.right.data)
			return false;
		return (isMaxHeap(root.left) && isMaxHeap(root.right));
		
	}

	public static void isBinaryHeapTest(Node root) {
		int countNodes = count(root);
		System.out.println(countNodes);

		if(isCompleteTree(root, countNodes, 0) && isMaxHeap(root))
			System.out.println("Binary Heap tree");
		else
			System.out.println("NOt Binary Heap tree");
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(9);
		root.right = new Node(8);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(1);
		isBinaryHeapTest(root);

	}
}
