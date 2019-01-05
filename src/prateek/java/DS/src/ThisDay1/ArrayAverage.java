package ThisDay1;

import java.util.Arrays;

public class ArrayAverage {

	public static void main(String[] args) {
		int arr[]=new int[10];
		int avg[]=new int[10];
		int s=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=(i+1)*10;
		}
	System.out.println(Arrays.toString(arr)+" ");
	
	for(int i=0;i<arr.length;i++) {
		s+=arr[i];
		avg[i]=s/(i+1);		
	}
	System.out.println(Arrays.toString(avg)+" ");
	
	
		
	}
	
	
}
