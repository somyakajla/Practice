package LinkedList;

import LinkedList.RemoveDuplicates.Node;

public class DetectLoop {
	
	static Node head;
	
	static class Node{
		
		Node next;
		int data;
		Node(int val){
			next = null;
			data = val;
		}
	}
	static void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
	
	public static void main(String[] args) {
		
		//head = null;
			head = new Node(10); 
	        head.next = new Node(12); 
	        head.next.next = new Node(11); 
	        head.next.next.next = new Node(21); 
	        head.next.next.next.next = new Node(16); 
	       
	        head.next.next.next.next.next= head.next; 
	        //printList(head); 
	        Node dataval = detectCycle(head);
	        System.out.println(dataval.data);
	        
	}

	private static Node detectCycle(Node head2) {
		Node fastPtr = head2;
		Node slowPtr = head2;
		boolean loopExists=false;
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			if (slowPtr == fastPtr)
			{
				loopExists=true;
				break;
			}
	 
		}
		if(loopExists)
		{
			slowPtr=head2;
	 
			while(slowPtr!=fastPtr)
			{
				slowPtr=slowPtr.next;
				fastPtr=fastPtr.next;
			}
	 
	 
		}
		else
		{
			System.out.println("Loop does not exists");
			slowPtr=null;
		}
		return slowPtr;
	}

}
