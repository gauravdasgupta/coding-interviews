package ThisQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class MaxMulof3 {

	public static void main(String[] args)
	{
		int[] arr = {8,7,6,9,4};
		maxMul(arr);
		
	}
	
	
	static int maxMul(int[] arr)
	{
		int sum=0,temp1,temp2,temp3;
		Deque<Integer> dq0=new LinkedList<>();
		Deque<Integer> dq1=new LinkedList<>();
		Deque<Integer> dq2=new LinkedList<>();
		Arrays.sort(arr);
		
	
		
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			
			if(arr[i]%3==0)
				dq0.addFirst(arr[i]);
			else if(arr[i]%3==1)
				dq1.addFirst(arr[i]);
			else if(arr[i]%3==2)
				dq2.addFirst(arr[i]);			
		}
		
	if(sum%3==1)
	{
		if(dq1.isEmpty())
		{
			if(!dq2.isEmpty())
				dq2.removeLast();
			else return 0;

			if(!dq2.isEmpty())
				dq2.removeLast();
			else return 0;	
		}
		
		else if(!dq1.isEmpty())
		{
			dq1.removeLast();
			
		}
		
		else return 0;
	}
	
	else if(sum%3==2)
	{
		if(dq2.isEmpty())
		{
			if(!dq1.isEmpty())
				dq1.removeLast();
			else return 0;

			if(!dq1.isEmpty())
				dq1.removeLast();
			else return 0;	
		}
		
		else if(!dq2.isEmpty())
		{
			dq2.removeLast();
			
		}
		
		else return 0;
	}
	
	int arrsize=dq1.size()+dq2.size()+dq0.size(),top=0;
	int[] max3=new int[arrsize];
	
	while(!dq0.isEmpty())
		max3[top++]=dq0.pollLast();
	
	while(!dq1.isEmpty())
		max3[top++]=dq1.pollLast();
	
	while(!dq2.isEmpty())
		max3[top++]=dq2.pollLast();
	
	
	Arrays.sort(max3);
	long maxnum=0;
	for(int i=0;i<top;i++)
	{
		maxnum=maxnum*10+max3[top-i-1];
		
	}
	
	System.out.println(maxnum);
	
	return top;
 }	

}

