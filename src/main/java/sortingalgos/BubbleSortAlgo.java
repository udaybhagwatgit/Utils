package sortingalgos;

public class BubbleSortAlgo implements SortingAlgo {

	@Override
	public int[] performSort(int[] arr) {
		int temp = 0;
		
		for (int j = 0; j < arr.length; j++) {
			boolean swapped = false;
			for (int k = 0; k < arr.length; k++) {
				if (k != arr.length - 1 && arr[k] > arr[k + 1]) {
					temp = arr[k];
					arr[k] = arr[k + 1];
					arr[k + 1] = temp;
					swapped = true;
				}
				
			}
		}
		return arr;
	}

}
