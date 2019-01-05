package DP;

public class AllPermutationsofString {
	static int count = 0;

	private static String swap(String s, int i1, int i2) {
		char[] arr = s.toCharArray();
		char temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;

		return String.valueOf(arr);
	}

	private static void solve(String s, int pos, int l) {

		if (pos == l) {
			System.out.println(s);
			count++;
			return;
		}

		for (int k = pos; k < l; k++) {
			String temp = swap(s, pos, k);
			solve(temp, pos + 1, l);

		}

	}

	public static void main(String[] args) {
		String s = "abcd";
		s.length();
		solve(s, 0, s.length());
		System.out.println(count);

	}
}
