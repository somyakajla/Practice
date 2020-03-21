package LinkedList;

 class RemoveDuplicates {
	 
	 static Node head; 
	  
	    static class Node { 
	  
	        int data; 
	        Node next; 
	  
	        Node(int d) { 
	            data = d; 
	            next = null; 
	        } 
	    } 
	    static void printList(Node node) { 
	        while (node != null) { 
	            System.out.print(node.data + " "); 
	            node = node.next; 
	        } 
	    } 
	    static void remove_duplicates() { 
	    	Node p1 = head;
	    	Node p2 = null;
	    	Node duplicate = null;
	    	while(p1 != null && p1.next != null) {
	    		p2 = p1;
	    		while(p2.next != null) {
	    			if(p1.data == p2.next.data) {
	    				duplicate = p2.next;
	    				p2.next = p2.next.next;
	    			}
	    			else {
	    				p2 = p2.next;
	    			}
	    		}
	    		p1 = p1.next;
	    	}
	       
	    } 
	    
	    
	
	// No buffer Allowed 
	public static void main(String args[]) {
		
		
        head = new Node(10); 
        head.next = new Node(12); 
        head.next.next = new Node(11); 
        head.next.next.next = new Node(11); 
        head.next.next.next.next = new Node(12); 
        head.next.next.next.next.next = new Node(11); 
        head.next.next.next.next.next.next = new Node(10); 
  
        System.out.println("Linked List before removing duplicates : \n "); 
        printList(head); 
  
        remove_duplicates(); 
        System.out.println(""); 
        System.out.println("Linked List after removing duplicates : \n "); 
        printList(head);
		
	}
	

}
