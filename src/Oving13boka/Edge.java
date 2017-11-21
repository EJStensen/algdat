package Oving13boka;

class Edge {
	Edge next;
	Node to;
	
	public Edge(Node n, Edge nxt) {
		to = n;
		next = nxt;
	}
}
