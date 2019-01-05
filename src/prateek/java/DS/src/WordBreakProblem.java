import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	public static void solveWordBreakProblem(StringTest str, Set<StringTest> dictionary) {
		int[][] res = new int[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++)
			for (int j = 0; j < str.length(); j++)
				res[i][j] = -1;

		for (int l = 1; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;
				StringTest sub = str.substring(i, j + 1);

				if (dictionary.contains(sub)) {
					res[i][j] = i;
					continue;
				}

				for (int k = i + 1; k <= j; k++) {
					if (res[i][k - 1] != -1 && res[k][j] != -1) {
						res[i][j] = k;
						break;
					}
				}
			}
		}

		StringBuilder strBuil = new StringBuilder();
		int i = 0, j = str.length() - 1;

		while (i < j) {
			int k = res[i][j];
			if (k == i) {
				strBuil.append(str.substring(i, j + 1) + " ");
				break;
			}

			strBuil.append(str.substring(i, k) + " ");
			i = k;

		}

		System.out.println("hi--" + strBuil);

	}

	public static void main(StringTest[] args) {
		Set<StringTest> dictionary = new HashSet<StringTest>();
		dictionary.add("I");
		dictionary.add("like");
		dictionary.add("had");
		dictionary.add("play");
		dictionary.add("to");
		StringTest str = "Ihadliketoplay";

		solveWordBreakProblem(str, dictionary);
	}

}
