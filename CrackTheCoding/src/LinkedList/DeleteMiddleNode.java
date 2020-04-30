package LinkedList;

import LinkedList.PartitionLinkedList.Node;

public class DeleteMiddleNode {
	static Node head;
	static class Node { 
		  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
	
	public static void main(String[] args) { 
		DeleteMiddleNode list = new DeleteMiddleNode(); 
        list.head = new Node(1); 
        list.head.next = new Node(12); 
        list.head.next.next = new Node(1); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(1); 
  
        System.out.println("Before Deleting "); 
        list.printList(head); 
  
        /* I m deleting the head itself. 
         You can check for more cases */
        list.deleteNode(head); 
        System.out.println(""); 
        System.out.println("After deleting "); 
        list.printList(head); 
    }

	private void deleteNode(Node head2) {
//		if(head == null )
//		Node temp = head2.next;
//		System.out.println ("this is to print "+head2.data);
//		head2.data = temp.data;
//		head2.next = temp.next;
//		System.gc(); 
		
	}

	private void printList(Node head2) {
		Node temp = head;  
		while(temp != null) {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		
	} 

}
