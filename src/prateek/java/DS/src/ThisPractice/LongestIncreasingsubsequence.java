package ThisPractice;

public class LongestIncreasingsubsequence {

	public static void solveLongestIncreasingsubsequence(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = 1;
		}

		int finalRes=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[j]<arr[i])
				{
					res[i]=Math.max(res[j]+1,res[i]);
					
				}
			}
			finalRes=Math.max(res[i], finalRes);
			
		}
	System.out.println("Final result is: "+finalRes);
		
	}

	public static void main(String[] args) {
		int arr[] = //{ 23, 10, 22, 5, 33, 8, 9, 21, 50, 41, 60, 80, 99, 22, 23, 24, 25, 26, 27 };
			{3,4,-1,0,6,2,3};
		solveLongestIncreasingsubsequence(arr);

	}
}
