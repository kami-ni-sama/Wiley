package wiley.dsa.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;



public class GraphString {

	class Node {
		private String destination;
		private int weight;
		public Node(String destination) {
			this.destination = destination;
		}
		public Node(String destination, int weight) {
			super();
			this.destination = destination;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return " [ "+destination + " " + weight + " ] ";
		}
		public String getDestination() {
			return destination;
		}
		public int getWeight() {
			return weight;
		}
		@Override
		public boolean equals(Object obj) {
			Node newNode = (Node) obj;
			return this.destination.equals(newNode.getDestination());
		}
		
		
	}
	
	private Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();

	private void addNewVertex(String vertex) {
		map.put(vertex, new LinkedList<String>());
	}

	public void addNewEdge(String source, String destination, boolean biDirectional){
		if(!map.containsKey(source))
			addNewVertex(source);
		if(!map.containsKey(destination))
			addNewVertex(destination);
		map.get(source).add(destination);
		if(biDirectional == true)
			map.get(destination).add(source);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(String key : map.keySet()){
			builder.append(key.toString()+" : ");
			for(String value : map.get(key)) {
				builder.append(value+" ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public int countVertices() {
		return map.keySet().size();
	}
	
//	public int countEdges() {
//		int ctr = 0;
//		ArrayList<String> visited = new ArrayList<String>();
//		for(String key : map.keySet()) {
//			visited.add(key);
//			for(Node value : map.get(key)) {
//				boolean flag = false;
//				if(visited.contains(value.getDestination())) 
//					for(Node node : map.get(value.getDestination()))
//						if(node.equals(new Node(key))) {
//							flag = true;
//							break;
//						}
//				if(!flag)
//					ctr++;
//			}
//		}
//		return ctr;
//	}
	
	public void bfs(String source) {
		if(!map.containsKey(source)) {
			System.out.println("Vertex "+source+" does not exist");
			return;
		}
		Queue<String> queue = new LinkedList<String>();
		List<String> visited = new ArrayList<String>();
		queue.add(source);
		while(!queue.isEmpty()) {
			String current = queue.remove();
			visited.add(current);
			System.out.print(current+"->");
			LinkedList<String> temp = map.get(current);
			temp.forEach(destination -> {
				if(!visited.contains(destination) && !queue.contains(destination))
					queue.add(destination);
				});
		}
	}
	
	public void dfs(String source) {
		if(!map.containsKey(source)) {
			System.out.println("Vertex "+source+" does not exist");
			return;
		}
		Stack<String> queue = new Stack<String>();
		List<String> visited = new ArrayList<String>();
		queue.add(source);
		while(!queue.isEmpty()) {
			String current = queue.pop();
			visited.add(current);
			System.out.print(current+"->");
			LinkedList<String> temp = map.get(current);
			temp.forEach(destination -> {
				if(!visited.contains(destination) && !queue.contains(destination))
					queue.push(destination);
				});
		}
	}
	
//	public String traversal(String source) {
//		if(!map.containsKey(source))
//			return null;
//		PriorityQueue<String> queue = new PriorityQueue<String>();
//		queue.add(source);
//		while(!queue.isEmpty()) {
//			String source = 
//		}
//	}
	
}

