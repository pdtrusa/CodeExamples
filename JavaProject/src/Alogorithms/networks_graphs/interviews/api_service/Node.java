package Alogorithms.networks_graphs.interviews.api_service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
	protected String type;
	protected String id;
	
	protected Map<String,Object> attrs = new HashMap<>();
	protected List<Edge> edges = new ArrayList<>();
	List<VersionNode> version_Nodes = new ArrayList<>();
	
	public Node(String type, String id) {
		this.type = type;
		this.id = id;
		this.attrs.clear();
	}
	
	public Node(String type, String id, Map<String,Object> attrs) {
		this.type = type;
		this.id = id;
		this.attrs.putAll(attrs);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getAttrs() {
		return attrs;
	}

	public void setAttrs(Map<String, Object> attrs) {
		this.attrs = attrs;
	}
	
	public void setAttrs(Map<String, Object> attrs,boolean replaceAll) {
		if(replaceAll)
			this.attrs.clear();
		this.attrs.putAll(attrs);
	}
	
	public void updateAttr(String key, Object val) {
		this.attrs.put(key, val);
	}
	
	public void updateAttrs(Map<String,Object> attrs) {
		attrs.forEach((k,v) -> this.attrs.put(k,v));
	}
	
	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public void addEdge(Edge edge) {
		if(edge != null)
			this.edges.add(edge);
	}

	public List<VersionNode> getVersion_Nodes() {
		return version_Nodes;
	}

	public void setVersion_Nodes(List<VersionNode> previous_version_Nodes) {
		this.version_Nodes = previous_version_Nodes;
	}
	
	public void addVersionNode(VersionNode versionNode) {
		this.version_Nodes.add(versionNode);
	}

	private String getVersions() {
		StringBuffer buff = new StringBuffer();
		
		List<VersionNode> versionNodes = getVersion_Nodes();
		for(int i=0; i<versionNodes.size();i++)
			buff.append("##Version:"+(i+1)+"##\n"+versionNodes.get(i)+"\n------\n");
			
		
		return buff.toString();
	}
	@Override
	public String toString() {
		return "Node [type=" + type + ", id=" + id + ", attrs=" + attrs
				+ ", edges=" + edges +"\n"+ getVersions(); 
//				"]";
	}
}
