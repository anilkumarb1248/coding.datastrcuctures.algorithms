package coding.dsa.alg.array.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = { 2, 3, 10, 43, 56, 90 };

		// If -1 means, the given element is not found
		int searchItem = 2;
		int foundPosition = searchByIterativeBinarySearch(array, searchItem);
		if (foundPosition != -1) {
			System.out.println(searchItem + " found at position: " + foundPosition);
		} else {
			System.out.println(searchItem + " is not found");
		}

		System.out.println(searchByRecursiveBinarySearch(array, 43, 0, array.length - 1));
		System.out.println(searchByRecursiveBinarySearch(array, 100, 0, array.length - 1));
	}

	public static int searchByIterativeBinarySearch(int[] array, int searchItem) {
		int firstIndex = 0;
		int lastIndex = array.length - 1;
		while (firstIndex <= lastIndex) {
			int middleIndex = firstIndex + ((lastIndex - firstIndex) / 2);

			if (array[middleIndex] == searchItem)
				return middleIndex;

			if (array[middleIndex] < searchItem) {
				firstIndex = middleIndex + 1;
			} else {
				lastIndex = middleIndex - 1;
			}
		}

		return -1;
	}

	public static int searchByRecursiveBinarySearch(int[] array, int searchItem, int firstIndex, int lastIndex) {

		if (firstIndex <= lastIndex) {
			int middleIndex = firstIndex + ((lastIndex - firstIndex) / 2);

			if (array[middleIndex] == searchItem)
				return middleIndex;

			if (array[middleIndex] < searchItem) {
				return searchByRecursiveBinarySearch(array, searchItem, firstIndex + 1, lastIndex);
			} else {
				return searchByRecursiveBinarySearch(array, searchItem, firstIndex, middleIndex - 1);
			}
		}
		return -1;
	}
}
