package ThisPractice;

public class AllPermutationsOfString {

	static int count = 0;

	public static String swap(String str, int x, int y) {
		char[] arr = str.toCharArray();
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return String.valueOf(arr);
	}

	public static void solveAllPermutationsOfString(String str, int pos, int length) {
		if (pos == length) {
			System.out.println(str);
			count++;
			return;
		}

		for (int i = pos; i < length; i++) {
			String temp = swap(str, pos, i);
			solveAllPermutationsOfString(temp, pos + 1, length);
		}
	}

	public static void main(String[] args) {
		String str = "1234";
		char[] arr = str.toCharArray();
		int length = arr.length;
		solveAllPermutationsOfString(str, 0, length);
		System.out.println("total permutations is:-" + count);
	}
}
