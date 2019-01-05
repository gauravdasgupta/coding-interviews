package ThisPractice;

import java.util.Arrays;

public class NumberFrequenciesInArray {

	// https://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-time/
	public static void countFrequencies(int[] arr, int n) {
		int i = 0;
		while (i < n) {
			if (arr[i] < 0) {
				i++;
				continue;
			}

			int elementIndex = arr[i] - 1;

			if (arr[elementIndex] < 0) {
				arr[elementIndex]--;
				arr[i] = 0;
				i++;
			} else {
				arr[i] = arr[elementIndex];
				arr[elementIndex] = -1;
			}

		}

		for (int j = 0; j < n; j++) {
			System.out.println((j + 1) + "-->" + Math.abs(arr[j]));
		}
	}

	// https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
	public static void zigZagFashionArray(int[] arr) {

		boolean isRightBigger = true;

		for (int i = 0; i < arr.length - 1; i++) {
			if ((isRightBigger && arr[i + 1] < arr[i]) || (!isRightBigger && arr[i + 1] > arr[i])) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
			isRightBigger = !isRightBigger;

		}
	}

	// https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
	public static int intIndexOfFirst1(int[] arr, int start, int end) {
		if (start >= end)
			return -1;

		// if(mid==0 && )

		if (arr[0] == 1)
			return 0;

		int mid = (start + end) / 2;
		if ((mid + 1) < arr.length && arr[mid] == 0 && arr[mid + 1] == 1)
			return mid + 1;

		if ((mid - 1) >= 0 && arr[mid - 1] == 0 && arr[mid] == 1)
			return mid;

		if (arr[mid] == 0)
			return intIndexOfFirst1(arr, mid + 1, end);
		return intIndexOfFirst1(arr, start, mid - 1);
	}

	// https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
	public static int rowsWithMaximum1s(int[][] arr) {

		int noOf1s = -1,rowIndex=-1;
		for (int i = 0; i < arr.length; i++) {
			int firstOne = intIndexOfFirst1(arr[i], 0, arr[i].length);
			// System.out.println(i+"--"+firstOne);

			if (firstOne != -1) {
				noOf1s = Math.max(noOf1s, (arr[i].length - firstOne));
				if(noOf1s==(arr[i].length - firstOne))
					rowIndex=i;
				
		}
	}

	return rowIndex;

	}

	public static void main(String[] args) {
		int arr[] =// { 1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1 };
		 { 2, 3, 3, 2, 5 };
		countFrequencies(arr, arr.length);

		int arr1[] = { 1, 4, 3, 2 };
		System.out.print("\n" + Arrays.toString(arr1));
		zigZagFashionArray(arr1);
		System.out.print("\n" + Arrays.toString(arr1) + "\n");

		int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		System.out.print("\n row index with the max 1 is: " + rowsWithMaximum1s(mat));

	}
}
