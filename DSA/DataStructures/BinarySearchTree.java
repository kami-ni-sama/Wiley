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
	
	void add(int data) {
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
    
}
