package Thisll;

//import ThisIII.LinkedList;

public class First {

	public static void main(String[] args) {
		
		LinkedList list=new LinkedList();
		
		System.out.println("List length is " +list.getCount());
		
		list.push(23);

		list.push(29);
		list.append(99);
		list.push(25);

		list.append(93);
		

		
		list.printList();
		
		list.insertAfter(list.head,26);
		
		list.printList();
		
		list.insertAfter(list.head.next.next,155);
		list.printMiddle();
		list.printList();
		
		list.deleteNoid(29);
		
		list.printList();
		
		list.deleteNoidAtPos(8);
		
		
		System.out.println("test");
		list.printList();
		
		System.out.println("List length is "+list.getCount());
		
		System.out.println("List length is "+list.getCountAfterNode(list.head.next.next.next.next));
		
		list.printList();
		
		System.out.println(list.search(77));
		
		System.out.println(list.searchAfterNode(list.head.next,25));
		
		
		list.swapNodes(25, 93);
		list.printList();
		
		//System.out.println(list.getNth(5));
		
		//list.printMiddle();
		
		list.printNthlast(1);
		
		list.printList();
		//System.out.println("deleting");
		//list.deleteList();
		list.append(99);
		list.printList();
		
		
		System.out.println("Count of a number is "+list.countOfKey(231));
		
		list.reverseList();
		list.printList();
		
		
	}
	
	
}
