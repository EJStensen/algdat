package Oving8;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Graph g = new Graph();
		g.new_directedGraph("vg1.txt");
		g.dijkstra(g.node[0]);
	}
}
