package dsa.algorithm.sorting;

public abstract class MySort {
	
	abstract void sort(int[] arr);
	
	void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void print(int[] arr) {
		for(int elem : arr) {
			System.out.print(elem+" ");
		}
		System.out.println();
	}
}
