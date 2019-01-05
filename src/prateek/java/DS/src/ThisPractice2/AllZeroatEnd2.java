package ThisPractice2;

import java.util.Arrays;

public class AllZeroatEnd2 {

	private static void solve(int[] arr) {
		int pivot=0;
		int i=0;
		for(int j=0;j<arr.length;j++)
		{
			if(arr[j]!=pivot)
			{
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				i++;
			}
			
		}
	}

	public static void main(String[] args) {

		int[] arr = //{ 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		//{1, 2, 0, 0, 0, 3, 6};
		 {1, 2,-1, 0, 4, 3, 0, 5, 0};
		solve(arr);
		System.out.println(Arrays.toString(arr));
	}
}
