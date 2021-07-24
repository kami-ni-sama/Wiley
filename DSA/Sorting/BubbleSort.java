package dsa.algorithm.sorting;

/*
 * Time Complexity Analysis:
 * 		-Best case : O( n )
 * 		-Average Case : O( n^2 )
 * 		-Worst Case : O( n^2 )
 */

public class BubbleSort extends MySort{
	
	public void sort(int[] arr) {
		bubbleSort(arr.length, arr);
	}
	
	public void bubbleSort(int n, int[] arr) {
		for(int i = 0; i < n; i ++)
			for(int j = i+1; j < n; j++)
				if(arr[i]>arr[j])
					swap(i, j, arr);
	}

}
