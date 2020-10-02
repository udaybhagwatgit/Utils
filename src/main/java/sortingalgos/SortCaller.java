package sortingalgos;

public class SortCaller {

	public static void main(String [] args) {
		int[] myArray = {1, 5, 6, 4, 1, 5, 10, 3, 8, 9};
		
		SortingAlgo s = new InsertionsortAlgo();
		int[] sortedArray = s.performSort(myArray);
		for(int a : sortedArray) {
			System.out.println(a);
		}
	}
}
