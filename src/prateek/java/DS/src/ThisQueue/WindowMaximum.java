package ThisQueue;

import java.util.Deque;
import java.util.LinkedList;


public class WindowMaximum {

	public static void main(String[] args)
	{
		int arr[]={12, 1, 78, 90, 57, 89, 56};
        int k=3;
        System.out.println("Printing windows maximum:");
        printMaxWindow(arr, k);
	
	}
	 
	static void printMaxWindow(int[]  arr, int k)
	{
		Deque<Integer> dq=new LinkedList<Integer>();
		
		int len=arr.length;
		int i;
		for(i=0;i<k;i++)
		{
			while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])
				dq.removeLast();
			dq.addLast(i);
		}
		
		
		for(;i<len;i++)
		{
			System.out.print(arr[dq.peek()]+" ");
			
			
			while(!dq.isEmpty() && dq.peekFirst()<=(i-k))
					dq.removeFirst();
			
			while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])
				dq.removeLast();
			dq.addLast(i);
		}
		
		System.out.print(arr[dq.peek()]+" ");
		
		
		
		
	}
	
	
	
	
	
}
