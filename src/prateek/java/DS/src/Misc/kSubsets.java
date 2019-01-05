package Misc;

//https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

//S(n+1, k) = k*S(n, k) + S(n, k-1)

public class kSubsets {

	public static int ways(int n, int k)
	{
		if(n==0 ||k==0 || k>n)
			return 0;
		if(n==1 || k==1 || k==n)
			return 1;
		
		else return (k*ways(n-1,k)+ways(n-1,k-1));
	}
	
	public static void main(String[] args)
	{
		int n=3;
		int k=2;
		System.out.println("Number of ways is : "+ways(n,k));
		
		
	}
}
