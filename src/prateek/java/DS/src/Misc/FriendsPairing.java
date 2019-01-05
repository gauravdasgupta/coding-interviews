package Misc;

//https://www.geeksforgeeks.org/friends-pairing-problem/

//f(n+1)=f(n)+f(n-1)*(n)
//f(n)=f(n-1)+(n-1)*f(n-2)

public class FriendsPairing {

	
	public static int countFriendsPairings(int n)
	{
		if(n<=0)
			return 0;		
		if(n<=2)
			return n;

		return (countFriendsPairings(n-1)+(n-1)*countFriendsPairings(n-2));
	}
	
	 public static void main (String[] args)
	    {
	        int n = 4;
	        System.out.println (countFriendsPairings(n));
	     
	    }
}
