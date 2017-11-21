package Oving13boka;

class VEdge extends Edge{
	int time;
	
	public VEdge(Node n, VEdge nxt, int time) {
		super(n, nxt);
		this.time = time;
	}
}
