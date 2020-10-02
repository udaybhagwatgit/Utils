package sortingalgos;

public class InsertionsortAlgo implements SortingAlgo {

	@Override
	public int[] performSort(int[] sortedArray) {
		//Here we start from the 1st element not from 0th element. 
		//Because we have taken out the 0th element from sorting array, which leaves us with (len-1) elements
		for(int i=0; i< sortedArray.length - 1; i++) { 
			//this is internal sort. starts from 1st element and comparison with nth element with (n-1)th element. 
			//If (n-1)th element is greater than the nth element, we swap, and then further iterate that swapped element with its (n-2)th elemtn and so on.
			for(int k=i+1; k>0; k--) {
				if(sortedArray[k] < sortedArray[k-1]) {
					int temp = sortedArray[k];
					sortedArray[k] = sortedArray[k-1];
					sortedArray[k-1] = temp;
				} else {
					break;
				}
			}
		}
		
		
		return sortedArray;
	}

	
}
