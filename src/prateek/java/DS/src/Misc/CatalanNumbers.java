package Misc;

public class CatalanNumbers {

	final int[] DP;
	final int NIL=-1;
	public CatalanNumbers()
	{
		DP=new int[100];
		
		for(int i=0;i<DP.length;i++)
			DP[i]=NIL;
	}
	
	
	
	
	public static int catalan1(int n)
	{
		if(n<=1)
			return 1;
		
		int res=0;
		
		for(int i=0;i<n;i++)
			res+=catalan1(i)*catalan1(n-i-1);
		
		
		return res;
	}
	
	public int catalan2(int n)
	{
		if(n<=1)
		{
			if(DP[n]==NIL)
				DP[n]=1;
			return 1;
		}//DP[n]=0;
		
		if(DP[n]==NIL)
		{
			DP[n]=0;
			for(int i=0;i<n;i++)
				DP[n]+=catalan2(i)*catalan2(n-i-1);
		}
		
		
		return DP[n];
	}
	
	public static void main(String[] args)
	{
		long st=System.currentTimeMillis();
		int num=20;
		System.out.println("Required catalan numbers are: ");
		
		CatalanNumbers obj=new CatalanNumbers();
		
		for(int i=0;i<num;i++)
			System.out.print(obj.catalan2(i)+" ");
		
		long dur=System.currentTimeMillis()-st;
		System.out.println("\n Duration is :"+dur);
		
		
	}
}
