package ThisPractice;

import java.util.Arrays;

public class HeapSortPractice {

	static void sort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
		int temp;
		for (int i = n - 1; i >= 0; i--) {
			temp = arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,i,0);
		}
	}

	static void heapify(int[] arr, int n, int i) {
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

	public static void main(String[] args) {
		System.out.println("Heap Sort :");
		int[] arr = { 3, 87, 22, 67, 77, 32, 19, -9 };
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}
}
