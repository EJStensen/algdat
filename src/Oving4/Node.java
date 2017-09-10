package Oving4;

class Node {
	
	private double element;
	private Node next;
	private Node previous;
	
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
	public Node(double e, Node n){
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
	
	public Node(double e, Node n, Node p) {
		element = e;
		next = n;
		previous = p;
	}
	
	public double getElement() {
		return element;
	}
	
	public Node getNextNode() {
		return next;
	}
	
	public Node getPreviousNode() {
		return previous;
	}
	
	public void setElement(double e) {
		element = e;
	}
	
	public void setNextNode(Node n) {
		next = n;
	}
	
	public void setPreviousNode(Node p) {
		previous = p;
	}
}