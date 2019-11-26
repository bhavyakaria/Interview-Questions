import java.util.Arrays;
/*
 * Quick Sort
 * In this we pick a pivot element and divide the array around it.
 *
 * Time Complexity :
 * Worst Case -> O(n^2)
 * Best Case -> O(nlogn)
 * Average Case -> O(nlogn)
 *  
 * Space Complexity: O(n)
 */

/**
 *
 * @author Parzival
 */
class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[]{10, 50, 60, 20, 80, 30, 40, 70};
		int start = 0, end = arr.length - 1;
		sort(arr, start, end);
		System.out.println(Arrays.toString(arr));
	}

	static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			sort(arr, start, pivot - 1);
			sort(arr, pivot + 1, end);
		}
	}

	static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if(arr[j] < pivot) {
				i++;
				// swap elements
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap elements
		int temp = arr[i+1];
		arr[i+1] = pivot;
		arr[end] = temp;
		return (i + 1);
	}

}