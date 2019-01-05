package Array;

import java.util.Arrays;
import java.util.Stack;

public class quickSort {

	public static void quickSorting(int[] arr, int low, int high)
	{
		
		if(low<high)
		{
		int pi=quickSort2(arr, low,high);
		
		quickSorting(arr,low,pi-1);
		quickSorting(arr,pi+1,high);
		}
		
	}
	
	public static void quickSortRec(int[] arr)
	{
		Stack<forStack> st=new Stack<>();
		
		forStack fs1=new forStack(0,arr.length-1);
		
		forStack temp;
		st.push(fs1);
		int pi;
		
		while(!st.isEmpty()) {
			
			temp=st.pop();
			pi=quickSort2(arr,temp.getLow(),temp.getHigh());
			
			if(temp.getLow()<pi-1)
			{
				st.push(new forStack(temp.getLow(),pi-1));
			}
			
			if(temp.getHigh()>pi+1)
			{
				st.push(new forStack(pi+1,temp.getHigh()));
				
			}
			
		}
		
		
		
	}
	
	public static int quickSort2(int[] arr, int low, int high)
	{
		int pivot=arr[high];
		int i=low;
		int  temp;
		
		for(int j=low;j<high;j++)
		{
			if(arr[j]<=pivot)
			{
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				i++;
			}
			
		}
		temp=arr[i];
		arr[i]=arr[high];
		arr[high]=temp;
		return i;
	}
	
	public static void main (String[] args)
	{
		int[] arr= 
			{2, 4, 6, 8,1,3,5,0};
			//{1,2,3,4,7,7,7,8,9,88,99};
		System.out.println(Arrays.toString(arr));
		quickSorting(arr,0,arr.length-1);
		//quickSortRec(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
}

class forStack{
	int low,high;
	public forStack(int low, int high)
	{
		this.low=low;
		this.high=high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}
	
	
}