package ThisPractice2;

import java.util.Stack;

public class ReverseStack2 {

	private static void reverse(Stack<Integer> st) {
		int temp;
		if (st.size() > 0) {
			temp = st.peek();
			st.pop();
			reverse(st);
			insertAtLast(temp, st);
		}

	}

	private static void insertAtLast(int x, Stack<Integer> st) {

		int temp = 0;
		if (st.isEmpty()) {
			st.push(x);
			return;
		}

		if (st.size() > 0) {
			temp = st.peek();
			st.pop();
			insertAtLast(x, st);
		}
		st.push(temp);
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();

		for (int i = 2; i <= 10; i++) {
			st.push(i);
		}

		System.out.println(st);
		reverse(st);
		System.out.println(st);
	}

}
