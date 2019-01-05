package Array;

import java.util.Arrays;

public class nearlySorted {

	public static void nearlySorted(int[] arr, int k)
	{
		int n=arr.length;
		
		for(int i=k/2+1;i>=0;i--)
			minHeapify(arr,k,i);
		
		for(int i=n-1;i>=0;i--)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			minHeapify(arr,i,0);
			
		}
		
		
			
		
		
	}
	
	public static void minHeapify(int[] arr, int n , int i)
	{
		int l=2*i+1;
		int r=2*i+2;
		int smallest=i;
		
		if(l<n && arr[l]<=arr[smallest])
			smallest=l;
		if(r<n && arr[r]<=arr[smallest])
			smallest=r;
		
		if(smallest!=i)
		{
			int temp=arr[i];
			arr[i]=arr[smallest];
			arr[smallest]=temp;
			minHeapify(arr,n,smallest);
		}
		
		
		
	}
	
	
	public static void main(String[] args)
	{
		int k=3;
		int[] arr= {2, 6, 3, 12, 56, 8};
		
		nearlySorted(arr,k);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
}
