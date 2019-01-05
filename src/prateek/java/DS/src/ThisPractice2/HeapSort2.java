package ThisPractice2;

import java.util.Arrays;

public class HeapSort2 {

	public static void heapify(int[] arr, int pos, int length) {

		if (pos >= length)
			return;

		int l = 2 * pos + 1;
		int r = 2 * pos + 2;
		int tempMaxPos = pos;
		int tempValue;
		if (l < length && arr[l] > arr[tempMaxPos]) {
			tempMaxPos = l;
		}

		if (r < length && arr[r] > arr[tempMaxPos]) {
			tempMaxPos = r;
		}

		if (tempMaxPos != pos) {
			tempValue = arr[pos];
			arr[pos] = arr[tempMaxPos];
			arr[tempMaxPos] = tempValue;
			heapify(arr, tempMaxPos, length);
		}

	}

	public static void solve(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, i, n);
		}
		
		int temp;
		for(int i=n-1;i>=0;i--)
		{
			temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,0,i);	
		}
		

	}

	public static void main(String[] args) {
		int[] arr = { 123,4, 5, 2, 1, 3, 6 };
		solve(arr);
		System.out.println(Arrays.toString(arr));
	}
}
