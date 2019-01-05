package ThisQueue;

public class QueueLlImplementation {

	Node front,rear;
	
	class Node
	{
		Node next;
		int data;
		
		Node(int data)
		{
			this.data=data;
			next=null;
		}
		
	}
	
	public void enQueue(int data) 
	{
		Node newn=new Node(data);
		
		if(front==null && rear==null)
		
		{
			front=newn;
			rear=newn;
			return;
		}
		
		rear.next=newn;
		rear=newn;
		
	}
	
	public int deQueue()
	{
		if(rear==null)
		{
			System.out.println("\n"+"ThisQueue is Empty");
			return Integer.MIN_VALUE;
		}
		
		int rt=front.data;
		if(front.next!=null)
		front=front.next;
		else
			front=null;
	return rt;	
	}
	
	public boolean isEmpty()
	{
		return (front==null);
		
	}

}
