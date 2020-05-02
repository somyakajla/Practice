package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PriorityHeap <T extends Comparable<T>>{
	
	/*
	 * data structure to make heap 
	 */
	ArrayList<T> list = new ArrayList<>();
	boolean isMinHeap = true;
	int size = 0;
	
	/*
	 * Build Heap from whole array
	 */
	public void buildHeap(T[] arr, boolean s) {
		// add elements into list
		for(T i: arr) list.add(i);
		
		this.isMinHeap = s;
		this.size = list.size();
		for(int j = size /2; j >=0; j--) {
			heapify(j);
		}	
	}
	
	/*
	 * Time Complexity: O(NlogN)
	 */
	private void BuildHeap() {
		size = list.size(); // update size of heap
		// heapify from non-leaf nodes to all the way to top
		for (int i = size / 2; i >= 0 ; i--) {
			heapify(i);
		}
	}
	
	
	/*
	 * constructors: needs to call 
	 * default constructor as well 
	 * bcoz compile time error
	 */
	public PriorityHeap(){}
	public PriorityHeap(T[] arr, boolean status){ this.buildHeap(arr, status);}
	public PriorityHeap(boolean isMinHeap){ this.isMinHeap = isMinHeap;}
	
	/*
	 * get nodes , left, right and parent
	 */
	private int getLeft(int index) { return (index * 2) + 1 >= size? -1 : (index * 2) + 1; }
	private int getRight(int index) { return (index * 2) + 2 >= size? -1 : (index * 2) + 2; }
	private int getParent(int index) { return (index < 0? -1 : index/2); }
	
	/*
	 * add a node at size
	 * always call heap at 0
	 */ 
	public void add(T item) {
		list.add(size++, item);
		heapify(0);	
	}
	
	/* 
	 * isminHeap == true.  Min heap, root is minimum from both of its children
	 * isMinHeap == false. Max heap, root is greater than its both children 
	 * if i != parent then swap
	 * and again call heapify on parent node.
	 */
	private void heapify(int i) {
		int left = getLeft(i);
		int right = getRight(i);
		int parent = i;
		if(isMinHeap) {
			if(left != -1 && list.get(parent).compareTo(list.get(left)) > 0) 
				parent = left;
			if(right != -1 && list.get(parent).compareTo(list.get(right)) > 0)
				parent = right;
			
		} else {
			if(left != -1 && list.get(parent).compareTo(list.get(left)) < 0)
				parent = left;
			if(right != -1 && list.get(parent).compareTo(list.get(right)) < 0)
				parent = right;	
		}
		if(parent != i) {
			swap(i, parent);
			heapify(parent);
		}		
	}
	/*
	 * Swap nodes
	 */
	private void swap(int i, int parent) {
		T item = list.get(i);
		list.set(i, list.get(parent));
		list.set(parent, item);	
	}
	/*
	 * Get Peek
	 */
	public T getPeek() {
		if(size > 0)
			return list.get(0);	
		return null;
	}
	/*
	 * Extract peek from heap
	 */
	public T extractPeek() {
		if(size > 0) {
			swap(0, size-1);
			size--;
			heapify(0);
			return list.get(size);
			
		}
		return null;
	}
	
	/*
	 * Sort Heap Take O(NlogN).
	 */
	public List<T> sortHeap(boolean isAsc) {
		
		List<T> result = new ArrayList<T>();
		int s = size;
		
		// we are extrating min or max N time and each extract take logN operation.
		while(s > 0) {
			result.add(extractPeek());
			s--;
		}
		
		if (isAsc) {
			if(!isMinHeap)
				Collections.reverse(result);
		} else {
			if(isMinHeap)
				Collections.reverse(result);
		}
		
		// Re arrange element into Heap after sorting
		//buildHeap();
		//System.out.println(Arrays.asList(result));
		return result;
	}
}


