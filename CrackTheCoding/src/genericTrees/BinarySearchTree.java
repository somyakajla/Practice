package genericTrees;

import java.util.Stack;

// Binary search properties are 
// left < root < right
// there is comparision required to compare the nodes therefore I have to use Comparable interface
// When using generics you can't use implements therefore extends
// there are interfaces to use : comparable and comparator 

public class BinarySearchTree<T extends Comparable<T>> {

	BinaryTreeNode<T> root = null;

	public enum PrintType {
		LEVELWISE, INORDER, POSTORDER, PREORDER, INORDER_ITR, POSTORDER_ITR, PREORDER_ITR;
	}

	public void addNode(T value, boolean type) {

		if (root == null)
			root = new BinaryTreeNode<T>(value);

		else {

			if (type)
				addNodeRecursively(root, value);

			else
				addNodeIteratively(root, value);

		}
	}

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

	private BinaryTreeNode<T> addNodeRecursively(BinaryTreeNode<T> rootNode, T value) {
		// base condition
		if (rootNode == null) {
			return new BinaryTreeNode<T>(value);
		}

		if (rootNode.getData().compareTo(value) < 0)
			rootNode.setRight(addNodeRecursively(rootNode.getRight(), value));

		else
			rootNode.setLeft(addNodeRecursively(rootNode.getLeft(), value));

		return rootNode;
	}

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

	public void printTree(PrintType p) {

		switch (p) {
		case LEVELWISE:
			callLevelOrder(root);
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

	// either stack
	// either update pointer to come back to the root
	// either recursive
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

	// stack
	// left right root
	private void callPostorderIterative(BinaryTreeNode<T> root) {
		Stack<BinaryTreeNode<T>> s = new Stack<>();
		s.push(root);
		BinaryTreeNode<T> pre = null;

		while (!s.isEmpty()) {

			BinaryTreeNode<T> current = s.peek();

			if (pre == null || pre.getLeft() == current || pre.getRight() == current) {
				
				if (current.getLeft() != null)
					s.push(current.getLeft());
				else if (current.getRight() != null)
					s.push(current.getRight());
				else {
					s.pop();
					System.out.println(current.getData());
				}

			} else if (current.getLeft() == pre) {
			
				if (current.getRight() != null)
					s.push(current.getRight());
				else {
					s.pop();
					System.out.println(current.getData());
				}

				/*
				 * go up the tree from right node and after coming back from right node process
				 * parent and pop stack
				 */
			} else if (current.getRight() == pre) {
				s.pop();
				System.out.println(current.getData());
			}

			pre = current;
		}

	}

	// stack
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

	// preOrder : root, left right
	private void callPreorder(BinaryTreeNode<T> root) {

		if (root == null)
			return;
		System.out.println(root.getData());
		callPreorder(root.getLeft());
		callPreorder(root.getRight());

	}

	// postOrder : left, right, root
	private void callPostorder(BinaryTreeNode<T> root) {

		if (root == null)
			return;
		callPostorder(root.getLeft());
		callPostorder(root.getRight());
		System.out.println(root.getData());

	}

	// inorder : left, root, right
	private void callInorder(BinaryTreeNode<T> root) {

		if (root == null)
			return;
		callInorder(root.getLeft());
		System.out.println(root.getData());
		callInorder(root.getRight());

	}

	private void callLevelOrder(BinaryTreeNode<T> root) {

	}

}