package Alogorithms.networks_graphs.interviews.impl_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;

import Alogorithms.networks_graphs.interviews.api_service.Edge;
import Alogorithms.networks_graphs.interviews.api_service.Node;


public class ReadTxnService implements Callable<Node>{

	private Node root_node;
	private String target_nodeId;
	
	private Stack<Node> stack = new Stack<>();
	List<String> traversedNodeIds = new ArrayList<>();
	
	public ReadTxnService(Node node, String nodeId) {
		this.root_node = node;
		this.target_nodeId = nodeId;
	}
	
	@Override
	/*
	 * Depth First traversal
	 */
	public Node call() throws Exception 
	{
		Node resultNode = null;
		if(root_node == null || target_nodeId == null) //Log the Error
			return resultNode;
		
		//Clear the traversed Node Ids
		traversedNodeIds.clear();
				
		if(root_node.getId().equals(target_nodeId))
			return root_node;
				
		stack.push(root_node);
		while(!stack.empty()) {
			Node node = stack.pop();
			for(Edge edge : node.getEdges()) {
				Node childNode = edge.getToNode();
						
				if(childNode.getId().equals(target_nodeId)) {
					resultNode = childNode;
					break;
				}
							
				if(!traversedNodeIds.contains(childNode.getId())) {
					traversedNodeIds.add(childNode.getId());
					stack.push(childNode);
				}
			}
		}
		
		return resultNode;
	}
}
