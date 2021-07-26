package dsa.datastructure;



public class BinarySearchTree {

	class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	Node root;

	BinarySearchTree() {
		this.root = null;
	}

	void insert(int data) {
		//		insertIterative(data);
		root = insertRecursive(this.root, data);
	}

	@SuppressWarnings("unused")
	private void insertIterative(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		while(true) {
			if(data < current.data) 
				if(current.left != null)
					current = current.left;
				else {
					current.left = newNode;
					break;
				}
			else
				if(current.right != null)
					current = current.right;
				else {
					current.right = newNode;
					break;
				}
		}
	}

	@SuppressWarnings("unused")
	private Node insertRecursive(Node root, int data) {
		Node node=new Node(data);
		if(root==null) {
			root=node;
			return root;
		}
		else if(data<root.data)
			root.left=insertRecursive(root.left,data);
		else if(data>root.data)
			root.right=insertRecursive(root.right, data);

		return root;
	}

	void inorder() {
		inorderRec(root);
		System.out.println();
	}

	private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.data+" ");
			inorderRec(root.right);
		}
	}

	void preorder() {
		preorderRec(root);
		System.out.println();
	}

	private void preorderRec(Node root) {
		if (root != null) {
			System.out.print(root.data+" ");
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}

	void postorder() {
		postorderRec(root);
		System.out.println();
	}

	private void postorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(root.data+" ");
		}
	}

	public int height() {
		return heightRec(this.root);
	}

	private int heightRec(Node root) {
		if (root == null)
			return 0;
		else {
			int lheight = heightRec(root.left);
			int rheight = heightRec(root.right);
			if (lheight > rheight)
				return(lheight+1);
			else return(rheight+1);
		}
	}

	public void bfs() {
		bfsIterative(this.root);
		System.out.println();
	}

	private void bfsIterative(Node root) {
		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			Node temp = queue.dequeue();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				queue.enqueue(temp.left);
			if(temp.right!=null)
				queue.enqueue(temp.right);
		}
	}

	boolean dfsSearch(int data) {
		//	   return dfsSearchIterative(this.root, data);
		return dfsSearchRecursive(this.root, data);
	}

	@SuppressWarnings("unused")
	private boolean dfsSearchIterative(Node root, int data) {
		while(root!=null) {
			if(data > root.data)
				root = root.right;
			else if(data < root.data)
				root = root.left;
			else
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private boolean dfsSearchRecursive(Node root, int data) {
		if(root == null)
			return false;
		if(data < root.data)
			return dfsSearchRecursive(root.left, data);
		else if(data > root.data)
			return dfsSearchRecursive(root.right, data);
		else
			return true;
	}

}
