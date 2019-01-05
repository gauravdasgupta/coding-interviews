package ThisPractice2;

public class MinimumEditDistance {

	private static void solve(String org, String new1) {

		int[][] res = new int[org.length() + 1][new1.length() + 1];
		char[] oarr = org.toCharArray();
		char[] narr = new1.toCharArray();

		for (int i = 0; i <= Math.max(org.length(), new1.length()); i++) {
			if (i <= new1.length())
				res[0][i] = i;

			if (i <= org.length())
				res[i][0] = i;
		}

		for (int i = 1; i <= org.length(); i++) {
			for (int j = 1; j <= new1.length(); j++) {

				if (oarr[i - 1] == narr[j - 1])
					res[i][j] = res[i - 1][j - 1];
				else {
					res[i][j] = Math.min(Math.min(res[i - 1][j - 1], res[i - 1][j]), res[i][j - 1]) + 1;
				}

			}

		}

		System.out.println(res[org.length()][new1.length()]);
		System.out.println("Solution is");

		int i = org.length();
		int j = new1.length();
		while (i != 0 || j != 0) {

			if (oarr[i - 1] == narr[j - 1]) {
				i = i - 1;
				j = j - 1;
			} else if (res[i][j] == res[i - 1][j - 1] + 1) {
				System.out.println(
						"Update org string chareacter--" + oarr[i - 1] + " to new string character--" + narr[j - 1]);
				i = i - 1;
				j = j - 1;
			} else if (res[i][j] == res[i - 1][j] + 1) {
				System.out.println("delte from org string chareacter--" + oarr[i - 1]);
				i = i - 1;
			} else if (res[i][j] == res[i][j - 1] + 1) {
				System.out.println("delte from new string chareacter--" + narr[j - 1]);
				j = j - 1;
			}
		}
	}

	public static void main(String[] args) {
		String org = "abcdef";
		String new1 = "azced";
		solve(org, new1);

	}

}
