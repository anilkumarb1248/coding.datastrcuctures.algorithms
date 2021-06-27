package coding.dsa.alg.array.sorting;

import java.util.Arrays;

public class BubbleSort_Optimized {

	public static void main(String[] args) {
		int[] array = { 20, 12, 10, 15, 2 }; // [2, 10, 12, 15, 20]
		// int[] array = { 10, 2, 3, 90, 43, 56 }; // [2, 3, 10, 43, 56, 90]
		// int[] array = { 64, 25, 12, 22, 11 }; // [11, 12, 22, 25, 64]
		System.out.println("Before Sorting: " + Arrays.toString(array));
		sortByBubbleSort(array);
		System.out.println("After Sorting: " + Arrays.toString(array));
	}

	public static int[] sortByBubbleSort(int[] array) {

		// loop to access each array element
		for (int i = 0; i < array.length - 1; i++) {

			// loop to compare array elements
			for (int j = 0; j < array.length - i - 1; j++) {

				// compare two adjacent elements
				if (array[j] > array[j + 1]) { // > -> Ascending < -> Descending
					// swap arr[j+1] and arr[j]
					// swapping occurs if elements are not in the intended order
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
}
