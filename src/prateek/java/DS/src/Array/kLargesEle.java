package Array;

import java.util.Arrays;

public class kLargesEle {

	public static int kLarge(int[] arr, int k)
	{
		
		int n=arr.length;
		for(int  i=n/2-1;i>=0;i--)
			heapify(arr, n,i);
		int i=n-1;
		for(;i>n-k;i--)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr, i,0);
		}
		heapify(arr,i,0);
		return arr[0];
		
		

	}
	
	public static void heapify(int[] arr, int n, int i)
	{
		int l=2*i+1;
		int r=2*i+2;
		int largest=i;
		
		if(l<n && arr[l]>=arr[largest])
			largest=l;
		if(r<n && arr[r]>=arr[largest])
			largest=r;
		
		if(largest!=i)
		{
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			
			heapify(arr, n, largest);
			
		}
		
	}
	
	public static void main(String[] args)
	{
		int[] arr= {1, 23, 12, 9, 30, 2, 50};
		
		int ans=kLarge(arr, 5);
		System.out.println(ans);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
}
