package dsa.datastructure;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Queue<Integer> q = new Queue<Integer>(5);
		q.enqueue(1);
		q.enqueue(2);
		q.dequeue();
		q.enqueue(3);
		q.enqueue(4);
		q.print();
		System.out.println(q.peek());
		System.out.println(q.size());
		
		Stack<Integer> s = new Stack<Integer>(5);
		s.print();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.print();
		
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.prepend(1);
		ll.append(5);
		ll.print();
		ll.reverse();
		ll.print();
	}

}
