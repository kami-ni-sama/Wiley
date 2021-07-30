package dsa.datastructures;

public class Stack<T> {
	private T arr[];
	private int top;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	Stack(int size){
		this.arr = (T[]) new Object[size];
		this.top = -1;
		this.capacity = size;
	}
	
	boolean isFull() {
		return top == capacity-1;
	}
	
	boolean isEmpty() {
		return top == -1;
	}
	
	void push(T data) {
		if(isFull()) {
			System.out.println("Stack full");
			return;
		}
		arr[++top] = data;
	}
	
	T pop() {
		if(isEmpty()) {
			System.out.println("Stack empty");
			return null;
		}
		return arr[top--];
	}
	
	T peek() {
		if(isEmpty()) {
			System.out.println("Stack empty");
			return null;
		}
		return arr[top];
	}
	
	int size() {
		return top+1;
	}
	
	void print() {
		if(isEmpty()) {
			System.out.println("Empty stack");
			return;
		}
		for(int i = top; i >=0 ; i --)
			if(i == top)
				System.out.println(arr[i]+"<--");
			else
				System.out.println(arr[i]);
	}
}
