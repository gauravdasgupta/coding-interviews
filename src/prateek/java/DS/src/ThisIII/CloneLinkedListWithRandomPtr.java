package ThisIII;


class LLNode{
	int data;
	LLNode next;
	LLNode rand;
	
	public LLNode(int data) {
	   this.data = data;
	   next = null;
	   rand = null;
	}
}

class LinkedList{
	
	private LLNode head;
	
	public LLNode getHead() {
		return head;
	}
	
	public LLNode insertAtBegin(int data) {
		LLNode node =  new LLNode(data);;
			node.next = head;
			head = node;	
		    return head;
	}
	
	public LLNode insertAtEnd(int data) {
		LLNode node =  new LLNode(data);
		LLNode tmp = head;
		
		if(tmp!=null) {
			while(tmp!=null && tmp.next!=null) {
				tmp = tmp.next;
			}			
			tmp.next = node;
		}else {
			head = node;
		}
		return head;
	}
	
	public void printLinkedList() {
		LLNode tmp = head;
		
		while(tmp!=null) {
			System.out.println(tmp.data + "-->" + + tmp.rand.data );
			tmp = tmp.next;
		}
	}
}

public class CloneLinkedListWithRandomPtr {

	public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		obj.insertAtBegin(5);
		obj.insertAtBegin(4);
		obj.insertAtBegin(3);
		obj.insertAtBegin(2);
		obj.insertAtBegin(1);
	
		
//		set rand ptr
		obj.getHead().rand = obj.getHead().next.next;
		obj.getHead().next.rand = obj.getHead();
		obj.getHead().next.next.rand = obj.getHead().next.next.next.next;
		obj.getHead().next.next.next.rand = obj.getHead().next.next;
		obj.getHead().next.next.next.next.rand = obj.getHead().next;
		
		
		obj.printLinkedList();
		System.out.println("New clone: ");
		
		CloneLinkedListWithRandomPtr obj2 = new CloneLinkedListWithRandomPtr();
		LinkedList cloneOBJ =  obj2.cloneALinkedList(obj);
		cloneOBJ.printLinkedList();
		
		

	}
	
	private LinkedList cloneALinkedList(LinkedList obj) {
		LLNode tmp = obj.getHead();
		LinkedList cloneLinked = new LinkedList();
					
			while(tmp!=null) {
			cloneLinked.insertAtEnd(tmp.data);
				tmp = tmp.next;
			}
			
			cloneLinked = copyRandPTR(cloneLinked, obj);
		return cloneLinked;
	}
	
	private LinkedList copyRandPTR(LinkedList clone, LinkedList orig) {
		LLNode tmpO = orig.getHead();
		LLNode tmpC = clone.getHead();
		
		while(tmpO!=null) {
			tmpC.rand = tmpO.rand;
			tmpO = tmpO.next;
			tmpC = tmpC.next;
		}
		
		return clone;
	}

}
