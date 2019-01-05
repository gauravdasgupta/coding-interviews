package ThisPractice2;

import java.util.Stack;

public class LongestCommonSubsequence2 {

	public static void solve(char[] arr1, char[] arr2) {
		int[][] arr = new int[arr1.length + 1][arr2.length + 1];

		for (int i = 1; i <= arr1.length; i++) {
			for (int j = 1; j <= arr2.length; j++) {
				if (arr1[i - 1] == arr2[j - 1]) {
					arr[i][j] = Math.max(Math.max(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1] + 1);
				} else
					arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
			}

		}

		System.out.println("Result is:" + arr[arr1.length][arr2.length]);

		printSolve(arr, arr1, arr2);

	}

	public static void printSolve(int[][] arr, char[] arr1, char[] arr2) {
		int i = arr1.length;
		int j = arr2.length;
		Stack<Character> st = new Stack<>();

		while (i != 0 && j != 0) {
			if (arr[i][j] != arr[i - 1][j] || arr[i][j] != arr[i][j - 1]) {
				st.push(arr1[i - 1]);
				i = i - 1;
				j = j - 1;
			} else {

				if (arr[i][j] == arr[i - 1][j])
					i = i - 1;
				else
					j = j - 1;
			}
		}

		while (!st.isEmpty()) {
			char temp = st.peek();
			System.out.print(temp + ",");
			st.pop();
		}

	}

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		solve(s1.toCharArray(), s2.toCharArray());

	}

}
