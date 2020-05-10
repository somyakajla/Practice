package genericTrees;

public class BinaryTreeNode <T> {
	
	// implemention example of encapsulation property of oops
	// binding behaviour and data together so that other programs could not access it by making data private ß
	
	private T data;
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	
	// constructor of class
	public BinaryTreeNode(T value) {
		setData(value);
	}
	
	// setter and getter to access private attributes of class
	public void setData(T value) {
		this.data = value;
		this.left = null;
		this.right = null;
	}
	
	public T getData() {
		return data;
	}
	
	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}
	
	public BinaryTreeNode<T> getLeft() {
		return left;
	} 
	
	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	public BinaryTreeNode<T> getRight() {
		return right;
	}
	
	
	
	

	
	

}
