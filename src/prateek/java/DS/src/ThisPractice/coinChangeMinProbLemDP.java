package ThisPractice;

public class coinChangeMinProbLemDP {

	public static int minCoinsDP(int[] arr, int total)
	{
		int[] tArr1=new int[total+1];
		int[] tArr2=new int[total+1];
		
		for(int i=1;i<tArr1.length;i++)
		{
			tArr1[i]=Integer.MAX_VALUE-1;
			tArr2[i]=-1;
		}
		

		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<=total;j++)
			{
				if(j>=arr[i])
				{
					if(tArr1[j-arr[i]]+1<tArr1[j])
					{
						tArr1[j]=tArr1[j-arr[i]]+1;
						tArr2[j]=i;
						
					}
				}
				
			}
			
		}
		
		
		return tArr1[total];
		
	}
	
	
	public static void main(String[] args)
	{
		int total=4;
		int[] arr= {2,3,6,7};
		
		System.out.println("Minimum coins required are: "+minCoinsDP(arr,total));
	}

	
}
