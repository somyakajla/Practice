package LinkedList;

public class ReturnKthToList {
	static Node head = null;
	
	static class Node {
		
		int data;
		Node next;
		Node(int i){
			data = i;
			next = null;
		}
	}
	
	
	public static void main(String args[]) {
		head = new Node(9);
		head.next = new Node(6);
		head.next.next = new Node(16);
		head.next.next = new Node(61);
		head.next.next.next = new Node(36);
		head.next.next.next.next = new Node(76);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = new Node(12);
		head.next.next.next.next.next.next.next = new Node(43);
		head.next.next.next.next.next.next.next.next = new Node(33);
		//head.next.next.next.next.next.next.next.next.next = new Node(22);
		//head.next.next.next.next.next.next.next.next.next.next = new Node(54);
		//head.next.next.next.next.next.next.next.next.next.next.next = new Node(99);
		Node n = ReturnKth(head, 5);
		System.out.println(n.data);
		
		
	}


	private static Node ReturnKth(Node head2, int ith) {
		Node h1 = head2;
		Node h2 = head2;
		for(int i=0; i<ith; i++) {
			if(h2 == null)
				return null;        
			h2 = h2.next;
		}
		while(h2 != null) {
			h1 = h1.next;
			h2 = h2.next;
		}
		return h1;
		
		
	}

}
