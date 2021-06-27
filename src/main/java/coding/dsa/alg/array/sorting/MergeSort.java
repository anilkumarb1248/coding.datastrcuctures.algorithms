package coding.dsa.alg.array.sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		// int[] array = { 2, 10, 12, 15, 20 }; // Already sorted
		int[] array = { 10, 2, 3, 90, 43, 56 }; // [2, 3, 10, 43, 56, 90]
		// int[] array = { 64, 25, 12, 11, 22, 11 }; // [11, 11, 12, 22, 25, 64]
		System.out.println("Before Sorting: " + Arrays.toString(array));
		sortByMergeSort(array, 0, array.length - 1);
		System.out.println("After Sorting: " + Arrays.toString(array));
	}

	// Divide the array into two subarrays, sort them and merge them
	public static void sortByMergeSort(int[] array, int startIndex, int endIndex) {
		
		//Divide the array into two parts until start & indexex are same
		if (startIndex < endIndex) {
			// middleIndex is the point where the array is divided into two sub arrays
			int middleIndex = (startIndex + endIndex) / 2;
			sortByMergeSort(array, startIndex, middleIndex);
			sortByMergeSort(array, middleIndex + 1, endIndex);

			// Merge the sorted sub arrays
			merge(array, startIndex, middleIndex, endIndex);
		}
	}

	// Merge two sub arrays - firstArray and secondArray into array
	public static void merge(int[] array, int startIndex, int middleIndex, int endIndex) {

		// Find sizes of two subarrays to be merged
		int firstArrayLength = middleIndex - startIndex + 1;
		int secondArrayLength = endIndex - middleIndex;

		// Create temp arrays
		int[] fristArray = new int[firstArrayLength];
		int[] secondArray = new int[secondArrayLength];

		// Copy data to temp arrays
		for (int i = 0; i < firstArrayLength; i++) {
			fristArray[i] = array[startIndex + i];
		}

		for (int j = 0; j < secondArrayLength; j++) {
			secondArray[j] = array[middleIndex + 1 + j];
		}

		/***** Merge the temp arrays ******/

		// Initial indexes of first and second sub arrays
		int firstArrayPosition = 0;
		int secondArrayPosition = 0;

		// Initial index of merged sub array (passed as parameter array)
		int originalArrayPosition = startIndex;

		// Until we reach either end of either firstArrayIndex or secondArrayIndex,
		// pick larger among element and place them in the correct position at
		// array[startIndex..endIndex]
		while (firstArrayPosition < firstArrayLength && secondArrayPosition < secondArrayLength) {
			if (fristArray[firstArrayPosition] <= secondArray[secondArrayPosition]) {
				array[originalArrayPosition] = fristArray[firstArrayPosition];
				firstArrayPosition++;
			} else {
				array[originalArrayPosition] = secondArray[secondArrayPosition];
				secondArrayPosition++;
			}
			originalArrayPosition++;
		}

		/* Copy remaining elements of fristArray[] if any */
		while (firstArrayPosition < firstArrayLength) {
			array[originalArrayPosition] = fristArray[firstArrayPosition];
			firstArrayPosition++;
			originalArrayPosition++;
		}

		/* Copy remaining elements of secondArray[] if any */
		while (secondArrayPosition < secondArrayLength) {
			array[originalArrayPosition] = secondArray[secondArrayPosition];
			secondArrayPosition++;
			originalArrayPosition++;
		}
	}
}