package ThisPractice;

import java.util.Stack;

public class ReverseStack {
	
	public static void reverse(Stack<Integer> st)
	{
		
		if(st.size()>0)
		{
			int temp=st.peek();
			st.pop();
			reverse(st);
			
			
			insertAtLast(temp,st);
		}
		
		
	}
	
	public static void insertAtLast(int x,Stack<Integer> st)
	{
		
		if(st.isEmpty())
		{
			st.push(x);
			return;
		}
		if(st.size()>0)
		{
			int temp=st.peek();
			st.pop();
			insertAtLast(x,st);
			st.push(temp);	
		}
		
		
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> st=new Stack<>();
		System.out.println("Original Stack"); 
		 	st.push(1); 
	        st.push(2); 
	        st.push(3); 
	        st.push(4); 
		
        System.out.println(st); 
		
		reverse(st);
		
		System.out.println(st); 
		
		
	}

}
