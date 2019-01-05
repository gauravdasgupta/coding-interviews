package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxHamming {

	public static int maxHammingDistance(int[] arr) {
		int len = arr.length;
		int maxHam = 0;
		int currHam = 0;
		for (int i = 1; i < len; i++) {
			int j = i;
			currHam = 0;

			for (int k = 0; k < len; k++) {
				if (arr[k] != arr[(k + i) % len])
					currHam++;
			}

			maxHam = Math.max(currHam, maxHam);

		}

		return maxHam;
	}

	public static void reArrangeArray(int[] arr) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int x, y;
			if (arr[i] != -1 && arr[i] != i) {
				x = arr[i];
				while (arr[x] != -1 && arr[x] != x) {
					y = arr[x];
					arr[x] = x;
					x = y;
				}
			}

		}
		for (int i = 0; i < len; i++)

			if (arr[i] != i)
				arr[i] = -1;

	}

	public static int[] reArrangeArray2(int[] arrr) {
		int len = arrr.length;
		int[] arr = arrr;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < len; i++) {
			set.add(arr[i]);
		}
		for (int i = 0; i < len; i++) {
			if (set.contains(i))
				arr[i] = i;
			else
				arr[i] = -1;
		}

		return arr;
	}

	public static void sortEvenOdd(int[] arr) {
		Arrays.sort(arr);
		int len = arr.length;
		int[] temp = new int[len];
		for (int i = 0; i < len; i++)
			temp[i] = arr[i];
		int oddlast, evenlast;

		// filling the odd positions from backwawrd
		if (len % 2 == 0) {
			oddlast = len - 2;
			evenlast = len - 1;
		} else

		{
			oddlast = len - 1;
			evenlast = len - 2;
		}

		for (int i = oddlast, j = 0; i >= 0; i = i - 2, j++) {
			arr[i] = temp[j];
		}

		for (int i = evenlast, j = len - 1; i >= 0; i = i - 2, j--) {
			arr[i] = temp[j];

		}

	}

	public static void binarysearch(int[] arr, int data) {
		Arrays.sort(arr);
		int x = binarySearchR(arr, data, 0, arr.length);
		if (x != -1) {
			System.out.println("Index is " + x + ", Element is :" + arr[x]);
		} else
			System.out.println("No such element exists");

	}

	private static int binarySearchR(int[] arr, int data, int start, int end) {
		int mid = (start + end) / 2;
		if (arr[mid] == data)
			return mid;
		if (start >= end)
			return -1;
		if (arr[mid] > data) {
			return binarySearchR(arr, data, start, mid - 1);

		} else
			return binarySearchR(arr, data, mid + 1, end);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8, 1, 3, 5, 0 };
		// {1,2,3,4,7,7,7,8,9,88,99};

		binarysearch(arr, 6);

		// System.out.println(Arrays.toString(reArrangeArray2(arr)));
		// reArrangeArray(arr);
		// System.out.println(Arrays.toString(arr));

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		sortEvenOdd(arr);
		System.out.println("here it is: "+Arrays.toString(arr));

		// int[] arr= {1,4,1};
		System.out.println("Maximum Hamming distance is :" + maxHammingDistance(arr));
	}
}
