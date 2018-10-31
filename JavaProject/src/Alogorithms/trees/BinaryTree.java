package Alogorithms.trees;

public class BinaryTree {

	/*
	 * Lowest Common Ancestor
	 */
	public Node lca(Node rootNode, int data1, int data2, boolean lcaFound, Node lcaNode)
	{
		if(rootNode == null)
			return null;
		
		if(rootNode.data == data1 || rootNode.data == data2)
			return rootNode;
		
		Node leftNode = lca(rootNode.left,data1,data2,lcaFound, lcaNode);
		Node rightNode = lca(rootNode.right,data1,data2,lcaFound, lcaNode);
		
		if(leftNode == null && rightNode == null)
			return null;
		else if(leftNode != null && rightNode != null)
			return rootNode;
		else
			return (leftNode != null) ? leftNode : rightNode;
	}
	
	public Node populateTree() {
		Node root_node = new Node(10);
		
		root_node.left = new Node(15);
		root_node.right = new Node(30);
		

		/*
		 * Left Side of the Root Node
		 */
		root_node.left.left = new Node(3);
		root_node.left.right = new Node(6);
		
		root_node.left.left.left = new Node(5);
		
		
		/*
		 * Right Side of the Root Node
		 */
		root_node.right.right = new Node(2);
		
		root_node.right.right.left = new Node(9);
		root_node.right.right.right = new Node(8);
		return root_node;
	}
	
	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		Node rootNode = obj.populateTree();
		
		Node lca = obj.lca(rootNode, 6, 5,false,null);
		System.out.println("LCA :"+lca.data);
	}
	
}
