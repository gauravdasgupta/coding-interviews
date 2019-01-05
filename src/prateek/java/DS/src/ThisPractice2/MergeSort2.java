package ThisPractice2;

import java.util.Arrays;

public class MergeSort2 {

	public static void merge(int[] arr, int start, int mid, int end) {
		int lLen = mid - start + 1;
		int rLen = end - mid;

		int[] larr = new int[lLen];
		int[] rarr = new int[rLen];

		for (int i = 0; i < lLen; i++) {
			larr[i] = arr[start + i];

		}

		for (int i = 0; i < rLen; i++) {
			rarr[i] = arr[mid + 1 + i];

		}

		int ltemp = 0;
		int rtemp = 0;
		int temp = start;

		while (ltemp < lLen && rtemp < rLen) {
			if (larr[ltemp] < rarr[rtemp]) {
				arr[temp] = larr[ltemp];
				temp++;
				ltemp++;
			}

			else {
				arr[temp] = rarr[rtemp];
				temp++;
				rtemp++;
			}

		}

		while (ltemp < lLen) {
			arr[temp] = larr[ltemp];
			temp++;
			ltemp++;

		}

		while (rtemp < rLen) {
			arr[temp] = rarr[rtemp];
			temp++;
			rtemp++;
		}

	}

	public static void solve(int[] arr, int start, int end) {

		int mid = (start + end) / 2;

		if (end > start) {

			solve(arr, start, mid);
			solve(arr, mid + 1, end);

			merge(arr, start, mid, end);
		}

	}

	public static void main(String[] args) {

		int[] arr = { 12, 11, 13, 5, 6, 7, 9 };
		System.out.println(Arrays.toString(arr));
		solve(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
