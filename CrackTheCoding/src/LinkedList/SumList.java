package LinkedList;

public class SumList{
	static Node root1 = null;
	static Node root2 = null;
	
	// class is static because constructor of this class is called from main static method
	static class Node{
		
		Node next;
		int data;
		
		Node( int val){
			this.data = val;
			this.next = null;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	public static void main(String args[]) {
		// linked list 1
		root1 = new Node(7);
		root1.next = new Node(1);
		root1.next.next = new Node(6);
		System.out.print("First Linked List Elements  :  ");
		printNode(root1);
		
		// linkedList2 
		root2 = new Node(5);
		root2.next = new Node(9);
		
		System.out.print("Second Linked List Elements  :  ");
		printNode(root2);
		
		// Sum Of 2 Linked List
		Node n = AddList(root1, root2, 0);
		printNode(n);
			
		
	}
	private static Node AddList(Node root12, Node root22, int i) {
		// base condition
		/*if(root12 == null && root22 == null && i == 0)
			return null;*/
		Node newRoot1 = root12;
		Node newRoot2 = root22;
		Node newResult = new Node();
		int sum = 0;
		if(newRoot1 != null) {
			sum += newRoot1.data;
			newRoot1 = newRoot1.next;
		}
		if(newRoot2 != null) {
			sum += newRoot2.data;
			newRoot2 = newRoot2.next;
		}
		newResult.data = i + sum % 10;
		if(newRoot1 != null || newRoot2 != null) {
			Node n = AddList(newRoot1, newRoot2, sum >= 10 ? 1 :0);
			newResult.next = n;
			
		}
		return newResult;
			
	}
	private static void printNode(Node root12) {
		Node newRoot = root12;
		while(newRoot != null) {
			System.out.print(newRoot.data +" ");
			newRoot = newRoot.next;
		}
		System.out.println(" ");	
	}
	
	
}







/*
public class SumList {
	static Node head;

	static class Node {

		Node next;
		int data;

		Node(int val) {
			data = val;
			next = null;
		}
	}
	public void addToTheLast(Node node) {
		 
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
 
			temp.next = node;
		}
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		SumList list = new SumList();
		Node head1 = new Node(5);
		list.addToTheLast(head1);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		System.out.print("Number 1:  ");
		list.printList(head1);
		head=null;
		Node head2=new Node(6);
		list.addToTheLast(head2);
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(5));
		list.addToTheLast(new Node(9));
 
		System.out.print("Number 2:  ");
		list.printList(head2);
		// Reversing first linkedList
		head1=reverseLinkedList(head1);
 
		//Reversing second linkedList
		head2=reverseLinkedList(head2);
 
		// function to find sum of two linkedlist represent by number
		Node result= list.findSumOfNumbers(head1,head2);
		// Reverse the above linkedlist to get actual sum
		result=reverseLinkedList(result);
		System.out.print("Sum:  ");
		list.printList(result);

	}

	private Node findSumOfNumbers(Node l1, Node l2) {
		int carry =0;
		 
		Node newHead = null;
		Node tempNodeForIteration=null;
		int sum=0;
 
		int firstIter=0;
		while(l1!=null || l2!=null)
		{
			firstIter++;
			sum=carry;
			if(l1!=null)
			{
				sum=sum+l1.data;
				l1=l1.next;
			}
 
			if(l2!=null)
			{
				sum=sum+l2.data;
				l2=l2.next;
			}
 
 
			carry=sum/10;
			sum=sum%10;
			// Check if it first node for the result
			if(firstIter==1)
			{ 
				tempNodeForIteration = new Node(sum);
				newHead=tempNodeForIteration;
			}
			else
			{
				Node tempSumNode=new Node(sum);
				tempNodeForIteration.next=tempSumNode;
				tempNodeForIteration=tempNodeForIteration.next;
			}
 
		}
		if(carry!=0)
		{
			Node tempNode=new Node(carry);
			tempNodeForIteration.next=tempNode;
		}
		return newHead;
	}

	private static Node reverseLinkedList(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
 
		Node remaining = reverseLinkedList(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}

}*/
