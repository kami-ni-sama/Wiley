package dsa.algorithm.sorting;

/*
 * Time Complexity Analysis:
 * 		-Best case : O( n*Log(n) )
 * 		-Average Case : O( n*Log(n) )
 * 		-Worst Case : O( n^2 )
 */

public class QuickSort extends MySort{
	
	public void sort(int[] arr) {
		quickSort(0, arr.length-1, arr);
	}
	
	void quickSort(int low, int high, int[] arr) {
		if(low < high) {
			int p = partition(low, high, arr);
			quickSort(low, p-1, arr);
			quickSort(p+1, high, arr);
		}
	}
	
	int partition(int low, int high, int[] arr) {
		int pivot = arr[high];
		int index = low - 1;
		for(int i = low; i < high; i++) 
			if(arr[i] < pivot) {
				index++;
				swap(index, i, arr);
			}
		swap(++index, high, arr);
		return index;
	}
}
