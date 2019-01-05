package DP;

public class LongestPalindromicSubsequence {

	public static void solve(char[] st) {
		int[][] arr = new int[st.length][st.length];

		for (int i = 0; i < st.length; i++) {
			arr[i][i] = 1;
		}

		for (int l = 2; l <= st.length; l++) {
			for (int i = 0; i < st.length - l + 1; i++) {
				int j = i + l - 1;

				if (l == 2 && st[i] == st[j]) {
					arr[i][j] = 2;
				} else if (st[i] == st[j]) {
					arr[i][j] = arr[i + 1][j - 1] + 2;
				} else {
					arr[i][j] = Math.max(arr[i + 1][j], arr[i][j - 1]);
				}

			}
		}
		int i = 0;
		int j = st.length - 1;

		System.out.println("Solution is-: " + arr[i][j]);

		StringBuilder sb = new StringBuilder();
		while (true) {
			if (arr[i][j] != arr[i + 1][j] && arr[i][j] != arr[i][j - 1]) {
				sb.append(st[i] + " ");
				i++;
				j--;
			} else if (arr[i][j] == arr[i + 1][j])
				i++;
			else if (arr[i][j] == arr[i][j - 1])
				j--;
			
			if(i>j)
				break;
		}
		
		System.out.println(sb);

	}

	public static void main(String[] args) {
		String str = "NITIN";
		solve(str.toCharArray());
	}

}
