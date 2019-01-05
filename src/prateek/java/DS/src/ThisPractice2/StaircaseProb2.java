package ThisPractice2;

public class StaircaseProb2 {
	
	public static int solve(int s)
	{
		if(s<=0)
			return 0;
		if(s==1)
			return 1;
		if(s==2)
			return 2;
		else
		return solve(s-1)+solve(s-2);
	}
	
	public static void main(String[] args)
	{
		int s = 4; 
        System.out.println("Number of ways = "+ solve(s)); 
		
	}

}
