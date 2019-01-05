package LinkedList;

public class LinkedList {

	Node head;

	public void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;

	}

	public void insertAfter(int data, Node prevNode) {
		if (prevNode == null) {
			System.out.println("cannot Insert");
			return;
		}

		Node newNode = new Node(data);
		newNode.next = prevNode.next;

		prevNode.next = newNode;
	}

	public void append(int data) {
		if (head == null) {
			push(data);
			return;
		}

		Node temp = head;
		Node newNode = new Node(data);
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;

	}

	public void deleteNode(int data) {
		if (head.data == data) {
			head = head.next;
			return;
		}

		Node temp = head;
		Node prev = head;

		while (temp != null && temp.data != data) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}

	public int size() {
		int size = 0;
		Node temp = head;

		while (temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}

	public int sizeR() {
		return sizeR1(head);

	}

	public int sizeR1(Node n) {
		if (n == null)
			return 0;
		else
			return 1 + sizeR1(n.next);

	}

	public boolean search(int data) {            
		Node temp = head;

		while (temp != null && temp.data != data) {
			temp = temp.next;
		}

		if (temp != null)
			return true;
		return false;
	}

	public boolean searchR(int data) {
		return searchR1(data, head);
	}

	public boolean searchR1(int data, Node n) {
		if (n == null)
			return false;
		if (n.data == data)
			return true;
		else
			return searchR1(data, n.next);

	}

	public int getNth(int index) {
		Node temp = head;
		int count = 0;

		while (temp != null) {
			count++;
			if (count == index)
				return temp.data;
			temp = temp.next;
		}

		System.out.println("doesnt exists");
		return 0;
	}

	public int getNthR(int index) {
		return getNthR1(head, index);

	}

	public int getNthR1(Node n, int index) {
		if (index == 1)
			return n.data;
		if (n == null) {
			System.out.println("doesnt exists");
			return 0;
		} else
			return getNthR1(n.next, index - 1);

	}

	public boolean isPalindrome() {

		return false;

	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	public boolean detectLoop() {
		Node slow_ptr = head;
		Node fast_ptr = head;

		while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;

			if (slow_ptr == fast_ptr)
				return true;
		}

		return false;
	}

	public int loopLength() {
		Node slow_ptr = head;
		Node fast_ptr = head;

		while (slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;

			if (slow_ptr == fast_ptr)
				return loopLength1(slow_ptr);
		}

		return 0;
	}

	public int loopLength1(Node n) {
		Node temp = n;
		int res = 1;
		while (temp.next != n) {
			temp = temp.next;
			res++;
		}

		return res;
	}

	public Node reverseList() {
		Node prev = null;
		Node curr = head;
		Node nex = null;
		while (curr != null) {
			nex = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nex;
		}
		head = prev;
		return head;
	}

	public Node reverseListRec() {

		return reverseListRec1(head, null);
	}

	public Node reverseListRec1(Node curr, Node prev) {
		if (curr.next == null) {
			curr.next = prev;
			head = curr;
			return head;
		}

		Node nex = curr.next;
		curr.next = prev;
		reverseListRec1(nex, curr);
		return head;
	}

	public void removeDuplicates() {
		Node temp = head;
		Node nex_next;

		while (temp.next != null) {
			if (temp.data == temp.next.data) {
				nex_next = temp.next.next;
				temp.next = nex_next;

			} else
				temp = temp.next;
		}

	}

	public Node sortLinkedList(Node left, Node right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		Node result = null;

		if (left.data < right.data) {
			result = left;
			result.next = sortLinkedList(left.next, right);
		} else {
			result = right;
			result.next = sortLinkedList(left, right.next);
		}
		return result;
	}

	public Node mergerSortOfLinkedList()
	{
		head=mergerSortLinkedList(head);
		return head;
	}
	
	public Node mergerSortLinkedList(Node root) {
		if (root == null || root.next == null)
			return root;

		Node mid = getMiddle(root);
		Node nextOfMid = mid.next;
		mid.next = null;

		Node left = mergerSortLinkedList(root);
		Node right = mergerSortLinkedList(nextOfMid);

		Node sortedList = sortLinkedList(left, right);
		return sortedList;
	}

	public Node getMiddle(Node root) {
		if(root==null)
			return root;
		Node slow_ptr = root;
		Node fast_ptr = root.next;

		while (fast_ptr != null && fast_ptr.next != null) {
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		}

		return slow_ptr;
	}

}
