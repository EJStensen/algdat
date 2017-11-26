package Oving13;

class Predecessor{
	int distance;
	int estimatedDistance;
	int visited;
	Node predecessor;
	static final int unlimited = Integer.MAX_VALUE;
	
	public Predecessor() {
		distance = unlimited;
		visited = 0;
	}
	
	public int getDistance() { return distance;}
	public Node getPredecessor() {return predecessor;}
}