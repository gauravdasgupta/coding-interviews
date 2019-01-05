package ThisPractice2;

public class AllPermutationsOfString2 {

	private static int count = 0;

	public static String swap(String s, int pos1, int pos2) {
		char[] arr = s.toCharArray();
		char x = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = x;
		return String.valueOf(arr);
	}

	public static void solve(String s1, int pos, int length) {
		if (pos == length) {
			System.out.println(s1);
			count++;
			return;
		}

		for (int i = pos; i < length; i++) {
			String temp = swap(s1,pos,i);
			solve(temp, pos+1,length);

		}

	}

	public static void main(String[] args) {
		String s1 = "abcd";
		System.out.println(s1.length());
		solve(s1, 0, s1.length());
		System.out.println("count is"+count);

	}
}
