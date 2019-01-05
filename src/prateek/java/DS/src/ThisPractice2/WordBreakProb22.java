package ThisPractice2;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProb22 {

	public static void solve(String str, Set<String> dict) {
		int[][] temp = new int[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++)
				temp[i][j] = -1;
		}

		for (int l = 1; l <= str.length(); l++) {
			for (int i = 0; i < str.length() - l + 1; i++) {
				int j = i + l - 1;

				if (dict.contains(str.substring(i, j + 1))) {
					temp[i][j] = i;
					continue;
				}

				for (int k = i + 1; k <= j; k++) {
					if (temp[i][k - 1] != -1 && temp[k][j] != -1) {
						temp[i][j] = k;
						break;
					}

				}

			}
		}

		if (temp[0][str.length() - 1] != -1) {
			StringBuilder stb = new StringBuilder();
			int i = 0;
			int j = str.length() - 1;

			while (i < j) {
				int k=temp[i][j];
				if (k == i) {
					stb.append(str.substring(i, j + 1));
					break;
				}
				
				stb.append(str.substring(i,k)+" ");
				i=k;

			}

			System.out.println(stb);
			
		} else
			System.out.println("Not possible");

	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("I");
		dictionary.add("like");
		dictionary.add("had");
		dictionary.add("play");
		dictionary.add("to");
		//dictionary.add("t");
		//dictionary.add("oplay");
		//dictionary.add("a");
		String str = "Ihadliketoplay";

		solve(str, dictionary);
	}

}
