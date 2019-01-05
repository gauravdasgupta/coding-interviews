package ThisTree;

public class largestBSTinBT {

	public int largestBstSize(Node root)
	{
		MinMax m=largestBst(root);
		return m.size;
		
	}
	
	private MinMax largestBst(Node root)
	{
		if(root==null)
			return new MinMax();
		
		MinMax left=largestBst(root.left);
		MinMax right=largestBst(root.right);
		
		MinMax m=new MinMax();
		
		if(!left.isBst || !right.isBst || left.max>root.data || right.min<root.data)
		{
			m.isBst=false;
			m.size=Integer.max(left.size,right.size);
			return m;
		}
		
		m.size=left.size+right.size+1;
		m.min=root.left !=null ? left.min:root.data;
		m.max=root.right !=null ? right.max: root.data;

		return m;
	}
	
	
	public static void main(String[] args)
	{
		TreeTraversals bt=new TreeTraversals();
		
bt.root=new Node(25);
		
		bt.root.left = new Node(18);
		bt.root.left.left = new Node(19);
		bt.root.left.left.right = new Node(15);
		
		bt.root.left.right = new Node(20);
		bt.root.left.right.left = new Node(18);
		bt.root.left.right.right = new Node(25);
		
		
		
		
		bt.root.right = new Node(50);
		bt.root.right.left = new Node(35);
		bt.root.right.left.right = new Node(40);
		bt.root.right.left.left = new Node(20);
		bt.root.right.left.left.right = new Node(25);
		
		bt.root.right.right = new Node(60);
		bt.root.right.right.left = new Node(55);
		bt.root.right.right.right = new Node(70);
		
		bt.printInOrder(bt.root);
		largestBSTinBT b=new largestBSTinBT();
		System.out.println("\n The size of largest BST in this BT is: "+b.largestBstSize(bt.root));
		
		
	}
	
	
}




class MinMax{
	int min;
	int max;
	int size;
	boolean isBst;
	MinMax()
	{
		min =Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		size=0;
		isBst=true;
	}
	
	
}
