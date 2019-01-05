package LRU;

import java.util.HashMap;

class NodeforDLL {
	int data;
	NodeforDLL next, prev;

	public NodeforDLL(int data) {
		this.data = data;
		next = null;
		prev = null;
	}

}

public class LruCache {

	NodeforDLL head = null, end = null;
	int capacity;
	HashMap<Integer, NodeforDLL> map = new HashMap<>();

	public LruCache(int capacity) {
		this.capacity = capacity;
	}

	public void setAtHead(NodeforDLL n) {

		if (head == null) {
			head = n;
		} else {
			n.next = head;
			head.prev = n;
			head = n;
			n.prev = null;
		}

		if (end == null)
			end = head;

	}

	public void remove(NodeforDLL node) {
		if (node.prev != null)
			node.prev.next = node.next;
		else
			head = node.next;

		if (node.next != null)
			node.next.prev = node.prev;
		else {
			end = node.prev;
		}
	}

	public int get(int value) {
		if (!map.containsKey(value))
			return -1;

		NodeforDLL node = map.get(value);
		remove(node);
		setAtHead(node);

		return value;
	}

	public void set(int value) {
		if (map.containsKey(value)) {
			return;
		}

		NodeforDLL newn = new NodeforDLL(value);
		if (map.size() < capacity) {
			map.put(value, newn);
			setAtHead(newn);
		} else {
			map.remove(end.data);
			remove(end);
			map.put(value, newn);
			setAtHead(newn);
		}

	}

	public static void main(String[] args) {
		LruCache lru = new LruCache(5);
		for (int i = 1; i <= 6; i++)
			lru.set(i);

		lru.get(3);
		lru.get(1);

		System.out.print("yo beyotch");
	}

}
