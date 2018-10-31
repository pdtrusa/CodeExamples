package Alogorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
	

	/*
	 * Visit(Print) the Node -> Go to Left -> Go to Right
	 */
	public void pre_Order_traversal(Node node,StringBuffer buff)
	{
		if(node != null) {
			buff.append(node.getData()).append(" , ");
			pre_Order_traversal(node.left,buff);
			pre_Order_traversal(node.right,buff);
		}
	}
	
	/*
	 * Go to Left ->  Visit(Print) the Node ->Go to Right
	 */
	public void inOrder_traversal(Node node,StringBuffer buff)
	{
		if(node != null) {
			inOrder_traversal(node.left,buff);
			buff.append(node.getData()).append(" , ");
			inOrder_traversal(node.right,buff);
		}
	}
	

	/*
	 * Go to Left ->  Go to Right -> Visit(Print) the Node
	 */
	public void post_Order_traversal(Node node,StringBuffer buff)
	{
		if(node != null) {
			post_Order_traversal(node.left,buff);
			post_Order_traversal(node.right,buff);
			buff.append(node.getData()).append(" , ");
		}
	}
	
	/*
	 * Breath First Traversal
	 */
	public void level_order_traversal(Node root_node, StringBuffer buff)
	{
		Queue<Node> queue = new LinkedList<>();
		queue.add(root_node);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node != null) {
				buff.append(node.getData()).append(" , ");
				queue.add(node.left);
				queue.add(node.right);
			}
		}
	}
	
	/*
	 * Breath First Traversal
	 * From the bottom
	 */
	public void level_order_traversal_reversal(Node root_node, StringBuffer buff)
	{
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(root_node);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node != null) {
				stack.push(node);
				buff.append(node.getData()).append(" , ");
				if(node.right != null)
					queue.offer(node.right);
				if(node.left != null)
					queue.offer(node.left);
			}
		}
		buff.append("\n ----- Printing in Reverse Order -----\n");
		while(!stack.isEmpty())
			buff.append(stack.pop().getData()).append(" , ");
	}
	
	public void level_order_traversal_spiral(Node root_node, StringBuffer buff)
	{
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(root_node);
		while(!stack1.isEmpty()) {
			while(!stack1.isEmpty()) {
				Node node = stack1.pop();
				buff.append(node.getData()).append(" , ");
				if(node.left != null)
					stack2.push(node.left);
				if(node.right != null)
					stack2.push(node.right);
			}
			
			while(!stack2.isEmpty()) {
				Node node2 = stack2.pop();
				buff.append(node2.getData()).append(" , ");
				if(node2.right != null)
					stack1.push(node2.right);
				if(node2.left != null)
					stack1.push(node2.left);
			}
		}
		
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
	
	public String printTree(Node rootNode) {
		StringBuffer buff = new StringBuffer();
		pre_Order_traversal(rootNode, buff);
		return buff.toString();
	}
	
	public int sizeOfTree(Node rootNode)
	{
		Stack<Node> stack = new Stack<>();
		
		stack.push(rootNode);
		int count = 0;
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.data);
			count++;
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		
		return count;
	}
	
	public int heightOfTree(Node rootNode)
	{
		if(rootNode == null)
			return 0;
		
		int temp1 = heightOfTree(rootNode.left);
		int temp2 = heightOfTree(rootNode.right);
		
		int heightAtLeaf = 1 + Math.max(temp1, temp2);
		return heightAtLeaf; 
	}
	
	/*
	 * Should traverse till the leave node.
	 * If the sum is matched by the middle nodes, it is not valid root-to-leaf scenario
	 */
	public boolean root_to_leaf_sum(Node rootNode, int sum, ArrayList<Node> pathNodes)
	{
		if(rootNode == null) {
			return (sum==0);
		}
			
/*		if(rootNode.data == sum) {
			pathNodes.add(rootNode);
			return true;
		}*/
		else if(rootNode.data > sum)
			return false;
		else {
			int remainingSum = sum-rootNode.data;
			boolean leftRes = root_to_leaf_sum(rootNode.left, remainingSum, pathNodes);
			boolean rightRes = root_to_leaf_sum(rootNode.right, remainingSum, pathNodes);
			if(leftRes || rightRes)
				pathNodes.add(rootNode);
			
			return leftRes || rightRes;
		}
	}
	
	public static void main(String[] args) {
		TreeTraversal obj  = new TreeTraversal();
		Node rootNode = obj.populateTree();
		
	/*	System.out.println("PRE ORDER TRAVERSAL--");
		StringBuffer buff = new StringBuffer();
		obj.pre_Order_traversal(rootNode, buff);
		System.out.println(buff.toString());
		
		System.out.println("--------------");
		System.out.println("IN ORDER TRAVERSAL--");
		buff = new StringBuffer();
		obj.inOrder_traversal(rootNode, buff);
		System.out.println(buff.toString());
		
		System.out.println("--------------");
		System.out.println("POST ORDER TRAVERSAL--");
		buff = new StringBuffer();
		obj.post_Order_traversal(rootNode, buff);
		System.out.println(buff.toString());*/
		
		/*System.out.println("LEVEL ORDER TRAVERSAL--");
		StringBuffer buff = new StringBuffer();
		obj.level_order_traversal(rootNode, buff);
		System.out.println(buff.toString());*/
		
		/*System.out.println("LEVEL ORDER TRAVERSAL From Bottom Up--");
		StringBuffer buff = new StringBuffer();
		obj.level_order_traversal_reversal(rootNode, buff);
		System.out.println(buff.toString());
		*/
		System.out.println("LEVEL ORDER TRAVERSAL From Bottom Up--");
		StringBuffer buff = new StringBuffer();
		obj.level_order_traversal_spiral(rootNode, buff);
		System.out.println(buff.toString());
		
	/*	System.out.println("Count of Nodes :"+obj.sizeOfTree(rootNode));
		System.out.println("Count of Nodes :"+obj.heightOfTree(rootNode));*/
		
		/*ArrayList<Node> pathNodes = new ArrayList<>();
		boolean res = obj.root_to_leaf_sum(rootNode, 25, pathNodes);
		if(res) {
			pathNodes.forEach(i->
							{System.out.println(i.data);});
		}*/
		
		
	}

}
