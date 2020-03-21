package LinkedList;

import LinkedList.RemoveDuplicates.Node;

public class Palindrom {
	
	static Node head;
	static class Node{
		
		Node next ;
		int data ;
		Node(int val){
			data = val;
			next = null;
		}
	}
	
public static void main(String args[]) {
		
		
        head = new Node(10); 
        head.next = new Node(12); 
        head.next.next = new Node(11); 
        head.next.next.next = new Node(11); 
        head.next.next.next.next = new Node(11); 
        head.next.next.next.next.next = new Node(12); 
        head.next.next.next.next.next.next = new Node(10); 
  
        System.out.println("Linked List before removing duplicates : \n "); 
        printList(head); 
        Node reverseList = reverse(head);
        System.out.println("Linked List after removing duplicates : \n "); 
        printList(reverseList);
  
        Boolean a = checkPalimdrom(head, reverseList); 
        System.out.println(a);
        //System.out.println(""); 
        //System.out.println("Linked List after removing duplicates : \n "); 
        //printList(head);
		
	}

private static Node reverse(Node head2) {
	Node Rev = null;
	while(head2 != null) {
		Node n = new Node(head2.data);
		n.next = Rev;
		Rev = n;
		head2 = head2.next;
	}
	return Rev;
}

private static Boolean checkPalimdrom(Node head2, Node reverseList) {
	while(head2 != null && reverseList != null) {
		if(head2.data == reverseList.data) {
			head2 = head2.next;
			reverseList = reverseList.next;
		}else {
			return false;
		}
		
		
	}
	
	return head2 == null && reverseList == null;
}

private static void printList(Node head2) {
	Node headnew = head2;
	while(headnew != null) {
		System.out.println(headnew.data);
		headnew = headnew.next;
	}
	
}

}
