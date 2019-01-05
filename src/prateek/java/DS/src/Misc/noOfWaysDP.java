package Misc;

public class noOfWaysDP {

	final int N1=1;
	final int N2=3;
	final int N3=5;
	final int MAX=100;
	final int NIL=-1;
	final int[] DP;
	public noOfWaysDP()
	{
		DP=new int[MAX+1];
		for(int i=0;i<=MAX;i++)
			DP[i]=NIL;
		
	}
	
	
	public int solve(int num)
	{
		if(num<0)
			return 0;
		if(num==0)
			return 1;
		
		if(DP[num]==NIL)
		DP[num]= solve(num-N1)+solve(num-N2)+solve(num-N3);
		
		return DP[num];
	}
	
	
public static void main(String[] args)
{
 int reqSum=5;
 noOfWaysDP obj=new noOfWaysDP();
 int result=obj.solve(reqSum);
 System.out.println("Required number of ways is : "+result);
 
}
}
