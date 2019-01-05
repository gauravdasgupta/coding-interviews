package ThisPractice2;

public class coinChangeMinProbLemDP2 {

	public static int solve(int[] arr, int total) {
		int[] arr1 = new int[total + 1];
		int[] arr2 = new int[total + 1];

		for (int i = 1; i <= total; i++) {
			arr1[i] = Integer.MAX_VALUE - 1;
			arr2[i] = -1;

		}

		for (int i = 0; i < arr.length; i++) {

			for (int j = 1; j <= total; j++) {
				if (j >= arr[i]) {
					if ((arr1[j - arr[i]] + 1) < arr1[j]) {
						arr1[j] = arr1[j - arr[i]] + 1;
						arr2[j] = i;
					}
				}
			}

		}

		int tempTotal = total;

		System.out.print("Coins are--");
		while (tempTotal != 0) {
			System.out.print(arr[arr2[tempTotal]] + ",");
			tempTotal = tempTotal - arr[arr2[tempTotal]];
		}
		System.out.println();

		return arr1[total];

	}

	public static void main(String[] args) {

		int total =8;
		int[] arr = { 2, 3, 6, 7 };
		System.out.println(solve(arr, total));
	}

}
