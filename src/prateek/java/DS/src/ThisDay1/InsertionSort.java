package ThisDay1;

import java.util.Arrays;
import java.util.Random;

 class InsertionSort {

	public static void main (String[] args)
	{
		System.out.println("Do it-1");
		int arr[]= new int[10];
			//{1,5,22,18,26,3};	    	
		generatearr(arr);
		printarr(arr);
		System.out.println("\n"+"Do it-2");
		insertionsort(arr);
		System.out.println(Arrays.toString(arr));	
		
		String array=Arrays.toString(arr);
		System.out.println(array);
		System.out.println(arr);
		//printarr(arr);
		
	}
	
	private static void generatearr(int arr[]) {
		Random rn=new Random();
		for (int i=0;i<arr.length;i++)
		{
			arr[i]=rn.nextInt(50);
			
		}	
	}
	private static void printarr(int arr[]) {
		for(int s:arr)
			System.out.print(s+" ");
		
	}
	
	
	private static void insertionsort(int arr[]) {
		int j,temp;
		for(int i=1;i<arr.length;i++) {
			j=i-1;
			temp=arr[i];
			while (j>=0 && temp<=arr[j])
			{
				arr[j+1]=arr[j];
				arr[j]=temp;
				j--;

			} 

			
		}
		System.out.println("end- insertion Method");
		
	}
	
	
	
}

