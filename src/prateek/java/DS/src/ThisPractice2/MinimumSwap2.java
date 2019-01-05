package ThisPractice2;

public class MinimumSwap2 {

	private static void solve(int[] arr, int k) {

		int count = 0;
		for (int x : arr)
			if (x <= k)
				count++;

		int ans = 0;

		for (int i = 0; i < count; i++)
			if (arr[i] > k)
				ans++;

		int tempans = ans;
		int start=0;

		for (int i = 0, j = count; j < arr.length; j++, i++) {
			if (arr[i] > k)
				tempans--;
			if (arr[j] > k)
				tempans++;

			if (tempans < ans) {
				ans = tempans;
				start=i+1;
				
			}
		}

		System.out.println("Answer is:" + ans+"  starting element is "+arr[start]);

	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 9,  5,1, 7, 4 };
		int k = 5;
		solve(arr, k);
	}
}
