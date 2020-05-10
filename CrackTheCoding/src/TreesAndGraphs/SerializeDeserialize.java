package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	char data;
	Node left;
	Node right;
	
	public Node(char c) {
		this.data = c;
		this.left = null;
		this.right = null;
	}
}

public class SerializeDeserialize {
	
	private static String serialize_1(Node root) {
		StringBuilder sb = new StringBuilder();
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		System.out.println(root.data);
		while(!q.isEmpty()) {
			Node n = q.poll();
			sb.append(n.data);
			if(n.data == '+')
				continue;
			if(n.left != null) 
				q.offer(n.left);
			else
				q.offer(new Node('+'));
			
			if(n.right != null)
				q.offer(n.right);
			else
				q.offer(new Node('+'));
		}
		return sb.toString();
	}
	

	
	private static Node deserialize(String s, int i) {
		//base
		
		if(i >= s.length())
			return null;
		
		if(s.charAt(i) == '+')
			return null;
		
		Node root = new Node(s.charAt(i));
		System.out.println(root.data);
		
		root.left = deserialize(s, 2*i + 1);
		root.right = deserialize(s, 2*i + 2);
		
		return root;
	}

	
	public static void main(String args[]) {
		Node n = new Node('A');
		n.left = new Node('B');
		n.left.right = new Node('D');
		n.right = new Node('C');
		n.right.left = new Node('E');
		
		//StringBuilder sb = new StringBuilder();
		String s = serialize_1(n);
		System.out.println(s);
		
		deserialize(s, 0);
	}

}
