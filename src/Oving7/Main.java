package Oving7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception {
		Graph g = new Graph();
		BufferedReader br = null;
		File file = null;
		try {
			file = new File("L7g1.txt");
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (br != null) {
			g.new_undirectedGraph(br);
			//g.testskit();
			//g.bfs(g.node[0]);
			System.out.println(g.TopologicalSort().edge1.to.name);
		} else {
			System.out.println("kek");
		}
	}
}
