package ThisPractice2;

import java.util.Arrays;

public class ArrangePosNeg2 {

	private static void solve(int[] arr) {
		int i = 0;
		int pivot = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < pivot) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}
		}

		// i is the index of first postive or zero number
		int neg = 0;// start of neg number
		while (true) {
			if (arr[neg] >= 0 || i >= arr.length || neg >= arr.length || neg<i)
				break;
			int temp = arr[neg];
			arr[neg] = arr[i];
			arr[i] = temp;
			neg = neg + 2;
			i++;

		}

	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, -3, -1, -2 };
		solve(arr);
		System.out.println(Arrays.toString(arr));
	}

}
