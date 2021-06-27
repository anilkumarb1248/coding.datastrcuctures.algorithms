package coding.dsa.alg.array.sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		// int[] array = { 2, 10, 12, 15, 20 }; // Already sorted
		// int[] array = { 10, 2, 3, 90, 43, 56 }; // [2, 3, 10, 43, 56, 90]
		int[] array = { 64, 25, 12, 11, 22, 11 }; // [11, 11, 12, 22, 25, 64]
		System.out.println("Before Sorting: " + Arrays.toString(array));
		sortByInsertionSort(array);
		System.out.println("After Sorting: " + Arrays.toString(array));
	}

	public static int[] sortByInsertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && temp <= array[j]) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = temp;
		}
		return array;
	}
}