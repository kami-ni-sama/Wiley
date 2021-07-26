package dsa.algorithm.sorting;

public abstract class MySort implements Sort{
	
	public abstract void sort(int[] arr);
	
	public void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void print(int[] arr) {
		for(int elem : arr) {
			System.out.print(elem+" ");
		}
		System.out.println();
	}
}
