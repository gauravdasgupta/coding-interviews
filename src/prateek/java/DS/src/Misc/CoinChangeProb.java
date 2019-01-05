package Misc;

public class CoinChangeProb {

	public static int count(int[] arr, int len, int sum)
	{
		if(sum==0)
			return 1;
		if(len<=0 || sum<0)
			return 0;
		
		
		return 
				count(arr, len-1,sum)+count(arr,len,sum-arr[len-1]);
	}
	
	
	public static void main(String[] args)
	{		
		int i, j;
        int arr[] = {2, 5, 3, 6};
        int m = arr.length;
        System.out.println( count(arr, m, 10));
	}
}
