package dsa.matrix;

import java.util.Scanner;

public class Matrix {
	Scanner sc = new Scanner(System.in);
	int[][] arr;
	int row, column;
	
	Matrix(int row, int column) {
		arr = new int[row][column];
		this.row = row;
		this.column = column;
	}
	
	Matrix(int[][] arr) {
		this.arr = arr;
		this.row = arr.length;
		this.column = arr[0].length;
	}

	void insert() {
		for(int i = 0; i < row; i++)
			for(int j = 0; j < column; j++)
				this.arr[i][j] = sc.nextInt();
	}
	
	Matrix multiply(Matrix m) {
		if(column != m.arr.length) {
			System.out.println("Incompatible matrices");
			return null;
		}
		Matrix result = new Matrix(this.row, m.column);
		for(int i = 0; i < this.row; i++) 
			for(int j = 0; j < result.column; j++) 
				for(int k = 0; k < this.column; k++) 
					result.arr[i][j] += this.arr[i][k] * m.arr[k][j];
		return result;
	}
	
	void print() {
		for(int i = 0; i < this.row; i ++) {
			for(int j = 0; j < this.column; j ++) {
				System.out.print(this.arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
