package Oving13;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
			Graph g = new Graph();
			g.new_graph("skandinavia-noder.txt", "skandinavia-kanter.txt");
			
			long startD = System.currentTimeMillis();
			ArrayList<Node> res1 = g.dijkstra(g.node[347370], g.node[143917]); //Trondheim(347370)-Bodø(62534)
			long endD = System.currentTimeMillis();
			System.out.println("Time used(Dijkstra): "+(endD-startD)+" ms");
			System.out.println("Nodes between destinations (Dijkstra): "+res1.size());			

			long startA = System.currentTimeMillis();
			ArrayList<Node> res2 = g.a_star(g.node[347370], g.node[143917]); //Trondheim(347370)-Bodø(62534)
			long endA = System.currentTimeMillis();
			System.out.println("Time used(A*): "+(endA-startA)+" ms");
			System.out.println("Nodes between destinations (A*): "+res2.size());
			
			//lat-long for dijkstra
			/*
			for (int i = 0; i < res1.size(); i++) {
				System.out.println(res1.get(i).latitude+", "+res1.get(i).longitude);
			}
			*/
			
			//lat-long for A*
			/*
			for (int i = 0; i < res2.size(); i++) {
				System.out.println(res2.get(i).latitude+", "+res2.get(i).longitude);
			}
			*/
			
	}
}
