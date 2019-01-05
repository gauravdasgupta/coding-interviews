package Array;

import java.util.Arrays;



public class HeapSort {
	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		System.out.println(Arrays.toString(arr));

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	public static void heapify(int[] arr, int n, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;

		if (l < n && arr[l] >= arr[largest])
			largest = l;

		if (r < n && arr[r] >= arr[largest])
			largest = r;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}

	public static void sortRec(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapifyRec(arr, n, i);

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapifyRec(arr, i, 0);
		}
	}

	public static void heapifyRec(int[] arr, int n, int i) {

		while (true) {
			int l = 2 * i + 1;
			int r = 2 * i + 2;
			int largest = i;

			if (l < n && arr[l] >= arr[largest])
				largest = l;
			if (r < n && arr[r] >= arr[largest])
				largest = r;
			if (largest != i) {
				int temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;

				i = largest;
			} else if (largest == i)
				largest = n / 2 - 1;

			if (largest <= n / 2 - 1)
				break;
		}
	}

	public static void main(String[] args) {
		int[] arr //= { 12, 11, 13, 5, 546, 22, 6, 7, 9, 6233 };
		={ 3, 87, 22, 67, 77, 32, 19, -9 };
		// {12, 11, 13, 5, 6, 7};
		 sort(arr);
		//sortRec(arr);
		System.out.println(Arrays.toString(arr));
		
		 Node root = new Node(10);
	}
}
