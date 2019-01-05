package Thisll;

public class DLL {
	Node head;
	
	class Node
	{
		int data;
		Node prev=null,next=null;
		Node(int data)
		{
			this.data=data;
		}
		
		
	}
	
	
	public void push(int data)
	{
		Node newn=new Node(data);
		newn.next=head;
		
		if(head !=null)
		head.prev=newn;
		
		head=newn;
		
		
	}
	
	
	public void insertAfter(Node prev, int data)
	{
		if(prev==null)
		{System.out.println("Cannot Insert, not valid location");
		return;
		}
		
		Node newn=new Node(data);
		
		newn.next=prev.next;
		prev.next=newn;
		newn.prev=prev;
		
		if(newn.next!=null)
			newn.next.prev=newn;

	}
	
	public void append(int data)
	{
		Node newn=new Node(data);
		if(head==null)
		{
			head=newn;
			
			return;
		}
		
		Node temp=head;
		while(temp.next!=null)
		{
			temp=temp.next;

		}
		
		temp.next=newn;
		newn.prev=temp;

	}
	
	public void insertBefore(Node next, int data)

	{
		
		if(next==null)
		{
			System.out.println("Cannot Insert, not valid location");
			return;
		}
		
		Node newn=new Node(data);
		
		newn.prev=next.prev;
		newn.next=next;
		
		
		if(next.prev!=null)
		next.prev.next=newn;
		else
			head=newn;
		
		
		next.prev=newn;
		
	}
	
	public void printList()
	{
		
		System.out.print(">>: ");
		Node temp=head;
		Node last=null;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			last=temp;
			temp=temp.next;
		}
		System.out.print("\n"+"<<: ");
		
		while(last!=null)
		{
			System.out.print(last.data+" ");
			last=last.prev;	
		}
		
	}
	
	public boolean deleteData(int data)
	{
		Node temp=head;
		int d;
		if(temp==null)
			return false;
		
		if(head.data==data)
		{
			
			temp=head.next;
			head.next.prev=null;
			head=temp;
					
			
			return true;
		}
		
		while(temp!=null && temp.data!=data)
		{
			temp=temp.next;
			
		}
		
		if(temp==null)
			return false;
		
		if(temp.data==data)
		{
			if(temp.next==null)
			{
				temp.prev.next=null;
				temp.prev=null;
				return true;
				
			}
			
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			return true;
			
		}
		

		return false;
	}
	
	
	public void reverseList()
	{
		Node prev=null, curr=head,temp=head.next,temp1=null;
		
		while(temp!=null)
		{
			
			temp1=curr.next;
			curr.next=prev;
			curr.prev=temp1;
			prev=curr;
			curr=temp;
			temp=temp.next;
			
		}
		
		curr.next=prev;
		head=curr;
		curr.prev=null;
		
	}
	
	
	

}
