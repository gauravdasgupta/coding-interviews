package DP;

public class KnapSack {

	public static void solve(int[] wt, int[] value, int w) {
		int[][] arr = new int[wt.length + 1][w + 1];

		for (int i = 1; i <= wt.length; i++) {
			for (int j = 1; j <= w; j++) {
				if (j >= wt[i - 1]) {
					arr[i][j] = Math.max(arr[i - 1][j], value[i - 1] + arr[i - 1][j - wt[i - 1]]);
				} else
					arr[i][j] = arr[i - 1][j];

			}

		}
		System.out.println("Result is:--" + arr[wt.length][w]);

		int i = wt.length;
		int j = w;

		StringBuffer sb = new StringBuffer("Elements are--");

		while (i > 0 && j > 0) {
			if (arr[i][j] != arr[i - 1][j]) {
				sb.append(wt[i - 1] + ",");
				j = j - wt[i - 1];
				i = i - 1;
			} else {
				i = i - 1;

			}

		}

		System.out.print(sb);

	}

	public static void main(String[] args) {

		int val[] = { 1, 4, 5, 7 };
		int wt[] = { 1, 3, 4, 5 };
		solve(wt, val, 15);

	}

}
