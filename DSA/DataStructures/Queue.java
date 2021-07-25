package dsa.datastructure;

public class Queue<T> {
	private T arr[];
	private int front;
	private int rear;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	Queue(int size) {
		arr = (T[]) new Object[size];
		front = 0;
		rear = -1;
		capacity = size;
	}
	
	boolean isEmpty() {
		return rear - front == -1;
	}
	
	boolean isFull() {
		return rear + front == capacity -1;
	}
	
	void enqueue(T data) {
		if(isFull()) {
			System.out.println("Queue full");
			return;
		}
		arr[++rear] = data;
	}
	
	void dequeue() {
		if(isEmpty()) {
			System.out.println("Empty queue");
			return;
		}
		front++;
	}
	
	T peek() {
		if(isEmpty()) {
			System.out.println("Empty queue");
			return null;
		}
		return arr[front];
	}
	
	void print() {
		if(isEmpty()) {
			System.out.println("Empty queue");
			return;
		}
		System.out.println(arr[front]+" <-- front");
		for(int i = front+1; i < rear; i++) 
			System.out.println(arr[i]);
		System.out.println(arr[rear]+" <-- rear");
	}
	
	int size() {
		return rear - front + 1;
	}
}
