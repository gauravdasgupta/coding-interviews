package ThisQueue;

import ThisQueue.QueueLlImplementation;

public class Testing {

	
	public static void main(String[] args)
	{
		QueueLlImplementation q=new QueueLlImplementation();
		q.enQueue(12);
		q.enQueue(25);
		q.enQueue(45);
		q.deQueue();
		q.enQueue(55);
		
		
		while(!q.isEmpty())
		{
		System.out.print(q.deQueue()+" ");
		}
	}
	
	
}
