package DP;

public class CoinChangeMinProblem {

	private static void solve(int[] arr, int total) {
		int[] arr1 = new int[total + 1];
		int[] arr2 = new int[total + 1];

		for (int i = 1; i <= total; i++) {
			arr1[i] = Integer.MAX_VALUE - 1;
			arr2[i] = -1;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j >= arr[i]) {
					if (arr1[j] > (arr1[j - arr[i]] + 1)) {
						arr1[j]=arr1[j - arr[i]] + 1;
						arr2[j]=i;
					}
				}
			}
		}
		
		if((arr1[total]!=Integer.MAX_VALUE-1) || arr1[total]!=Integer.MAX_VALUE)
		{
			System.out.print(arr1[total]+"---");
			int temptotal=total;
			//coins are as follows
			StringBuffer sb=new StringBuffer();
			
			while(temptotal!=0)
			{
				sb.append(arr[arr2[temptotal]]+",");
				temptotal=temptotal-arr[arr2[temptotal]];
			}
			
			
			System.out.print(sb);	
			
		}
		
	}

	public static void main(String[] args) {
		int total = 13;
		int[] arr = { 2, 3, 6, 7 };
		
		for(int i=2;i<=50;i++)
		{
		
			System.out.print(i+"  :----");
			solve(arr, i);
			System.out.println();
		}

	}
}
