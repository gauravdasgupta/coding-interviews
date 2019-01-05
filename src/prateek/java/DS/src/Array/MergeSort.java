package Array;

import java.util.Arrays;

public class MergeSort {

	
	public static void sort(int[] arr, int l,int m, int r)
	{
		int llen=m-l+1;
		int rlen=r-m;
		int[] larr=new int[llen];
		int [] rarr=new int[rlen];
		
		for(int i=0;i<llen;i++)
			larr[i]=arr[l+i];
		
		for(int i=0;i<rlen;i++)
			rarr[i]=arr[m+1+i];
		
		int ll=0;
		int rr=0;
		int k=l;
		
		while(ll<llen && rr<rlen)
		{
			if(larr[ll]<rarr[rr])
			{
				arr[k]=larr[ll++];
				
			}
			
			else
			{
				arr[k]=rarr[rr++];
				
			}
			
			k++;
		}
		//System.out.println("left :"+llen+" , "+ll );
		//System.out.println("right :"+rlen+" , "+rr );
		
		while(ll<llen)
		{
			arr[k]=larr[ll++];
			k++;
		}
		
		while(rr<rlen)
		{
			arr[k]=rarr[rr++];
					k++;
			
		}
		
		
	}
	
	public static void mergeSort1(int[] arr, int l, int r)
	{
		
		if(l<r)
		{
			int m=(l+r)/2;
			
			mergeSort1(arr, l,m);
			mergeSort1(arr, m+1,r);
			
			sort(arr,l,m,r);
			
		}
		
		
	}
	
	public static void main(String[] args)
	{
		int[] arr={12, 11, 13, 5, 6, 7};
		
		int[] arr1=new int[8];
		int a=3;
		//Integer a1=3//new Integer(3);
		
		System.out.println(Arrays.toString(arr));
		mergeSort1(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
}
