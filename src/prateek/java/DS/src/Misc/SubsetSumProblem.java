package Misc;

public class SubsetSumProblem {
	
	
	public static boolean isSubsetSum(int[] arr, int n, int sum)
	{
		if(sum==0)
			return true;
		if(n<=0 || sum<0)
			return false;
		
		else 
		return (isSubsetSum(arr,n-1,sum-arr[n-1]) || isSubsetSum(arr,n-1,sum));
	}
	
	public static void main (String args[])
    {
        int set[] = {11,2,10,99,839,7};
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                          + " with given sum");
        else
            System.out.println("No subset with"
                               + " given sum");
    }

}
