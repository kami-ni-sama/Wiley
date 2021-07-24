package dsa.algorithm.sorting;

/*
 * Time Complexity Analysis:
 * 		-Best case : O( n^2 )
 * 		-Average Case : O( n^2 )
 * 		-Worst Case : O( n^2 )
 */

public class SelectionSort extends MySort{
	
	public void sort(int[] arr) {
		selectionSort(arr.length, arr);
	}
	
	void selectionSort(int n, int[] arr) {
		for(int i = 0; i < n; i ++) {
			int MIN_INDEX = i;
			for(int j = i+1; j < n; j ++)
				if(arr[j]<arr[MIN_INDEX])
					MIN_INDEX = j;
			swap(i, MIN_INDEX, arr);
		}
	}
	
	

}
