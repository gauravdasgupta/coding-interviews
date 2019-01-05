package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class arrangePositiveNegative {
	
	public static int partition(int[] arr, int low, int high)
	{
		int i=low;
		int pivot=0;
		for(int j=0;j<=high;j++)
		{
			
			if(arr[j]<=pivot)
			{
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				i++;
			}
			
		}

		return i;
	}
	
	public static void reArrange(int[] arr)
	{
		
		int pi=partition(arr, 0, arr.length-1);
		System.out.println(pi+":"+Arrays.toString(arr));
		
		int pos=pi;
		int neg=0;
		int temp;
		while(pos<arr.length && neg<pos && arr[neg]<0)
		{
			temp=arr[neg];
			arr[neg]=arr[pos];
			arr[pos]=temp;
			neg+=2;
			pos++;

		}
		
		
		
	}
	
	public static void reArrangeusingQueue(int[] arr)
	{
		Queue<Integer> qNeg=new LinkedList<>();
		Queue<Integer> qPos=new LinkedList<>();
		
		for(int x: arr)
		{
			if(x<0)
				qNeg.add(x);
			else 
				qPos.add(x);
		}
		int i=0;
		while(true)
		{
			if(!qNeg.isEmpty())
			{arr[i]=qNeg.poll();
			i++;}
			if(!qPos.isEmpty())
			{arr[i]=qPos.poll();
			i++;}
			
			if(qNeg.isEmpty() && qPos.isEmpty())
				break;
			
		}
		
		
		
	}
	
	
	public static void main(String[] args)
	{
		int[] arr={-1, 2, -3,-8, 4, 5, 6, -7, 8, 9};
		System.out.println(Arrays.toString(arr));
		//reArrangeusingQueue(arr);
		
		reArrange(arr);
		System.out.println(Arrays.toString(arr));

	}

}
