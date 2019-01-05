package Array;

import java.util.Arrays;

//testing

public class kElement {

	public static int kSmall(int[] arr, int k) {

		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			minHeapify(arr, n, i);
		int i = n - 1;
		for (; i > n - k; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			minHeapify(arr, i, 0);
		}
		minHeapify(arr, i, 0);
		return arr[0];

	}

	public static void minHeapify(int[] arr, int n, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;

		if (l < n && arr[l] <= arr[largest])
			largest = l;
		if (r < n && arr[r] <= arr[largest])
			largest = r;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			minHeapify(arr, n, largest);

		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 23, 12, 9, -22, 30, 2, 50 };

		int ans = kSmall(arr, 5);
		System.out.println(ans);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
