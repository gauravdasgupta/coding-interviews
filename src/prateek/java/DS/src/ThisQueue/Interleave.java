package ThisQueue;

//https://www.geeksforgeeks.org/interleave-first-half-queue-second-half/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class Interleave {
	

	public static void main(String[] args)
	{
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=8;i++)
		q.add(i);
		
		
		for(int x: q)
			System.out.print(x+" ");
		
		interLeaveQueue(q);
		System.out.print("\n"+"Final Result is:");
		
		for(int x: q)
			System.out.print(x+" ");
		
		//System.out.print(q.size());
		
		
		//System.out.print("\n"+q.peek());
		
		
		
	}
	
	 static void interLeaveQueue(Queue<Integer> q) {
		
		 
		 
		if(q.size()%2 !=0)
			return;
		
		
		//1st Step
		Stack<Integer> st=new Stack<>();
		int p=q.size()/2;
		for(int i=0;i<p;i++)

		{
			st.push(q.poll());
			
		}
		
		while(!st.isEmpty())
		{
			q.add(st.pop());
			
		}
		
		for(int i=0;i<p;i++)
		{
			q.add(q.poll());
			
		}
		
		
		for(int i=0;i<p;i++)

		{
			st.push(q.poll());
			
		}
	
		while(!st.isEmpty())
		{
			q.add(st.pop());
			q.add(q.poll());
			
		}
		
		
		
	}
	
	
	
}
