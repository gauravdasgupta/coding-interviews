package DP;

public class SubsetSum {

	public static void solve(int[] st, int sum) {
		int[][] arr = new int[st.length + 1][sum + 1];

		for (int i = 0; i <= st.length; i++) {
			arr[i][0] = 1;
		}

		for (int i = 1; i <= st.length; i++) {
			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1][j] == 1)
					arr[i][j] = 1;
				else if (j >= st[i - 1]) {
					arr[i][j] = arr[i - 1][j - st[i - 1]];
				}
			}
		}

		int i = st.length;
		int j = sum;

		StringBuilder sb = new StringBuilder("Solution is--");

		if (arr[i][j] == 1) {
			// System.out.print("True");
			while (i != 0 && j != 0) {
				if (arr[i - 1][j] == 1)
					i--;
				else {
					sb.append(st[i - 1] + ",");
					j = j - st[i - 1];
					i--;

				}
			}
			System.out.print("solution is--" + sb);

		} else
			System.out.print("NO Solution");

	}

	public static void main(String[] args) {
		int[] st = { 2, 3, 7, 8, 10 };

		System.out.print("25");solve(st, 25);
		
	//	for (int i = 1; i <= 35; i++) {
		//	System.out.print(i+" >> ");solve(st, i);
			//System.out.println();
		//}
	}
}
