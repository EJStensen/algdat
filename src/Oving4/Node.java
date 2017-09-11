package Oving4;

class Node {
	
	private int element;
	private Node next;
	private Node previous;
	
	/**
	 * Constructor without parameters
	 */
	public Node() {
		element = 0;
		next = null;
		previous = null;
	}
	
	/**
	 * Constructor for circular single linked list
	 * 
	 * @param e
	 * @param n
	 */
	public Node(int e, Node n){
		element = e;
		next = n;
	}
	
	/**
	 * Constructor for circular double linked list
	 * 
	 * @param e
	 * @param n
	 * @param p
	 */
	
	public Node(int e, Node n, Node p) {
		element = e;
		next = n;
		previous = p;
	}
	
	public int getElement() {
		return element;
	}
	
	public Node getNextNode() {
		return next;
	}
	
	public Node getPreviousNode() {
		return previous;
	}
	
	public void setElement(int e) {
		element = e;
	}
	
	public void setNextNode(Node n) {
		next = n;
	}
	
	public void setPreviousNode(Node p) {
		previous = p;
	}
}