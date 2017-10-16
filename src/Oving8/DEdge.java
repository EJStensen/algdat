package Oving8;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

import Oving7.Edge;
import Oving7.Node;

public class DEdge extends Edge {
	int distance;
	public DEdge(Node n, DEdge nxt, int dis) {
		super(n, nxt);
		distance = dis;
	}
	
	public void new_directedGraph(BufferedReader br){
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
