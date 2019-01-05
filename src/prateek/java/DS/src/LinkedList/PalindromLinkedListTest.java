package LinkedList;

public class PalindromLinkedListTest {

	private static void solve(Node head) {
		Node slowptr = head;
		Node fastptr = head;
		Node slowptrPrev = null;

		while (fastptr != null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			slowptrPrev = slowptr;
			slowptr = slowptr.next;

		}

		if (fastptr != null) {

			slowptrPrev = slowptr;
			slowptr = slowptr.next;
		}

		Node temphead2 = reverse(slowptr);

		Node st1 = head;
		Node st2 = temphead2;
		boolean res = true;

		while (st1 != null && st2 != null) {
			if (st1.data != st2.data)
				res = false;
			st1=st1.next;
			st2=st2.next;
		}
		
		Node tempHead22=reverse(temphead2);
		slowptrPrev.next=tempHead22;
		
		
		if(res)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private static Node reverse(Node n) {
		Node curr = n;
		Node prev = null;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		int str[] = { 1,5,8,5,1};

		// String string = new String(str);

		for (int i = 0; i < str.length; i++) 
			ll.push(str[i]);

		ll.printList();
		

		solve(ll.head);

		ll.printList();
		
	}
}
