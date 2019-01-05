package Thisll;

public class LinkedList {

	Node head;
	
	class Node{
	Node next;
	int data;
	
	Node(int data)
	{
		this.data=data;
		next=null;
	}
		
	}
	
	public void push(int d) {
		
		Node newn=new Node(d);
		newn.next=head;
		head=newn;
		
	}
	
	public void append(int d)
	{
		Node newn=new Node(d);
		
		if(head==null)
		{
			head=newn;
			return;
		}
		
		Node temp=head;
		while(temp.next !=null)
		{
			temp=temp.next;
			
		}
		
		temp.next=newn;
		newn.next=null;
		
	}
	
	public void insertAfter(Node prev, int d)
	{
		
		if(prev==null)
		{
			System.out.println("Cannot Insert; BUZZ OFF");
			return;
		}
		
		Node newn =new Node(d);
		newn.next=prev.next;
		prev.next=newn;
		
		
	}
	
	public void deleteNoidAtPos(int pos)
	{
		Node temp=head;
		
		for(int i=0;temp !=null && i<(pos-1);i++)
		{
			temp=temp.next;
		}
		
		if(pos==0)
			{head=temp.next;
			return;
			}
		
		
		if(temp==null || temp.next==null)
			{System.out.println(pos+"is more than length of list");
			return;
			}
		
		
		temp.next=temp.next.next;
		
		
		
	}
	
	
	public void deleteNoid(int d)
	{
		Node temp=head;
		Node prev=null;
		
		if(head.data==d)
		{
			head=head.next;
			return;
		}
		
		while(temp.next != null && temp.data != d)
		{
			prev=temp;
			temp=temp.next;
			
		}
		
		if(temp.next==null && temp.data!=d)
		{
			System.out.println("Doesnt Exists");
			return;
		}
		else if (temp.data==d)
		{
			
			prev.next=temp.next;
			return;
			
		}
		
		return;
		
		
		
	}
	
	
	public void printList()
	{
		Node temp=head;
		while(temp !=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.print("\n");
		
	}
	
	public int getCount()
	{
		Node temp=head;
		int count =0;
		
		if(head==null)
			return 0;
		
	while(temp!=null)
	{
		temp=temp.next;
		count++;
		
	}
				
		return count;
		
	}
	
	public int getCountAfterNode(Node n)
	{
		if(n==null)
			return 0;
		
		else 
			return 1+getCountAfterNode(n.next);
		
		
	}
	
	public boolean search(int key)
	{
		Node temp=head;
		
		while(temp!=null)
		{
			if(temp.data==key)
				return true;
			temp=temp.next;
			
		}
		
		return false;
	}
	
	public boolean searchAfterNode(Node node, int key)
	{
		if(node!=null && node.data==key)
			return true;
		
		if(node==null)
			return false;
		
		return searchAfterNode(node.next,key);
		
		
	}
	
	
	public void swapNodes (int x, int y)
	
	{
		if (x==y)
			return;
		
		Node prevX=null,curX=head,prevY=null,curY=head;
		
		while(curX != null && curX.data !=x)
		{
			prevX=curX;
			curX=curX.next;
			
		}
		
		while(curY != null && curY.data !=y)
		{
			prevY=curY;
			curY=curY.next;
			
		}
		
		
		if(prevX !=null)
				prevX.next=curY;
		else
				head=curY;
		
		if(prevY !=null)
				prevY.next=curX;
		else 
				head=curX;
		
		Node temp;
		
		temp=curX.next;
		curX.next=curY.next;
		curY.next=temp;	
	}
	
	public int getNth(int index)
	{
		Node temp=head;
		int i=0;
		for( i=0;temp.next!=null && i<index;i++)
		{
			temp=temp.next;
			
		}
		
		if(i==index)
			return temp.data;
		
		assert(false);
		return 0;
	}
	
	public void printMiddle()
	{
		
		Node fast=head,slow=head;
		
		while(fast!=null && fast.next !=null)
		{
			fast=fast.next.next;
			slow=slow.next;
		}

		System.out.println("Middle one is: "+slow.data);
		
	}
	
	public void printNthlast(int n) {
		int len=getCount();
		Node temp=head;
		int count=0;
		while(temp !=null)
		{
			if(count==(len-n))
				{System.out.println(n+" elenemt from last is: "+temp.data);
				return;
				}
			count++;
			temp=temp.next;
		}
		
		System.out.println("Doesnt exist");
		
	}
	
	public void deleteList()
	{
		head=null;
		
	}
	
	public int countOfKey(int key)
	{
		Node temp=head;
		int count=0;
		while(temp!=null)
		{
			if(temp.data==key)
				count++;
			
			temp=temp.next;
			
		}
		
		return count;
	}
	
	public void reverseList()
	{
		Node temp=head.next,prev =null,curr=head;
		
		while(temp!=null)
		{
			
			
			curr.next=prev;
			prev=curr;
			curr=temp;
			
			temp=temp.next;
	
			
		}
		
		curr.next=prev;
		
		head=curr;
		
	}
	
	
	
	
}
