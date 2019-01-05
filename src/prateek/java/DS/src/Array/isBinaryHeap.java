package Array;

class Node{
	int data;
	Node left, right;
	Node(int key){
		this.data=key;
		left=right=null;
	}	
}

public class isBinaryHeap {

	
	public static int countNodes(Node root)
	{
		if(root==null)
			return 0;
		else
			return (1+countNodes(root.left)+countNodes(root.right));
	}

	public static boolean isCompleteTree(Node root,int n, int i)
	{
		if(root==null)
			return true;
		if(i>=n)
			return false;
		else 
			return isCompleteTree(root.left,n,2*i+1) && isCompleteTree(root.right,n,2*i+2);		
	}
	
	public static boolean isMaxHeap(Node root)
	{
		if(root.left==null & root.right==null)
			return true;
		if(root.right==null && root.data>=root.left.data)
			return true;
		if(root.data< root.left.data || root.data<root.right.data)
			return false;
		else return isMaxHeap(root.left) && isMaxHeap(root.right);
		
	}
	
	
	public static boolean binaryHeapTest(Node root)
	{
		int nodesCount=countNodes(root);
		//System.out.println("number of nodes are : "+nodesCount);
		

		return isCompleteTree(root,nodesCount,0) && isMaxHeap(root);
	}
	
	public static void main(String[] args)
	{
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
	        
	        if(binaryHeapTest(root))
	        	System.out.println("Given Tree is a Binary Heap");
	        else
	        	System.out.println("Given Tree is NOT a Binary Heap");

	}
}
