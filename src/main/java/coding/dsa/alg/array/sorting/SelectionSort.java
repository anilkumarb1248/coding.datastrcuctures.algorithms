package coding.dsa.alg.array.sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		// int[] array = { 20, 12, 10, 15, 2 }; // [2, 10, 12, 15, 20]
		// int[] array = { 10, 2, 3, 90, 43, 56 }; // [2, 3, 10, 43, 56, 90]
		int[] array = { 64, 25, 12, 22, 11 }; // [11, 12, 22, 25, 64]
		System.out.println("Before Sorting: " + Arrays.toString(array));
		sortBySelectionSort(array);
		System.out.println("After Sorting: " + Arrays.toString(array));
	}

	public static int[] sortBySelectionSort(int[] array) {
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;

			// Find the minimum element in unsorted array
			for (int j = i + 1; j < array.length; j++) {
				// Select the minimum element in each loop.
				if (array[j] < array[minIndex]) { // < - Ascending > - Descending
					minIndex = j;
				}
			}

			// Swap the found minimum element with the first element
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}
}
