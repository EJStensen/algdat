package Oving7;

public class Predecessor {
	int distance;
	Node predecessor;
	static int unlimited = 1000000000;
	
	public int FindDistance() {
		return distance;
	}
	
	public Node FindPredecessor() {
		return predecessor;
	}
	
	public Predecessor() {
		distance = unlimited;
	}
}
