package DP;

import java.util.Stack;

public class LongestCommonSubsequence {

	public static void solve(char[] arr1, char[] arr2) {
		int[][] arr = new int[arr1.length + 1][arr2.length + 1];

		for (int i = 1; i <= arr1.length; i++) {
			for (int j = 1; j <= arr2.length; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					arr[i][j] = Math.max(Math.max(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1] + 1);
				} else {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}

		}

		System.out.println("Solution is : " + arr[arr1.length][arr2.length]);

		int i = arr1.length;
		int j = arr2.length;
		Stack<Character> st=new Stack<>();
				
		while (i > 0 && j > 0) {
			if(arr[i][j]!=arr[i-1][j] && arr[i][j]!=arr[i][j-1])
			{
				st.push(arr1[i-1]);
				i--;
				j--;
			}
			else if(arr[i][j]==arr[i-1][j])
				i--;
			else if(arr[i][j]==arr[i][j-1])
				j--;
		}
		
		while(!st.isEmpty())
		{
			char temp=st.peek();
			st.pop();
			System.out.print(temp+",");
			
		}

	}

	public static void main(String[] args) {

		 String s1 = "abcdaf";
		String s2 = "acbcf";

		//String s1 = "AGGTAB";
		//String s2 = "GXTXAYB";
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();

		solve(arr1, arr2);

	}

}
