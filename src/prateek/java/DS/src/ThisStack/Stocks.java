package ThisStack;

import java.util.Arrays;
import java.util.Stack;

public class Stocks {
	
	public static void main(String[] args)
	{
		
		int[] stockprices= {10, 4, 5, 90, 120, 80};
		System.out.println(Arrays.toString(stockprices));
		
		//System.out.println("Span is: ");
		
		System.out.println(Arrays.toString(stockSpan(stockprices)));
		
	}
	
	static int[] stockSpan(int prices[])
	{
		Stack<Integer> st=new Stack<>();
		int len=prices.length;
		int span[]=new int[len];
		span[0]=1;
		st.push(0);
		
		for(int i=1;i<len;i++)
		{
			while(!st.isEmpty() && prices[st.peek()]<=prices[i])
				st.pop();
			
			span[i]=(st.isEmpty())?(i+1): (i-st.peek());
			
			st.push(i);	
		}

		return span;
	}
	
	

}
