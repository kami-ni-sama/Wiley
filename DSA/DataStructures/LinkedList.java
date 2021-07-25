package dsa.datastructure;

public class LinkedList<T> {
	
	Node<T> head;
	
	static class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	
	boolean isEmpty() {
		return this.head == null;
	}
	
	boolean isPresent(T data) {
		if(this.head == null) 
			return false;
		Node<T> current = head;
		while(current!=null) {
			if(current.data == data)
				return true;
			current = current.next;
		}
		return false;
	}
	
	int length() {
		Node<T> current = head;
		int ctr = 0;
		while(current!=null) {
			current = current.next;
			ctr++;
		}
		return ctr;
	}
	
	void append(T data) {
		if(this.head == null) {
			this.head = new Node<T>(data);
			return;
		}
		Node<T> current = head;
		while(current.next != null)
			current = current.next;
		current.next = new Node<T>(data);
	}
	
	void prepend(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.next = head;
		head = newNode;
	}
	
	T popRear() {
		if(this.head == null)
			return null;
		Node<T> current = head;
		while(current.next.next != null)
			current = current.next;
		T popVal = (T)current.next.data;
		current.next = null;
		return popVal;
	}
	
	T popFront() {
		if(this.head == null)
			return null;
		T popVal = (T)this.head.data;
		this.head = this.head.next;
		return popVal;
	}
	
	void print() {
		Node<T> current = this.head;
		System.out.print("Head");
		while(current != null) {
			System.out.print("-->"+current.data);
			current = current.next;
		}
		System.out.print("-->Null\n");
	}
	
	void deleteNodeVal(T data) {
		if(this.head == null) 
			return;
		if(this.head.data == data) {
			this.head = this.head.next;
			return;
		}
		Node<T> current = head;
		while(current.next!=null) {
			if(current.next.data == data)
				current.next = current.next.next;
			current = current.next;
		}
	}
	
	T middleNode() {
		if(this.head == null)
			return null;
		Node<T> current = head;
		Node<T> currentx2 = head;
		while(currentx2!=null && currentx2.next!=null) {
			current = current.next;
			currentx2 = currentx2.next.next;
		}
		return current.data;
	}
	
	void reverse() {
		Node<T> previous = null;
		Node<T> current = this.head;
		Node<T> next = null;
		while(current!=null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		this.head= previous;
	}
	
	
}
