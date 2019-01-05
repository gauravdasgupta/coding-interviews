package ThisQueue;
import java.util.Stack;

public class QueueStackImplementation2 {

	Stack<Integer> st1=new Stack<>();
	Stack<Integer> st2=new Stack<>();
	
	public boolean isEmpty() {
		if(st1.isEmpty() && st2.isEmpty())
			return true;
		
		return false;
		
	}
	
	public void enQueue(int data)
	{
		
		st1.push(data);
		
	}
	
	public int deQueue()
	{
		if(st1.isEmpty() && st2.isEmpty())
		{
			System.out.print("\n");
			return Integer.MIN_VALUE;
					
		}
		
		if(!st2.isEmpty())
			return st2.pop();
		
		while(!st1.isEmpty())
		{
		st2.push(st1.pop());
			
		}
		
		return st2.pop();
	}
	
	
}
