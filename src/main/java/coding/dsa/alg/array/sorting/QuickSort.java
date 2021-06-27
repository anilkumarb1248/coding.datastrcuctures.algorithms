package coding.dsa.alg.array.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// int[] array = { 2, 10, 12, 15, 20 }; // Already sorted
		int[] array = { 10, 2, 3, 90, 43, 56 }; // [2, 3, 10, 43, 56, 90]
		// int[] array = { 64, 25, 12, 11, 22, 11 }; // [11, 11, 12, 22, 25, 64]
		System.out.println("Before Sorting: " + Arrays.toString(array));
		sortByQuickSort(array, 0, array.length - 1);
		System.out.println("After Sorting: " + Arrays.toString(array));
	}

	private static void sortByQuickSort(int[] array, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			// find pivot element such that
			// elements smaller than pivot are on the left
			// elements greater than pivot are on the right
			int pivoitIndex = partition(array, startIndex, endIndex);

			// recursive call on the left of pivot
			sortByQuickSort(array, startIndex, pivoitIndex - 1);

			// recursive call on the right of pivot
			sortByQuickSort(array, pivoitIndex + 1, endIndex);
		}
	}

	// method to find the partition position
	private static int partition(int array[], int startIndex, int endIndex) {

		// choose the rightmost element as pivot
		int pivot = array[endIndex];

		// pointer for greater element
		// Index of smaller element and indicates the right position of pivot found so
		// far
		int i = (startIndex - 1);

		// traverse through all elements
		// compare each element with pivot
		for (int j = startIndex; j < endIndex; j++) {
			if (array[j] <= pivot) {

				// if element smaller than pivot is found
				// swap it with the greatr element pointed by i
				i++;

				// swapping element at i with element at j
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}

		}

		// swapt the pivot element with the greater element specified by i
		int temp = array[i + 1];
		array[i + 1] = array[endIndex];
		array[endIndex] = temp;

		// return the position from where partition is done
		return (i + 1);
	}

}
