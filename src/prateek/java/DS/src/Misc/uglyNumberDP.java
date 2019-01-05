package Misc;

public class uglyNumberDP {
	
	public static int uglyNumDP(int num)
	{
		int arr[]=new int[num+1];
		arr[0]=1;
		int n2,n3,n5;
		int i2=0;
		int i3=0;
		int i5=0;
		int minUgly;
		for(int i=1;i<num;i++)
		{
			n2=arr[i2]*2;
			n3=arr[i3]*3;
			n5=arr[i5]*5;
			minUgly=Math.min(n2, Math.min(n3,n5));
			
			if(minUgly==n2)
				i2++;
			if(minUgly==n3)
				i3++;
			if(minUgly==n5)
				i5++;
			
			arr[i]=minUgly;
		}
		
		
		
		
		return arr[num-1];
	}
	
	
	public static void main(String[] args)
	{
		
		int num=150;
		System.out.println("The "+num+"th ugliest number is(using new method): "+uglyNumDP(num));
		
	}

}
