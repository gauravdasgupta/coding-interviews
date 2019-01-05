package ThisPractice2;

import java.util.Arrays;

public class HeapSort22 {

	private static void solve(int[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, i, n);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr,0,i);
		}

	}

	private static void heapify(int[] arr, int i, int n) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int big = i;
		if (l < n && arr[l] >= arr[big])
			big = l;

		if (r < n && arr[r] >= arr[big])
			big = r;

		if (big != i) {
			int temp = arr[i];
			arr[i] = arr[big];
			arr[big] = temp;
			heapify(arr, big, n);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 123, 4, 5, 2, 1, 3, 6 };
		solve(arr);
		System.out.println(Arrays.toString(arr));
	}

}
