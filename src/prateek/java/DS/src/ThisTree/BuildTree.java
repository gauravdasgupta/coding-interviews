package ThisTree;



public class BuildTree {

	 class Node {
		
		char data;
		Node left,right;
		
		Node(char data)
		{
			this.data=data;
			left=right=null;
			
		}
	}

	static int preindex=0;	
	
	private Node build(char[] in, char[] pre, int str, int end)
	{
		if(str>end)
			return null;
		Node n=new Node(pre[preindex++]);
		
		if(str==end)
			return n;
		int index=searchIndex(in,str,end,n.data);
		
		n.left=build(in,pre,str,index-1);
		n.right=build(in,pre,index+1,end);

		return n;
	}
	
	private int searchIndex(char[] in, int str, int end,char data)
	{
		int i;
		for(i=str;i<=end;i++)
		{
			if(data==in[i])
				return i;
		}
		return i;
		
	}
	
	void printPreOrder(Node node)
	{
		if(node==null)
			return;
		
		System.out.print(node.data+" ");
		printPreOrder(node.left);
		printPreOrder(node.right);
		
	}
	
	void printInOrder(Node node)
	{
		if(node==null)
			return;
		
		printInOrder(node.left);
		System.out.print(node.data+" ");
		printInOrder(node.right);
	}
	
	public Node lowestCommanAncestor(Node root,Node n1,Node n2)
	{
		if(root==n1 || root==n2)
			return root;
		if(root==null)
			return null;
		Node left=lowestCommanAncestor(root.left,n1,n2);
		Node right=lowestCommanAncestor(root.right,n1,n2);
		
		if(left !=null && right !=null)
			return root;
		if(left ==null && right ==null)
			return null;
		
		return left==null?right:left;
	}
	
	
	
	public static void main(String[] args)
	{
		BuildTree bt=new BuildTree();
		char[] inorder= {'D', 'B', 'E', 'A', 'F', 'C'};
		char[] preorder={'A', 'B', 'D', 'E', 'C', 'F'};
		Node root=bt.build(inorder,preorder,0,inorder.length-1);
	
		System.out.print("\n Preorder is :");
		bt.printPreOrder(root);
		
		System.out.print("\n Preorder is :");
		bt.printInOrder(root);

	}
	
	
	
}
