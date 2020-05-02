package ArrayAndString;

import java.util.Arrays;
import java.util.HashSet;

public class SushantArray {
	
	/* Binary Search in Array recursive  only in sorted array
	 * time: log(N)
	 * space: log(N) due to recursive stack
	 */
	public static boolean BinarySearchRecursive(int[] arr, int low, int high, int k) {
		if(low < high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] == k)
				return true;
			else if(arr[mid] > k)
				return BinarySearchRecursive(arr, low, mid - 1, k);
			else
				return BinarySearchRecursive(arr, mid + 1, high, k);
			}
		return false;		
	}
	
	/* Binary Search in Array recursive only in sorted array
	 * Time Complexity: log(N)
	 * Space Complexity O(1) constant 
	 */
	public static boolean BinarySearchIterative(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		
		while(low < high) {
			int mid = (low + high) / 2;
			if(arr[mid] == k)
				return true;
			else if(arr[mid] > k)
				high = mid - 1;
			else 
				low = mid + 1;
		}
		return false;
	}
	
	/*
	 * Maximum difference between 2 elements in an array
	 * time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static int MaxDifference(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int element: arr) {
			min = Math.min(min, element);
			max = Math.max(max, element);
		}
		return max - min;
	}
	
	/* Count all distinct pairs with difference equal to k that is, (1, 2) (2,1)== not distinct 
	 * time complexity: 2n
	 * space: n
	 * 
	 */
	public static int PairsWithSameDiff(int[] arr, int diff) {
		int count = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : arr) {
			set.add(i);
		}
		for(int i = 0; i < arr.length; i++) {
			int element = arr[i];
			if(set.contains(diff - element)) {
				count++;
				set.remove(element);
			}
		}
		return count;	
	}
	
	/*
	 * Given an array of (unsorted) integers, arrange them such that a < b > c < d > e... etc.
	 * idea 1: [1, 2, 3, 4, 5] == [1 < 3 > 2 < 5 > 4] there is one way, sort the array and then swap (1,2), (3,4),(5,6),(7,8).... time nlogn in sortring + n
	 */
	
	public static int[] SpecialSortingArray(int[] arr, String s) {
		Arrays.sort(arr);
		for (int i = 1; i < arr.length - 1; i = i + 2) {
			swap(arr, i, i + 1);

		}
		return arr;
	}
	
	/*
	 * idea 2: even index element is smaller than next index; odd index element is greater than even; time n
	 */
	public static int[] SpecialSortingArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (i % 2 == 0) {
				if (arr[i] > arr[i + 1])
					swap(arr, i, i + 1);

			} else {
				if (arr[i] < arr[i + 1])
					swap(arr, i, i + 1);
			}
		}
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
	
	/*
	 * Find the element in Sorted array that is rotated many times
	 */
	public static int FindRotatedSortedArray(int[] nums, int value) {
		return 1;
		
	}

	
	public static void main(String args[]) {
		int [] arr = new int[] {1, 4, 7, 8, 10, 16};
		
		// binary Search
		assert BinarySearchRecursive(arr, 0, arr.length-1, 1) == true;
		assert BinarySearchIterative(arr, 7) == true;
		
		
		int [] arr1 = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
		assert MaxDifference(arr1) == 8;
		assert PairsWithSameDiff(arr1, 6) == 1;
		
		
		assert Arrays.equals(SpecialSortingArray(new int[] { 2, 4, 1, 6, 8, 4}, "sorting"), new int [] {1, 4, 2, 6, 4, 8}) == true;
		assert Arrays.equals(SpecialSortingArray(new int[] { 2, 4, 1, 6, 8, 4}), new int [] {2, 4, 1, 8, 4, 6}) == true;
		
		
	}

}
