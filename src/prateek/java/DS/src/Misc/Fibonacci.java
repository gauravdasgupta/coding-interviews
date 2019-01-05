package Misc;

public class Fibonacci {

	int[] arr;
	final int NIL=-1;
	final int MAX=100;
	public  Fibonacci()
	{
		arr=new int[MAX+1];
		for(int i=0;i<=MAX;i++)
			arr[i]=NIL;
	}
	
	public int fibon(int n)
	{
		if(arr[n]==NIL)
		{
			if(n<=1)
				arr[n]=n;
			else
				arr[n]=fibon(n-1)+fibon(n-2);
		}
		return arr[n];
	}
	
	public static int fibo(int n)
	{
		
		if(n<=1)
			return n;
		else 
			return fibo(n-1)+fibo(n-2);
		
	}
	
	
	public static void main(String[] args)
	{
		final long st=System.nanoTime();
		int num=55;
		Fibonacci f=new Fibonacci();
		int result=f.fibon(num);
		
		//int result=fibo(num);
		System.out.println("Result is : "+result);
		final long et=System.nanoTime();
		final long dur=et-st;
		System.out.println(dur);
	}
}

