package Misc;

public class BellNumbers {

	int[][] DP;
	final int  NIL;
	public BellNumbers()
	{
		NIL=-1;
		DP=new int[20][20];
		
		for(int i=0;i<DP.length;i++)
		{
			for(int j=0;j<DP[i].length;j++)
				DP[i][j]=NIL;
		}
				
		
	}
	
	public int waysNintoK(int n, int k)
	{
		if(n==0 || k==0 || k>n)
			return 0;
		
		if(k==1 || k==n)
			return 1;
		
		else 
		{
			if(DP[n][k]==NIL)
				DP[n][k]=k*waysNintoK(n-1,k)+waysNintoK(n-1,k-1);
			return DP[n][k];
		}
	}
	
	
	public  int bell(int n)
	{
		int result=0;
		
		for(int i=0;i<=n;i++)
			result+=waysNintoK(n,i);

		return result;
	}
	
	public static void main(String[] args)
	{
		int num=15;
		

		BellNumbers obj=new BellNumbers();
		
		for(int i=0;i<num;i++)
			System.out.println(i+"th Bell Number is: "+obj.bell(i));
		
		
	}
}
