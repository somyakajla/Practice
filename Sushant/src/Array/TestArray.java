package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class TestArray {
	
	/* Binary Search in Array recursive  only in sorted array
	 * Time Complexity log(N)
	 * Space Complexity log(N) due to recursive 
	 */
	public static boolean BinarySearchRecursive(int[] arr, int low, int high, int k) {
		if (low < high) {
			int mid = (low + high) / 2;
			
			if (arr[mid] == k) 
				return true;
			else if(arr[mid] > k) 
				return BinarySearchRecursive(arr, low, mid - 1, k);
			else 
				return BinarySearchRecursive(arr, mid + 1, high, k);
		}
		
		return false;
	}
	
	/* Binary Search in Array recursive only in sorted array
	 * Time Complexity log(N)
	 * Space Complexity O(1) constant 
	 */
	public static boolean BinarySearchIterative(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		
		while (low < high) {
			int mid = (high + low)/2 ;
			if (arr[mid] == k) 
				return true;
			else if(arr[mid] > k) 
				high = mid - 1;
			else 
				low = mid + 1;
		}
		
		return false;
	}
	
	/*
	 * Maximum difference between two elements in an Array
	 * Time Complexity : O(N)
	 * Space Complexity: O(1)
	 */
	public static int MaxDifference(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int item: arr) {
			min = Math.min(min, item);
			max = Math.max(max, item);
		}
		
		return max - min;
	}
	
	/* Count all distinct pairs with difference equal to k
	 * Time Complexity : O(N) + O(K).. K is number of unique elements
	 * Space Complexity: O(K)
	 */
	public static int PairsWithSameDiff(int[] arr, int diff) {
		HashSet<Integer> h = new HashSet<Integer>();
		for(int item: arr) {
			h.add(item);
		}

		Iterator<Integer> it = h.iterator();
		int count = 0;
		while(it.hasNext()) {
			if (h.contains(it.next() - diff))
				count++;
		}
		
		return count;
	}
	
	/* Given an array of (unsorted) integers, arrange them such that a < b > c < d > e... etc.
	 * Time Complexity: O(N)
	 * 
	 */
	public static void SpecialSortingArray(int[] arr) {
		
	}
	
	/*
	 *  Find Kth Largest Element by passing 5th Largest = Arr.length - K + 1 smallest
	 */
	public static int KthSmallestRecursive(int[] arr, int k, int l, int h) throws Exception {
		if (l <= h) {
			int pos = FindPivot(arr, l, h);
			if (pos + 1  == k )
				return arr[pos];
			else if (pos + 1 > k )
				return KthSmallestRecursive(arr, k, l, pos-1);
			else
				return KthSmallestRecursive(arr, k, pos + 1, h);
		}
		
		throw new Exception("Something Went Wrong");
	}
	
	/*
	 * Find Kth Largest Element by passing 5th Largest = Arr.length - K + 1 smallest 
	 * Time Complexity = O(2n - 1) = O(n + n/2 + n/4 ..) = 2n - 1
	 * Space Complexity = O(1) constant
	 */
	public static int KthSmallestIterative(int[] arr, int k) throws Exception {
		int l = 0;
		int h = arr.length - 1;
		
		while (l < h) {
			int piv = FindPivot(arr, l, h);
			if (piv + 1 == k)
				return arr[piv];
			else if (k < piv + 1)
				h = piv - 1;
			else 
				l = piv + 1;
		}
		
		throw new Exception("Something Went Wrong"); 
	}
	
	private static int FindPivot(int[] arr, int l, int h) {
		int pI = l;
		int wall = l;
		for(int i = l + 1; i <= h; i++) {
			if (arr[i] < arr[pI]) {
				// inserting elements of less value  
	            // to the left of the pivot location
				wall++;
				int temp = arr[i];
				arr[i] = arr[wall];
				arr[wall] = temp;
			}
		}
		
        // swapping pivot to the final pivot location 
		int temp = arr[pI];
		arr[pI] = arr[wall];
		arr[wall] = temp;
		
		return wall;
	}

	public static void main(String[] args) throws Exception {
		int [] arr = new int[] {5, 2, 10, 6, 8, 1, 3, 9, 7};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		assert BinarySearchIterative(arr, 8) == true;
		assert BinarySearchIterative(arr, 11) == false;
		assert BinarySearchRecursive(arr, 0, arr.length-1, 8) == true;
		assert BinarySearchRecursive(arr, 0, arr.length-1, 11) == false;
		
		int [] arr1 = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
		assert MaxDifference(arr1) == 8;
		assert PairsWithSameDiff(arr1, 6) == 2;
		assert KthSmallestRecursive(arr, 3, 0, 8) == 3;   	// Find smallest 
		assert KthSmallestIterative(arr, 3) == 3;   		// Find smallest 
		assert KthSmallestIterative(arr, 7) == 8;   		// Find smallest 
		assert KthSmallestIterative(arr, arr.length - 4 + 1) == 7;   // Find 4th largest 
	}

}
