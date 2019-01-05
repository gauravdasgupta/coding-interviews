package Array;

//https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
public class minimumSwaps {

	public static int minSwaps(int[] arr, int k) {
		int cnt = 0;
		for (int x : arr)
			if (x <= k)
				cnt++;

		int ans = 0, tempans = 0;
		for (int i = 0; i < cnt; i++)
			if (arr[i] > k)
				ans++;

		tempans = ans;
		for (int i = 0, j = cnt; j < arr.length; i++, j++) {
			if (arr[i] > k)
				tempans--;
			if (arr[j] > k)
				tempans++;

			ans = Math.min(ans, tempans);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 7, 9,1, 5, 8, 7, 4 };
		int k = 5;
		System.out.println("Minimum swaps required is : " + minSwaps(arr, k));

	}
}
