package dsa.datastructures;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		Queue<Integer> q = new Queue<Integer>(5);
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.dequeue());
		q.enqueue(3);
		q.enqueue(4);
		q.print();
		
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
		
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println(bst.bfs(13));
		bst.insert(13);
		bst.insert(32);
		bst.insert(56);
		bst.insert(22);
		bst.insert(47);
		bst.bft();
		System.out.println(bst.bfs(13));
		System.out.println(bst.min());
		bst.remove(13);
		bst.bft();
		
		Graph graph = new Graph();
		graph.addNewEdge("Delhi", "Ahemdabad", 3,  true);
		graph.addNewEdge("Patna", "Delhi", 2, false);
		graph.addNewEdge("Ahemdabad", "Indore", 4, true);
		graph.addNewEdge("Indore", "Patna", 5, true);
		graph.addNewEdge("Chennai", "Ahemdabad", 3, true);
		graph.addNewEdge("Chennai", "Patna", 2, true);
		System.out.println(graph);
		System.out.println("Number of vertices : "+graph.countVertices());
		System.out.println("Number of edges : "+graph.countEdges());
	}
}
