package ThisJune42018;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayCreation {
	int size;
	int[] arr;	
	public ArrayCreation(int size)
	{
		this.size=size;
		arr=new int[size];
	}
	
	public ArrayCreation(int[] arr)
	{
		this.arr=arr;
		this.size=arr.length;
		
	}
	

	public int[] createArray()
	{

		for(int i=0;i<size;i++)
		{
			arr[i]=i+1;
		}
		
		return arr;

	}
	
	public void print()
	{
		System.out.print("\n");
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
			
		}
		System.out.print("\n");
		
	}
	
	public int binarySearch( int key)
	{
		
		return binarySearchR(arr,key,0,arr.length-1);
	}
	
	private int binarySearchR(int[] arr, int key,int start, int end)
	{

		int mid=end-(end-start)/2;

		if(start>=end || mid==start || mid==end)
			return -1;	
		
		
		if(arr[mid]==key)
			return mid;
		
		if(arr[mid]>key)
 			return binarySearchR(arr,key,start,mid);
		else 
			return binarySearchR(arr,key,mid,end);


		
		
	}
	
	public void pairSum(int sum)
	{
		Arrays.sort(arr);
		
		int l=0;
		int r=arr.length-1;
		while(l<r)
		{
			if(arr[l]+arr[r]==sum)
			{
				System.out.println("Pair exits : "+arr[l]+" , "+arr[r]);
				return;
			}
			if(arr[l]+arr[r]<sum)
			{
				l++;
			}
			if(arr[l]+arr[r]>sum)
			{
				r--;
			}
			
		}
		System.out.println("Such pair dosent exists");
	}
	
	public void pairSumSet(int sum)
	{
		HashSet<Integer> hset=new HashSet<>();
		int temp;
		
		for(int i=0;i<arr.length;i++)
		{
			temp=sum-arr[i];
			if(hset.contains(temp))
			{
				System.out.println("Pair exits: "+arr[i]+" , "+temp);
				return;
			}
			hset.add(arr[i]);
			
		}
		System.out.println("Such Pair doesnt exits");
		
	}
	
	public void pairSumInSortedRotatedArray(int sum)
	{
		int i;
		for(i=0;i<arr.length;i++)
		{
			if(arr[i]>arr[i+1])
				break;
		}
		
		//More generic method to find is as below: just change method to return -1 when r<l
		//i=minInRotatedSortedArray(0,size-1);
		System.out.println(i);
		int l=i+1;
		int r=i;
		
		while(l!=r)
		{
			if(arr[r]+arr[l]==sum)
			{
				System.out.println("Pair exists : "+arr[l]+" , "+arr[r]);
				return;
			}
			if(arr[l]+arr[r]<sum)
			{
				l=(l+1)%size;
			}
			if(arr[l]+arr[r]>sum)
			{
				r=(size+r-1)%size;
				
			}
		}
		
		System.out.println("Such Pair dosesnt exists ");
		
		
	}
	
	public int minInRotatedSortedArray(int l, int r)
	{
		if(r<l)
			return 0;
		if(r==l)
			return r;
		int mid=l+(r-l)/2;
		
		if(mid>l && arr[mid-1]>arr[mid])
			return mid;
		if(mid<r && arr[mid]>arr[mid+1])
			return mid+1;
		
		if(arr[mid]<arr[r])
			return minInRotatedSortedArray(l,mid-1);
		else
			return minInRotatedSortedArray(mid+1,r);		
	}
	
	public void quickRotation(int k)
	{
		System.out.print("\n");
		for(int i=k;i<k+size;i++)

		{
			System.out.print(arr[i%size]+" ");
			
		}

		
	}
	 
	
	public static void main(String[] args)
	{

		//int arr[] = {50,75,100,120, 4, 8, 20, 40};
		//ArrayCreation a=new ArrayCreation(arr);   
		//System.out.println(a.binarySearch( 30));
		
		
		ArrayCreation a=new ArrayCreation(10);
		a.createArray();
		
		a.print();
		//a.pairSumInSortedRotatedArray(15);
		//a.print();
		
		//int indexofRotation=a.minInRotatedSortedArray(0,a.size-1);
		//System.out.println("First element of main arrya(before rotation) and minimum value of the rotated array is : "+a.arr[indexofRotation]);
		a.quickRotation(3);
		a.quickRotation(1);
		a.quickRotation(15);
	
	}
	
}
