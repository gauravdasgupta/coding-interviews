package ThisPractice2;

import java.util.Arrays;

public class MergeSort22 {

	private static void merge(int[] arr, int l, int mid, int r) {
		int llen = mid - l + 1;
		int rlen = r - mid;

		int[] larr = new int[llen];
		int[] rarr = new int[rlen];

		for (int i = 0; i < llen; i++)
			larr[i] = arr[i + l];

		for (int i = 0; i < rlen; i++)
			rarr[i] = arr[mid + 1 + i];

		int li = 0;
		int ri = 0;
		int i = l;
		while (li < llen && ri < rlen) {
			if (larr[li] < rarr[ri]) {
				arr[i++] = larr[li++];
			} else {
				arr[i++] = rarr[ri++];

			}

		}

		while (li < llen)
			arr[i++] = larr[li++];

		while(ri<rlen)
			arr[i++] = rarr[ri++];
		
	}

	private static void solve(int[] arr, int l, int r) {

		if (l < r) {
			int mid = (l + r) / 2;
			solve(arr, l, mid);
			solve(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}

	}

	public static void main(String[] args) {
		int[] arr = { 123, 4, 5, 2, 1, 3, 6 };
		solve(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
