package DP;

import java.util.Stack;

public class LongestIncreasingSubsequence {

	public static void solve(int[] arr) {
		int[] arr1 = new int[arr.length];
		int[] arr2 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			arr1[i] = 1;
			arr2[i] = -1;
		}

		int maxIndex = 0;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (arr1[i] < arr1[j] + 1) {
						arr1[i] = arr1[j] + 1;
						arr2[i] = j;
					}
				}
			}
			if (arr1[maxIndex] < arr1[i]) {
				maxIndex = i;
			}
		}

		System.out.println("Solution is:-" + arr1[maxIndex]);

		Stack<Integer> st = new Stack<>();
		int currIndex = maxIndex;
		while (currIndex != -1) {
			st.push(arr[currIndex]);
			currIndex = arr2[currIndex];
		}

		int temp;
		while (!st.isEmpty()) {
			temp=st.peek();
			st.pop();
			System.out.print(temp+",");
		}

	}

	public static void main(String[] args) {
		int[] arr = {3,4,-1,0,6,2,3};
		solve(arr);
	}

}
