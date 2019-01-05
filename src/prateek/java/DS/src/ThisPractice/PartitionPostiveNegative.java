package ThisPractice;

import java.util.Arrays;

public class PartitionPostiveNegative {
	static private void seperate(int[] arr, int pivot) {
		int i = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] < pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("This is to partition postive and negative numbers: ");
		int[] arr = { 1, 2, -11, 3, -99, -23, 89, 92, -100 };
		System.out.println(Arrays.toString(arr));
		seperate(arr, 0);
		System.out.println(Arrays.toString(arr));
	}
}