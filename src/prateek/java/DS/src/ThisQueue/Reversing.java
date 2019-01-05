package ThisQueue;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Reversing {

public static void main(String[] args)  {
	
		Queue<Integer> q = new LinkedList<>();
		q.add(8);
		q.add(9);
		q.add(10);
		q.add(11);
		
		Queue<Integer> q1=reverse(q);
		
		while(!q1.isEmpty())
		{
			System.out.print(q1.poll()+" ");
			
		}
			
}

public static Queue<Integer> reverse(Queue<Integer> q)
{
	Stack<Integer> temp=new Stack<>();
	while(!q.isEmpty())
	{
		temp.push(q.poll());
	}
	
	while(!temp.isEmpty())
	{
		q.add(temp.pop());
	
	}
	
	
	
	return q;
}

	
}



