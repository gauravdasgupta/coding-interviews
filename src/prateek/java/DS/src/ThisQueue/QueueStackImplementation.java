package ThisQueue;

import java.util.Stack;

public class QueueStackImplementation {

	Stack<Integer> st1=new Stack<>();
	Stack<Integer> st2=new Stack<>();
	
	public void enQueue(int data)
	{
		while(!st1.isEmpty())
		{
			st2.push(st1.pop());
		}
		
		st1.push(data);
		
		while(!st2.isEmpty())
		{
			st1.push(st2.pop());
			
		}
	}
	
	public int deQueue()    {
		
		if(st1.isEmpty())
		{
			
			
			
			try {
				throw new Exception();
			} catch (Exception e) {
				
				System.out.print("\n"+"ThisStack's empty");
				return Integer.MIN_VALUE;
			}
	
		}
		
		else
			return st1.pop();

	}
	
	public boolean isEmpty()
	{
		return st1.isEmpty();
		
	}
	
	
}

