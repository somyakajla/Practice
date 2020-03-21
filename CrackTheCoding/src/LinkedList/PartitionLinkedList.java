package LinkedList;

public class PartitionLinkedList {
	
	static class Node  
	{  
	    int data;  
	    Node next;  
	} 
	static Node newNode(int data)  
	{  
	    Node new_node = new Node();  
	    new_node.data = data;  
	    new_node.next = null;  
	    return new_node;  
	}  
	
	public static void main(String[] args)  
	{  
	    /* Start with the empty list */
		 Node head = newNode(3);   
	    head.next = newNode(5);  
	    head.next.next = newNode(8);  
	    head.next.next.next = newNode(2);  
	    head.next.next.next.next = newNode(10);  
	    head.next.next.next.next.next = newNode(2);  
	    head.next.next.next.next.next.next = newNode(1);  
	  
	    int x = 5;  
	    head = partition(head, x);  
	    printList(head);  
	}

	private static void printList(Node head) {
		Node temp = head;  
		while(temp != null) {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		
	}

	private static Node partition(Node head, int x) {
		Node tail = head;
		Node current = head;
		while(current != null ) {
			Node next = current.next;
			if(current.data < x) {
				current.next = head;
				head = current;
			}else {
				tail.next = current;
				tail = current;
			}
			current = next;
			
		}
		tail.next = null;
		 return head;  
	} 

}
