package ThisPractice;

public class coinChangeMinProblemRec {
	
	public static int minCoins(int[] arr,int total)
	{
		if(total==0)
			return 0;
		int res=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>total)
				continue;
			int recRes=minCoins(arr,total-arr[i]);
			
			if(recRes<res)
				res=recRes;
			
		}
		
		if(res!=Integer.MAX_VALUE)
			res=res+1;
		
		
		return res;
	}
	
	public static void main(String[] args)
	{
		int total=10;
		int[] arr= {2,3,6,7};
		
		System.out.println("Minimum coins required are: "+minCoins(arr,total));
	}

}
