package coding.dsa.alg.array.searching;

public class LinearSearch {

	public static void main(String[] args) {
		int[] array = { 10, 2, 3, 90, 43, 56 };

		// If -1 means, the given element is not found
		int searchItem = 2;
		int foundPosition = searchByLinear(array, searchItem);
		if (foundPosition != -1) {
			System.out.println(searchItem + " found at position: " + foundPosition);
		} else {
			System.out.println(searchItem + " is not found");
		}

		System.out.println(searchByLinear(array, 43));
		System.out.println(searchByLinear(array, 100));
	}

	public static int searchByLinear(int[] array, int searchItem) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == searchItem)
				return i;
		}

		return -1;
	}

}
