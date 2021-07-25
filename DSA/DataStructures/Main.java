package dsa.datastructure;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
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
