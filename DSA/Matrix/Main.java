package dsa.matrix;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int r = 3, c = 2;
		int[][] a = new int[r][c];
		int[][] b = new int[3][r];
		int i, j;
		System.out.println("Enter values into first array");
		for(i = 0; i < r; i++)
			for(j = 0; j < 2; j++)
				a[i][j] = sc.nextInt();
		Matrix m1 = new Matrix(a);
		m1.print();
		System.out.println("Enter values into second array");
		for(i = 0; i < 3; i++)
			for(j = 0; j < r; j++)
				b[i][j] = sc.nextInt();
		Matrix m2 = new Matrix(b);
		m2.print();
		System.out.println("Resultant array");
		Matrix m3 = m1.multiply(m2);
		if(m3!=null) m3.print();
		
	}

}
