package Oving13boka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		BufferedReader nodes = null;
		BufferedReader edges = null;
		
		try {
			nodes = new BufferedReader(new FileReader(new File("albania-noder.txt")));
			edges = new BufferedReader(new FileReader(new File("albania-kanter.txt")));
			Graph g = new Graph();
			g.new_graph(nodes, edges);
			nodes.close();
			edges.close();
			
			ArrayList<Node> res1 = g.dijkstra(g.node[0], g.node[567]);	
			System.out.println(res1.size());
			
			for (int i = 0; i < res1.size(); i++) {
				System.out.println(res1.get(i).latitude+", "+res1.get(i).longitude);
			}
			//System.out.println("Estimated time to drive from start to finish: "+g.EstimatedDriveTime(g.node[0], g.node[567]));
			
			//ArrayList<Node> res2 = g.a_star(g.node[0], g.node[567]);
			//System.out.println(res2.size());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
