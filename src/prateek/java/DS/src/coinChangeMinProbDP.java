import java.util.*;

public class coinChangeMinProbDP {

	public static int solveCoinChangeMinProbDP(int[] arr, int total) {

		int[] temp1 = new int[total + 1];
		int[] temp2 = new int[total + 1];

		temp1[0] = 0;
		for (int i = 1; i <= total; i++) {
			temp1[i] = Integer.MAX_VALUE - 1;
			temp2[i] = -1;

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < temp1.length; j++) {
				if (j >= arr[i]) {
					if (temp1[j - arr[i]] + 1 < temp1[j]) {

						temp1[j] = temp1[j - arr[i]] + 1;
						temp2[j] = i;
					}

				}

			}

		}

		System.out.println("Priinting all coins");
		int tempTotal = total;
		List<Integer> s1 = new ArrayList<>();

		while (tempTotal != 0) {
			int k = arr[temp2[tempTotal]];
			// System.out.print(k+",");
			s1.add(k);
			tempTotal = tempTotal - k;
		}

		System.out.print(s1);

		return temp1[total];

	}

	public static void main(StringTest[] args) {
		int total = 10;
		int[] arr = { 2, 3, 6, 9 };
		System.out.println("Minimum coins required are: " + solveCoinChangeMinProbDP(arr, total));
	}

}
