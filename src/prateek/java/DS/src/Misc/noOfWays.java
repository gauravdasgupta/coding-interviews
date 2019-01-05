package Misc;


//https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
public class noOfWays {
	final static int N1=1;
	final static int N2=3;
	final static int N3=5;
	
	public static int solve(int num)
	{
		if(num<0)
			return 0;
		if(num==0)
			return 1;
		
		return solve(num-N1)+solve(num-N2)+solve(num-N3);
		
	}
	
	
	public static void main(String[] args)
	{
		int reqSum=6;
		int ways=solve(reqSum);
		System.out.println("Required number of ways is : "+ways);
		
		
		
		
	}

}
