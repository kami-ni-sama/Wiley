package dsa.algorithm.sorting;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		System.out.println("Enter the elements");
		int [] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Sort s = new BubbleSort();
		System.out.println("Unsorted Array: ");
		s.print(arr);
		s.sort(arr);
		System.out.println("Sorted Array: ");
		s.print(arr);
	}

}
