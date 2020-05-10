package sorting;

import java.util.Arrays;

public class Sorting {
	
	public enum SortType{
		BUBBLE_SORT,
		SELECTION_SORT,
		INSERTION_SORT,
		QUICK_SORT,
		MERGE_SORT
//			
	}
	
	
	/*
	 * Bubble sort: 2 pass algorithm, and in every pass greater element in the end 
	 * time complexity: n*n
	 * space complexity: constant
	 * 
	 */
	public static void BubbleSort(int[] arr) {
		boolean status = true;
		for(int i = 0; i < arr.length; i++) {
			status = true; // performance 
			for(int j = 0; j < arr.length-(i+1); j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					status = false;	
				}	
			}
			//performance enhancement, as soon as my array is sorted it will break from the passes
			if(status) {
				break;	
			}						
		}		
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/*
	 * Selection sort: fix first element: and look for minimum value in rest array and 
	 * then compare it with first element if smaller then swap. means, minimum element in the beginning of the array
	 * time complexity: n*n
	 * space complexity: constant
	 */
	private static void SelectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int minimum = i; // assume this is the minimum element
			for(int j = i+1; j < arr.length; j++) {
				if(arr[minimum] > arr[j]) { // now find smaller than minimum 
					minimum = j;
				}				
			}
			if(i != minimum) { // if you find minimum element in array then swap
				swap(arr, i, minimum);
			}			
		}	
	}

	/*					j i
	 * Insertion Sort: [6,5,3,1,8,7,2,4] : temp = arr[i] and j = i - 1;
	 * time complexity: n * n
	 */
	public static void InsertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > temp) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}	
	}
	
	/*
	 * Quick Sort: remember point is wall; from left to wall index all elements are smaller than pivot
	 * time complexity: nlogn // tree concept to calculate the time complexity// logn(height of tree) * every level requires n operations therefore, nlogn
	 * space complexity: logn for recursive
	 * 
	 */
	public static void QuickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pivot = partition(arr, low, high);
			QuickSort(arr, low, pivot-1);
			QuickSort(arr, pivot+1, high);
		}	
	}
	
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int wall = low;
		for(int i = low+1; i <= high; i++) {
			if(arr[i] < pivot) {
				wall++;	
				swap(arr, wall, i);	
			}
		}
		swap(arr, wall, low);	
		return wall;
	}
	
	/*
	 * Merge Sort:
	 * time complexity: nlogn
	 * space complexity: constant 
	 */
	
	public static void MergeSort(int[]arr, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			MergeSort(arr, low, mid);
			MergeSort(arr, mid+1, high);
			merge(arr, low, mid, high);
		}	
	}
	/*
	 * No external array is used
	 *  	
	 */
	private static void merge(int[] arr, int low, int mid, int high) {
		int start = low;
		int start2 = mid+1;
		
		if(arr[mid] <= arr[start2])
			return;
		
		while(start <= mid && start2 <= high) {
			// array 1 value is smaller than no need to do anything except increment the array pointer
			if(arr[start] <= arr[start2])
				start++;
			else {
				//store value of array 2 which is smaller 
				int value = arr[start2];
				int index = start2;
				
				// move all the elements to right till start2
				while(index != start) {
					arr[index] = arr[index-1];
					index--;
				}
				// store the value on start index
				arr[start] = value;
				// there will be 3 pointer which needs to be increment
				start++;
				start2++;
				mid++;
			}
		}				
	}

	public static void main(String args[]) {
		for(int i = 0; i < SortType.values().length; i++) {
			int [] arr = new int[] {5,7,3,2,99,6,1,9,12,55,8};
			switch(SortType.values()[i]) {
				case BUBBLE_SORT:
					BubbleSort(arr);
					break;
				case SELECTION_SORT:
					SelectionSort(arr);
					break;
				case INSERTION_SORT:
					InsertionSort(arr);
					break;
				case QUICK_SORT:
					QuickSort(arr, 0, arr.length-1);
					break;
				case MERGE_SORT:
					MergeSort(arr, 0, arr.length-1);
					break;		
			}
			assert Arrays.equals(arr, new int[] {1,2,3,5,6,7,8,9,12,55,99}) == true;		
		}	
	}
	
}
