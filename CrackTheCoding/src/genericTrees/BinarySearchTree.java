package genericTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/* Binary search properties are 
 * left < root < right
 * there is comparison required to compare the nodes therefore I have to use Comparable interface
 * When using generic you can't use implements therefore extends
 * there are interfaces to use : comparable and comparator  
 */

public class BinarySearchTree<T extends Comparable<T>> {
	
	BinaryTreeNode<T> root = null;  //root pointer

	/*
	 * Emum: defines operation can operate on tree
	 */
	public enum PrintType {
		LEVELWISE, INORDER, VERTICALORDER, POSTORDER, PREORDER, INORDER_ITR, POSTORDER_ITR, PREORDER_ITR;
	}

	/*
	 * Add Node 
	 * value: value we want to add 
	 * type: recursive / iterative
	 */
	public void addNode(T value, boolean type) {
		
		if (root == null) 
			root = new BinaryTreeNode<T>(value); //calls constructor of BinarayTreeNode class where setting data value.

		else { //else tree is already there add new node into tree			
			if (type)
				addNodeRecursively(root, value); //add node by recursive method
			else
				addNodeIteratively(root, value); //add node iteratively
		}
	}
	/*
	 * Add node recursively 
	 */
	private BinaryTreeNode<T> addNodeRecursively(BinaryTreeNode<T> rootNode, T value) {
		if (rootNode == null)  //base condition
			return new BinaryTreeNode<T>(value);
		
		if (rootNode.getData().compareTo(value) < 0) // (left < root < right)
			rootNode.setRight(addNodeRecursively(rootNode.getRight(), value));
		else
			rootNode.setLeft(addNodeRecursively(rootNode.getLeft(), value));

	return rootNode;
	}
	
	/*
	 * Add node iteratively 
	 */
	private void addNodeIteratively(BinaryTreeNode<T> rootNode, T value) {
		BinaryTreeNode<T> current = rootNode;
		BinaryTreeNode<T> node = new BinaryTreeNode<T>(value);
		BinaryTreeNode<T> parent = null;

		while (current != null) {
			parent = current;
			if (current.getData().compareTo(value) < 0)
				current = current.getRight();
			else
				current = current.getLeft();
		}

		if (parent.getData().compareTo(value) < 0)
			parent.setRight(node);
		else
			parent.setLeft(node);

	}
	/*
	 * Find Element: value
	 */
	public boolean FindElement(T value) {
		BinaryTreeNode<T> current = root;
		
		while (current.getLeft() != null && current.getRight() != null) {
			if (current.getData().compareTo(value) == 0)
				return true;
			else if (current.getData().compareTo(value) < 0)
				current = current.getRight();
			else
				current = current.getLeft();
		}
	 return false;
	}
	/*
	 * print elements of tree
	 */
	public void printTree(PrintType p) {
		
		switch (p) {
		case LEVELWISE:
			callLevelOrder(root);
			break;
		case VERTICALORDER:
			callVertical(root);
			break;
		case INORDER:
			callInorder(root);
			break;
		case POSTORDER:
			callPostorder(root);
			break;
		case PREORDER:
			callPreorder(root);
			break;
		case PREORDER_ITR:
			callPreorderIterative(root);
			break;
		case POSTORDER_ITR:
			callPostorderIterative(root);
			break;
		case INORDER_ITR:
			callInorderIterative(root);
			break;
		}
	}
	/*
	 * implement vertical level traversal of tree
	 */
	private void callVertical(BinaryTreeNode<T> root2) {
		TreeMap<Integer, ArrayList<T>> map = new TreeMap<>();
		int hd = 0; // horizontal distance , root has 0,
		verticalOrderImpl(root2, map, hd);
		for (ArrayList<T> list : map.values()) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

	/* vertical order
	 * important tree map so that it can sort the keys from left to right
	 * reverse the order of element if elements has to print from right to left
	 */
	private void verticalOrderImpl(BinaryTreeNode<T> root2, TreeMap<Integer, ArrayList<T>> map, int hd) {
		if (root == null)
			return;
		
		ArrayList<T> list = map.get(hd);
		
		if (list == null) {
			list = new ArrayList<T>();
			list.add(root2.getData());
		} else {
			list.add(root2.getData());
		}
		map.put(hd, list);
		verticalOrderImpl(root2.getLeft(), map, hd - 1);
		verticalOrderImpl(root2.getRight(), map, hd + 1);
	}

	/*
	 * In order: iterative, without any external storage
	 * tricky: avoid using it
	 */

	private void callInorderIterative(BinaryTreeNode<T> root) {
		BinaryTreeNode<T> pre, current;
		current = root;
		
		while (current != null) {
			if (current.getLeft() == null) {
				System.out.println(current.getData());
				current = current.getRight();
			}
			else {
				// find predecessor
				pre = current.getLeft();
				while (pre.getRight() != null && pre.getRight() != current) {
					pre = pre.getRight();
				}

				if (pre.getRight() == null) {
					pre.setRight(current);
					current = current.getLeft();
				} else {
					pre.setRight(null);
					System.out.println(current.getData());
					current = current.getRight();
				}
			}
		}
	}
	/*
	 * In order: using stack and hashMap
	 */
	private void callInorderHashMap(BinaryTreeNode<T> root) {
		HashSet<BinaryTreeNode<T>> set = new HashSet<>();
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		stack.push(root);
		
		while(! stack.isEmpty()) {
			BinaryTreeNode<T> n = stack.pop();
			if(set.contains(n)) {
				System.out.println(n.getData());
			} else {
				set.add(n);
				if(n.getRight() != null)
					stack.add(n.getRight());
				stack.add(n);
				if(n.getLeft() != null)
					stack.add(n.getLeft());			
			}
		}			
	}
	

	/*
	 * stack
	 */
	private void callPreorderIterative(BinaryTreeNode<T> root) {
		Stack<BinaryTreeNode<T>> s = new Stack<>();
		s.push(root);

		while (!s.isEmpty()) {
			BinaryTreeNode<T> node = s.pop();
			System.out.println(node.getData());

			if (node.getRight() != null)
				s.push(node.getRight());
			if (node.getLeft() != null)
				s.push(node.getLeft());
		}
	}
	/*
	 * PostOrder: using stack and hashMap
	 */
	private void callPostorderIterative(BinaryTreeNode<T> root) {
		HashSet<BinaryTreeNode<T>> set = new HashSet<>();
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		stack.push(root);
		
		while(! stack.isEmpty()) {
			BinaryTreeNode<T> n = stack.pop();
			if(set.contains(n)) {
				System.out.println(n.getData());
			} else {
				set.add(n);
				stack.add(n);
				if(n.getRight() != null)
					stack.add(n.getRight());
				if(n.getLeft() != null)
					stack.add(n.getLeft());			
			}
		}			
	}

	/*
	 * preOrder : root, left right
	 */
	private void callPreorder(BinaryTreeNode<T> root) {
		if (root == null)
			return;
		
		System.out.println(root.getData());
		callPreorder(root.getLeft());
		callPreorder(root.getRight());
	}

	/*
	 * postOrder : left, right, root
	 * recursive
	 */
	private void callPostorder(BinaryTreeNode<T> root) {
		if (root == null)
			return;
		
		callPostorder(root.getLeft());
		callPostorder(root.getRight());
		System.out.println(root.getData());
	}

	/* In order : left, root, right
	 * recursive way
	 */
	private void callInorder(BinaryTreeNode<T> root) {
		if (root == null)
			return;
		
		callInorder(root.getLeft());
		System.out.println(root.getData());
		callInorder(root.getRight());
	}

	/*
	 * calls level order traversal
	 */
	private void callLevelOrder(BinaryTreeNode<T> root) {
		ArrayList<ArrayList<T>> result = new ArrayList<>();
		levelOrderImpl(root, result);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
		}
	}
	
	/*
	 * root: pointer
	 * result: arraylist of level order traversal
	 * return: void
	 */
	private void levelOrderImpl(BinaryTreeNode<T> root2, ArrayList<ArrayList<T>> result) {
		Queue<BinaryTreeNode<T>> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			ArrayList<T> l = new ArrayList<>();
			int count = q.size();
			for (int i = 0; i < count; i++) {
				BinaryTreeNode<T> n = q.poll();
				l.add(n.getData());
				if (n.getLeft() != null) {
					q.offer(n.getLeft());
				}
				if (n.getRight() != null) {
					q.offer(n.getRight());
				}
			}
			result.add(l);
		}
	}
}