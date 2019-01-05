package ThisPractice2;

public class MaximumHamming2 {
	private static void solve(int[] arr) {

		int n = arr.length;
		int maxCount = 0;
		for (int k = 1; k < n; k++) {
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] != arr[(i + k) % n]) {
					count++;
				}
			}
			maxCount = Math.max(maxCount, count);
		}

		System.out.println(maxCount);
		
	}

	public static void main(String[] args) {
		int[] arr =
				{2, 4, 6, 8,1,3,5,0};
				//{ 1, 2, 3, 4, 7, 7, 7, 8, 9, 88, 99 };
			//{4,8,0,2};
		solve(arr);
	}
}
