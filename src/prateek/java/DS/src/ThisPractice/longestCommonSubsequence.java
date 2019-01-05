package ThisPractice;

import java.util.Stack;

public class longestCommonSubsequence {

	public static int findLCS(char[] arr1, char[] arr2) {
		int[][] resMatrix = new int[arr1.length + 1][arr2.length + 1];
		int max = 0;

		for (int i = 0; i <= arr1.length; i++) {
			for (int j = 0; j <= arr2.length; j++) {
				if (i == 0 || j == 0) {
					resMatrix[i][j] = 0;
					continue;
				}

				if (arr1[i - 1] == arr2[j - 1]) {
					resMatrix[i][j] = resMatrix[i - 1][j - 1] + 1;
				} else {
					resMatrix[i][j] = Math.max(resMatrix[i][j - 1], resMatrix[i - 1][j]);
				}
				max = Math.max(max, resMatrix[i][j]);
			}

		}

		return max;

	}

	

	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		System.out.println("Longest Common subsequence is:" + findLCS(s1.toCharArray(), s2.toCharArray()));

	}

}
