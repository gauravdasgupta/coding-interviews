package ThisPractice2;

public class MatrixMultiplicationRec {

	public static int findCost(int[] arr, int start, int end) {
		if (start == end)
			return 0;

		int res = Integer.MAX_VALUE;
		int temp;
		int k = start;
		for (; k < end; k++) {
			temp = findCost(arr, start, k) + findCost(arr, k + 1, end) + arr[start - 1] * arr[k] * arr[end];
			res = Math.min(temp, res);
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 4, 5 };

		int cost = findCost(arr, 1, arr.length - 1);
		System.out.print(cost);
	}

}
