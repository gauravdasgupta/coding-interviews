package ThisPractice;

public class MatrixMultiplicationRec {

	public static int findCost(int[] arr, int startMatrix, int endMatrix) {

		if (startMatrix == endMatrix)
			return 0;

		int k = startMatrix;
		int res = Integer.MAX_VALUE;
		int temp;

		for (; k < endMatrix; k++) {
			temp = findCost(arr, startMatrix, k) + findCost(arr, k + 1, endMatrix)
					+ arr[startMatrix - 1] * arr[k] * arr[endMatrix];
			res = Math.min(res, temp);
		}
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 6, 4, 5 };

		int cost = findCost(arr, 1, arr.length - 1);
		System.out.print(cost);
	}

}
