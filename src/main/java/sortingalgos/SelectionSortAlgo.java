package sortingalgos;

public class SelectionSortAlgo implements SortingAlgo {

	public int[] performSort(int[] arr) {
		int temp = 0;
		for(int k=0; k< arr.length; k++) {
			for(int i=0; i< arr.length; i++) {
				if(arr[k] < arr[i]) {
					//Swap
					temp = arr[k];
					arr[k] = arr[i];
					arr[i] = temp;
				}
				
				
			}
			
		
		}
		
		return arr;
		
	}
}
