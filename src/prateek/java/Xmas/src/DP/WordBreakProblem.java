package DP;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	public static void solve(char[] st, Set<String> set) {
		int[][] arr = new int[st.length][st.length];
		String s = String.valueOf(st);

		for (int i = 0; i < st.length; i++) {
			for (int j = 0; j < st.length; j++)
				arr[i][j] = -1;
		}

		for (int l = 1; l <= st.length; l++) {
			for (int i = 0; i < st.length - l + 1; i++) {
				int j = i + l - 1;

				if (set.contains(s.substring(i, j + 1))) {
					arr[i][j] = i;
				} else {
					int k = i + 1;
					for (; k <= j; k++) {
						if (arr[i][k - 1] != -1 && arr[k][j] != -1) {
							arr[i][j] = k;
							break;
						}
					}
				}

			}
		}

		int i = 0;
		int j = st.length - 1;
		StringBuilder sb = new StringBuilder();
		if (arr[i][j] != -1) {
			while (true) {
				if (arr[i][j] == i) {
					sb.append(s.substring(i, j + 1));
					break;
				} else {
					int k = arr[i][j];
					sb.append(s.substring(i,k)+",");
					i=k;
				}

			}
			
			System.out.print("True>>> "+sb);

		} else
			System.out.print("False");

	}

	public static void main(String[] args) {
		String s = "PARTEEPASSIKIAMACEAMAAMAAMAAMAA";
		Set<String> set = new HashSet<>();
		set.add("I");
		set.add("AM");
		set.add("A");
		set.add("ACE");
		set.add("PARTEEK");
		set.add("Passi");
		solve(s.toCharArray(), set);

	}

}
