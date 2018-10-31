package Alogorithms.trees;

/*
 * LEFT side of parent node is always LESSS. Applies to all children that are left of this parent node.
 * 
 * RIGHT side of parent node is always GREATER. Applies to all children that are left of this parent node.
 * 
 */
public class BinarySearchTree {

	public void insertNode(Node rootNode, Node insertNode)
	{
		if(rootNode.data == insertNode.data) // No need to insert
			return;
		else if(rootNode.data > insertNode.data) { //Go to the left of the tree to insert
			if(rootNode.left == null) {
				rootNode.left = insertNode;
			}
			else if(rootNode.left.data < insertNode.data) {
				//insert in the middle and return
				Node tempNode = rootNode.left;
				rootNode.left = insertNode;
				insertNode.left = tempNode;
			}
			else {
				insertNode(rootNode.left,insertNode);
			}
		}
		else {//Go to the right of the tree to insert
			if(rootNode.right == null) {
				rootNode.right = insertNode;
			}
			else if(rootNode.right.data > insertNode.data) {
				//insert in the middle and return
				Node tempNode = rootNode.right;
				rootNode.right = insertNode;
				insertNode.right = tempNode;
			}
			else {
				insertNode(rootNode.right,insertNode);
			}
		}
		
		return;
	}
	
	/*
	 * Lowest Common Ancestor in Binary Search Tree
	 * 
	 * Left side of the root are lesser than root
	 * Right side of the root are greater than root
	 */
	public Node lca(Node rootNode,int data1, int data2)
	{
		if(rootNode.data > Math.max(data1, data2))
			return lca(rootNode.left,data1,data2);
		else if(rootNode.data < Math.min(data1, data2))
			return lca(rootNode.right,data1,data2);
		else
			return rootNode;
	}
	
	public Node populateTree() {
		Node root_node = new Node(10);
		
		root_node.left = new Node(-10);
		root_node.right = new Node(30);
		

		/*
		 * Left Side of the Root Node
		 */
		root_node.left.left = new Node(-8);
		root_node.left.right = new Node(8);
		
		root_node.left.right.left = new Node(6);
		root_node.left.right.right = new Node(9);
		
		
		/*
		 * Right Side of the Root Node
		 */
		root_node.right.right = new Node(30);
		
		root_node.right.left = new Node(25);
		root_node.right.right = new Node(60);
		
		root_node.right.left.right = new Node(28);
		root_node.right.right.right = new Node(78);
		
		return root_node;
	}
	
	/*
	 * Check if the Binary tree is Binary search tree.
	 * Means, left side of the elements are smaller than the parent and it's parents as well.
	 * Similarly, right of the elements are bigger than the parent and it's parents as well.
	 * 
	 */
	public boolean isBinarySearchTree(Node rootNode, int min, int max)
	{
		
		if(rootNode == null)
			return true;
		
//		boolean leftVal = rootNode.data <= 
		
		return true;
	}
	
	public static void main(String[] args) {
		BinarySearchTree obj = new BinarySearchTree();
		Node rootNode = obj.populateTree();
		
/*		TreeTraversal trav = new TreeTraversal();
		System.out.println(trav.printTree(rootNode));
		
		System.out.println("Inserting --");
		obj.insertNode(rootNode, new Node(11));
		System.out.println(trav.printTree(rootNode));*/
		
		Node lca = obj.lca(rootNode, 78, 28);
		System.out.println("LCA :"+lca.data);
		

	}

}
