package Misc;

//https://www.geeksforgeeks.org/ugly-numbers/

public class uglyNumber {

	public static int reduceIt(int n,int div)
	{
		while(n%div==0)
		{
			n=n/div;
		}
		return n;
		
	}
	
	public static boolean isUgly(int n)
	{
		n=reduceIt(n,2);
		n=reduceIt(n,3);
		n=reduceIt(n,5);
		
		if(n==1)
		return true;
		else return false;
	}
	
	public static int uglyNum(int num)
	{
		int i=1;
		int count=1;
		
		while(num>count)
		{
			i++;
			if(isUgly(i))
			{
				count++;
			}
		}
		
		return i;
	}
	
	public static void main(String[] args)
	{
		int num=150;
		System.out.println("The "+num+"th ugliest number is: "+uglyNum(num));
		
	}
}
