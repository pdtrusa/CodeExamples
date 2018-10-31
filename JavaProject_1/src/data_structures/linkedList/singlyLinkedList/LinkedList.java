package data_structures.linkedList.singlyLinkedList;

public class LinkedList {
	Node head;
	
	public void insetAtEnd(int nodeData) {
		Node insertedNode = new Node(nodeData);
		if(head == null) {
			head = insertedNode;
			head.setNext(null);
		}
		else {
			Node traverseNode = head;
			while(traverseNode.getNext() != null) {
				traverseNode = traverseNode.getNext();
			}
			traverseNode.setNext(insertedNode);
		}
	}
	
	public void insertAtStart(int newData) {
		Node insertedNode = new Node(newData);
		if(head == null) {
			head = insertedNode;
			head.setNext(null);
		}
		else {
			insertedNode.setNext(head);
			head = insertedNode;
		}
	}
	
	public void insertAt(int index, int data) {
		Node insertedNode = new Node(data);
		
		int size = size();
		if(index > size || index < 0) {
			System.err.println("Index out of bound Error");
		}
		
		if(index == 0) {
			insertAtStart(data);
			return;
		}
		
		int i= 0;
		Node prevNode = null;
		Node indexedNode = head;
		
		while(i <= index-1) {
			prevNode = indexedNode;
			indexedNode = indexedNode.getNext();
			i++;
		}
		
		prevNode.setNext(insertedNode);
		insertedNode.setNext(indexedNode);
	}
	
	public void deleteAt(int index) {
		if(index==0) {
			head = head.next;
			return;
		}
		
		Node prevNode = null;
		Node indexedNode = head;
		for(int i=0; i<index; i++) {
			prevNode = indexedNode;
			indexedNode = indexedNode.getNext();
		}
		prevNode.next = indexedNode.next;
		indexedNode = null;
	}
	
	public int size() {
		int size = 0;
		if(head == null)
			return size;
		
		Node travNode = head;
		while(travNode.getNext()!=null) {
			travNode = travNode.getNext();
			size++;
		}
		
		return size++;
	}
	
	
	public void printList() {
		Node travNode = head;
		while(travNode.getNext() != null) {
			System.out.println("Value :"+travNode.getData());
			travNode = travNode.getNext();
		}
		System.out.println("Value :"+travNode.getData());
		System.out.println("---------------------");
	}
	
	public static void main(String[] args) {
		System.out.println("Linked List Info");
		
		LinkedList linkedList = new LinkedList();
		linkedList.insetAtEnd(1);
		linkedList.insetAtEnd(2);
		linkedList.insetAtEnd(3);
		
		linkedList.printList();
				
		linkedList.insertAtStart(101);
		linkedList.printList();
		
		linkedList.insertAtStart(102);
		linkedList.printList();
		
		linkedList.insertAt(3, 201);
		linkedList.printList();
		
		linkedList.deleteAt(3);
		linkedList.printList();
	}
}
