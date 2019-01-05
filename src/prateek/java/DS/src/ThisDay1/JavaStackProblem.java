package ThisDay1;

import java.util.*;

public class JavaStackProblem {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String input = sc.next();

			System.out.println(checkIt(input));

		}
	}

	public static boolean checkIt(String x) {
		String input = x;
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '[') {
				s.push(input.charAt(i));
			} else if (input.charAt(i) == '}') // || input.charAt(i)==')' || input.charAt(i)==']' )
			{
				if (s.isEmpty() || s.pop() != '{') {
					// System.out.println("false");
					return false;
				}

			}

			else if (input.charAt(i) == ')') // || input.charAt(i)==')' || input.charAt(i)==']' )
			{
				if (s.isEmpty() || s.pop() != '(') {
					// System.out.println("false");
					return false;
				}

			}

			else if (input.charAt(i) == ']') // || input.charAt(i)==')' || input.charAt(i)==']' )
			{
				if (s.isEmpty() || s.pop() != '[') {
					// System.out.println("false");
					return false;
				}

			}

		}

		if (s.isEmpty())
			return true;
		else
			return false;

	}

}
