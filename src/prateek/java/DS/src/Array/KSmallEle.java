package Array;

import java.util.Arrays;

public class KSmallEle {

	public static int kSmall(int[] arr, int k)
	{
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--)
			minHeapify(arr,n,i);
		int i=n-1;
		for(;i>n-k;i--)
		{
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			
			minHeapify(arr,i,0);
			
		}
		minHeapify(arr,i,0);

		return arr[0];
	}
	
	public static void sortDesc(int[] arr)
	{
		int n=arr.length;
		for(int i=n/2-1;i>=0;i--)
			minHeapify(arr, n, i);
		
		for(int i=n-1;i>=0;i--)
		{
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			
			minHeapify(arr,i,0);
		}
		
		
	}
	
	public static void minHeapify(int[] arr, int n, int i)
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
			
			minHeapify(arr, n, smallest);
		}
		
	}
	
	public static void main(String[] args)
	{
		int[] arr= {50, 23, 12, 9, 30, 2, 1};
		
		int ans=kSmall(arr, 3);
		System.out.println(ans);
		Arrays.sort(arr);
		//sortDesc(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
