package DP;

public class MinimumEditDsitance {

	public static void solve(String org, String new1) {
		char[] oarr = org.toCharArray();
		char[] narr = new1.toCharArray();
		int[][] arr = new int[narr.length + 1][oarr.length + 1];

		for (int i = 0; i <= Math.max(narr.length, oarr.length); i++) {
			if (i <= oarr.length)
				arr[0][i] = i;

			if (i <= narr.length)
				arr[i][0] = i;
		}

		for (int i = 1; i <= narr.length; i++) {
			for (int j = 1; j <= oarr.length; j++) {

				if (oarr[j - 1] == narr[i - 1]) {
					arr[i][j] = arr[i - 1][j - 1];
				} else {
					arr[i][j] = Math.min(Math.min(arr[i - 1][j], arr[i - 1][j - 1]), arr[i][j - 1]) + 1;
				}

			}

		}
		int i=narr.length;
		int j=oarr.length;
		System.out.println("Solution is:-"+arr[i][j]);

	}

	public static void main(String[] args) {
		String org = "abcdef";
		String new1 = "azced";
		solve(org, new1);
	}

}
