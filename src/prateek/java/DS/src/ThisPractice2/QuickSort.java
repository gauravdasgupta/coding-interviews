package ThisPractice2;

import java.util.Arrays;

public class QuickSort {

	private static void solve(int[] arr, int l, int r) {

		if (l < r) {
			int pi = pivot(arr, l, r);
			solve(arr,l,pi-2);
			solve(arr,pi,r);
		}

	}

	private static int pivot(int[] arr, int l, int r) {

		int i = l;
		int pivot = arr[r];

		for (int j = l; j <= r; j++) {
			if (arr[j] <= pivot) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 99, 2, 6, 5, 4 };
		solve(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
