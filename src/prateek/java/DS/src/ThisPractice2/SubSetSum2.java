package ThisPractice2;

public class SubSetSum2 {

	private static void solve(int[] set, int sum) {

		int[][] res = new int[set.length + 1][sum + 1];

		for (int i = 0; i <= set.length; i++) {
			res[i][0] = 1;
		}

		for (int i = 1; i <= set.length; i++) {
			for (int j = 1; j <= sum; j++) {

				if (res[i - 1][j] == 1) {
					res[i][j] = 1;
				}

				else if (j >= set[i - 1]) {
					res[i][j] = res[i - 1][j - set[i - 1]];
				}

			}

		}

		int j = sum;
		int i = set.length;
		if (res[i][j] == 1) {

			StringBuilder stb = new StringBuilder();
			while (i > 0 || j > 0) {
				if (res[i - 1][j] == 1) {
					i = i - 1;
				} else {
					stb.append(set[i - 1] + ",");
					j = j - set[i - 1];
					i = i - 1;
					
				}

			}
			System.out.print("solution is--" + stb);

		} else
			System.out.print("No solution");

	}

	public static void main(String[] args) {

		int[] set = { 3, 4, 5, 2 };
		for (int i = 1; i <= 25; i++) {
			System.out.print(i + "---");
			solve(set, i);
			System.out.println("\n");

		}

	}
}
