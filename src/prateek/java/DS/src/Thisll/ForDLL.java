package Thisll;

public class ForDLL {

	public static void main(String[] args)
	{
		DLL dlList=new DLL();
		dlList.push(12);
		dlList.push(13);
		dlList.append(99);
		dlList.push(14);
		dlList.insertAfter(dlList.head,55);
		dlList.insertBefore(dlList.head, 11);
		dlList.insertBefore(dlList.head.next, 66);
		dlList.insertAfter(dlList.head.next.prev.next.next.next.next.prev,199);
		
	dlList.deleteData(99);
	//dlList.printList();
	
	//System.out.println("Reversing");
		
	dlList.reverseList();
	
		dlList.printList();
	}        
	
}
