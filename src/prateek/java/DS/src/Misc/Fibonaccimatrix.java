package Misc;

public class Fibonaccimatrix {

	public static void multiply(int[][] f, int [][] m)
	{
		int x =  f[0][0]*m[0][0] + f[0][1]*m[1][0];
	    int y =  f[0][0]*m[0][1] + f[0][1]*m[1][1];
	    int z =  f[1][0]*m[0][0] + f[1][1]*m[1][0];
	    int w =  f[1][0]*m[0][1] + f[1][1]*m[1][1];

	    f[0][0] = x;
	    f[0][1] = y;
	    f[1][0] = z;
	    f[1][1] = w;

	}
	
	public static void power(int[][] f,int n)
	{
		int[][] m={{1,1},{1,0}};
		for(int i=2;i<=n;i++)
		{
			multiply(f,m);

		}
		
	}
	
	
	public static void powerEfficient(int[][] f,int n)
	{
		if(n==0 || n==1)
			return;
		
		int[][] m={{1,1},{1,0}};
		powerEfficient(f,n/2);
		multiply(f,f);
		
		if(n%2!=0)
			multiply(f,m);
		
		
		
	}
	
	
	
	public static int fibMat(int num)
	{
		if(num<=1)
			return num;
		int f[][]= {{1,1},{1,0}};
		
		//power(f,num-1);
		powerEfficient(f,num-1);
		
		return f[0][0];
	}
	public static void main(String[] args)
	{
		int num=55;
		int result=fibMat(num);
		System.out.println("Result is : "+result);
		
		
		
	}
	
}
