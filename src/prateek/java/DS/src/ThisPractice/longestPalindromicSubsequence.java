package ThisPractice;

public class longestPalindromicSubsequence {

	public static int lengthCalculate(char[] arr)
	{
		int[][] res=new int[arr.length+1][arr.length+1];
		
		for(int i=0;i<=arr.length;i++)
		{
			res[i][i]=1;
		}
		
		for(int l=2;l<=arr.length;l++)
		{
			for(int i=0;i<arr.length-l+1;i++)
			{
				int j=i+l-1;
				
				if(l==2 && arr[i]==arr[j])
				{
					res[i][j]=2;
				}
				else if(arr[i]==arr[j])
				{
					res[i][j]=2+res[i+1][j-1];
				}
				else
				{
					res[i][j]=Math.max(res[i+1][j], res[i][j-1]);
					
				}
				
				
			}
			
		}
		
		return res[0][arr.length-1];
	}
	
	
	public static void main(String[] args)
	{
		
		String str = "agbdba";
		System.out.println("required answert is: "+lengthCalculate(str.toCharArray()));
		
	}
}
