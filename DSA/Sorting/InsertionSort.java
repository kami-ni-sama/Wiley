package dsa.algorithm.sorting;

/*
 * Time Complexity Analysis:
 * 		-Best case : O( n )
 * 		-Average Case : O( n^2 )
 * 		-Worst Case : O( n^2 )
 */

public class InsertionSort extends MySort{
	
	public void sort(int[] arr) {
		insertionSort(arr.length, arr);
	}
	
	void insertionSort(int n, int[] arr) {
		for(int i = 1; i < n; i++) {
			int key = arr[i];
			int index = i-1;
			while(index>=0 && arr[index]>key) {
				arr[index + 1] = arr[index];
				index-=1;
			}
			arr[index + 1] = key;
		}
	}
}
