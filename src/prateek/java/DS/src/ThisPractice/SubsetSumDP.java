package ThisPractice;

public class SubsetSumDP {

	public static boolean solveSubsetSumDP(int[] arr,int sum)
	{
		boolean[][] res=new boolean[arr.length+1][sum+1];
		for(int i=0;i<=arr.length;i++)
		{
			res[i][0]=true;
		}
		
		for(int i=1;i<=arr.length;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				if(j>=arr[i-1])
				{
					res[i][j]=res[i-1][j] || (res[i-1][j-arr[i-1]]);
				}
				else
				{
					res[i][j]=res[i-1][j];
				}
				
			}
			
		}
		
		return res[arr.length][sum];
		
	}
	
	public static void main(String[] args)
	{
		int[] arr= {2,3,7,8,10};
		int sum=20;
		System.out.println(solveSubsetSumDP(arr,sum));
		
	}
	
}
