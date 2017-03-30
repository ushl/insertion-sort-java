package localhost;

import java.util.Arrays;

public class InsertionSort {

	private static final boolean DEBUG = false;

	/**
	 * Insertion sort.
	 * <p>
	 * Time complexity: O(n2)
	 * <p>
	 * Good:
	 * - Space efficient.
	 * - More efficient than bubble sort on "almost sorted" arrays.
	 * <p>
	 * Bad:
	 * - High cpu time.
	 * - Moderate number of writes.
	 * - A stable sort -- equal elements are not re-arranged.
	 * - Uses O(1) extra space for temp storage.
	 * - Adaptive -- stops early if the array is sorted before iterations are complete.
	 *
	 * @param array The array to sort.
	 * @return The same array, sorted.
	 */
	public static int[] sort(int[] array) {
		// Iterate on every element in the array.
		for (int i = 0; i < array.length - 1; i++) {
			if (DEBUG) System.out.println("Position: " + i);

			// Beginning with the second element in the array, compare the element with all prior
			// elements (to the left). Swap to sort as necessary.
			// Each iteration begins with the next array index to the right.
			for (int j = i + 1; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swapElements(array, j, j - 1);
					if (DEBUG) printArray(array);
				} else {
					// If the element is in a sorted position (is greater than the element before it),
					// don't check the remaining elements to the left. (adaptive behavior)
					break;
				}
			}
		}

		return array;
	}

	/**
	 * Swap the position of two elements in an array, in-place.
	 *
	 * @param array The array.
	 * @param i     The first element's position index.
	 * @param j     The second element's position index.
	 * @return The same array given. We return a value for unit testing.
	 */
	protected static int[] swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

		return array;
	}

	/**
	 * Print the contents of an array.
	 *
	 * @param array The array to print.
	 * @return The printed string. We return a value for unit testing.
	 */
	protected static String printArray(int[] array) {
		String message = "During: " + Arrays.toString(array);
		System.out.println(message);

		return message;
	}

}
