package LinkedList;

public class Test {

	
	
	public static void main(String[] args)
	{
		LinkedList llist=new LinkedList();
		/*l.push(54);
		//l.push(55);
		//l.push(59);
		//l.append(50);
		//l.push(62);
		//l.insertAfter(52, l.head.next.next.next);
		//l.printList();
		
		int size=l.sizeR();
		System.out.println("\n lenght of linked list is: "+size);
		
		System.out.println(l.searchR(62));
		
		int ele=l.getNthR(0);
		System.out.println("\n nth element is: "+ele);
		
		
		l.deleteNode(62);
		
		l.printList();
		size=l.sizeR();
		System.out.println("\n lenght of linked list is: "+size);
		
		System.out.println(l.searchR(62));*/
		
		
		//int[] arr= {1,2,3,4,5,4,3,2,1};
		
		//for(int i=0;i<arr.length;i++)
			//l.push(arr[i]);
		
		
		llist.push(20);
		llist.push(20);
		llist.push(20);
		  llist.push(22);
	        llist.push(22);
	        llist.push(22);
		llist.push(21);

         
        /*Create loop for testing */
        //llist.head.next.next.next.next = llist.head;
		
        //System.out.println(llist.detectLoop());
        
		//llist.printList();
		//llist.reverseListRec();
		//System.out.println();
		
		llist.push(44);
		llist.push(44);
		llist.push(44);
		llist.push(44);
		llist.push(44);      
        llist.push(33);

		
		
		llist.printList();	
		llist.removeDuplicates();
		System.out.println();
		llist.printList();			
		//l.head.next.next.next
		llist.mergerSortOfLinkedList();
		System.out.println();
		llist.printList();	
	}
	
	
	
}
