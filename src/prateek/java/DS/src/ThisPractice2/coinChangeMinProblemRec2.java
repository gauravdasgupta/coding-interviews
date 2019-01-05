package ThisPractice2;

public class coinChangeMinProblemRec2 {

	public static int solve(int[] arr, int total) {
		int res = Integer.MAX_VALUE;

		if (total == 0) {
			return 0;
		}

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > total)
				continue;

			int tempRes = solve(arr, total - arr[i]);

			if (tempRes < res)
				res = tempRes;
		}

		if (res != Integer.MAX_VALUE)
			res = res + 1;

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };
		int total = 13;
		System.out.print(solve(arr, total));

	}

}
