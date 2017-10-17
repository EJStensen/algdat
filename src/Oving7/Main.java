package Oving7;

public class Main {
	public static void main(String[] args) throws Exception {
		Graph g1 = new Graph();
		g1.new_undirectedGraph("L7g1.txt");
		g1.bfs(g1.node[5]);
		
		System.out.println("\n");
		
		Graph g2 = new Graph();
		g2.new_undirectedGraph("L7g5.txt");
		g2.TopologicalSort();
	}
}