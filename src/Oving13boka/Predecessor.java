package Oving13boka;

class Predecessor{
	int distance;
	int estimatedDistance;
	Node predecessor;
	static final int unlimited = Integer.MAX_VALUE;
	
	public Predecessor() {
		distance = unlimited;
	}
	
	public int getDistance() { return distance;}
	public Node getPredecessor() {return predecessor;}
}