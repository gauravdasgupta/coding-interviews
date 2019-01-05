package ThisDay1;

import java.util.Random;
import java.util.Arrays;
public class ReverseArrayRotation {

	public static void main(String args[]) {
		int arr[]= new int[10];
		//{1,5,22,18,26,3};	    	
	generatearr(arr);
	printarr(arr);
	System.out.print("\n");
	rotatearr(arr,3);
	printarr(arr);
	}

	private static void rotatearr(int arr[], int x) {
		reversearr(arr,0,x-1);
		reversearr(arr,x,arr.length-1);
		reversearr(arr,0,arr.length-1);		
	}
	
	private static void reversearr(int arr[], int sp, int ep) {
		
		System.out.print("In reverse"+sp+","+ep+"--");
		int temp=0;
		while(sp<ep)
		{	
			//System.out.println(arr[sp]+"_-_"+arr[ep]);
			temp=arr[ep];
			arr[ep]=arr[sp];
			arr[sp]=temp;
			sp++;
			ep--;
		}
		
		System.out.println("In reverse"+sp+","+ep+"---"+Arrays.toString(arr));
		
		
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
	
	
	
}

