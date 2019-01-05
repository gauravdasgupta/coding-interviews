package ThisPractice;

import java.util.Arrays;

public class MergeSort {

	public static void merge(int[] arr, int start, int mid, int end) {
		int llength = mid - start + 1;
		int rlength = end - mid;

		int[] larr = new int[llength];
		int[] rarr = new int[rlength];

		for (int i = 0; i < llength; i++)
			larr[i] = arr[start + i];
		
		for (int i = 0; i < rlength; i++)
			rarr[i] = arr[mid + 1 + i];
 
		int k = start;
		int ll, rr;
		ll = rr = 0;


		
		while (ll<llength && rr<rlength ) {
			if (larr[ll] < rarr[rr]) {
				arr[k] = larr[ll++];
			}

			else
				arr[k] = rarr[rr++];
			k++;
		}
		
		while(ll<llength)
			arr[k++]=larr[ll++];
		
		while(rr<rlength)
			arr[k++]=rarr[rr++];
	}

	public static void mergeSort(int[] arr, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);

			merge(arr, start, mid, end);
		}

	}

	public static void main(String args[]) {

		int[] arr = { 12, 11, 13, 5, 6, 7,9 ,1020};

		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
