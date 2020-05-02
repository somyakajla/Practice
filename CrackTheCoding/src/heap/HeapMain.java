package heap;

import java.util.Arrays;

public class HeapMain {
	

	public static void main(String args[]) {
		
		PriorityHeap<Integer> ph = new PriorityHeap<Integer>();
		ph.add(5);
		ph.add(2);
		ph.add(9);
		
		assert ph.extractPeek() == 2;
		ph.add(1);
		//System.out.println(ph.extractPeek());
		//assert ph.extractPeek() == 1;
		
		assert ph.sortHeap(false).equals(Arrays.asList(9, 5, 1));
		//assert ph.extractPeek() == 1;
		
//		PriorityHeap<Integer> phMax = new PriorityHeap<Integer>(new Integer [] {3, 6, 1, 4, 9, 7}, false);
//		assert phMax.extractPeek() == 9;
//		assert phMax.getPeek() == 7;
		
	}


}
