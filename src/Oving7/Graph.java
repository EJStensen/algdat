package Oving7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import Oving4.Stack;

public class Graph {
	int NumberOfNodes, Edges;
	Node[] node;

	class Predecessor {
		int distance;
		int prevnode;
		Node predecessor;
		static final int unlimited = 1000000000;
		
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
	
	
	/**
	 * 
	 * Read graph from file
	 * 
	 * @param br - file
	 * @throws IOException
	 */
	public void new_undirectedGraph(String filename) throws IOException {
		StringTokenizer st = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			st = new StringTokenizer(br.readLine());
			NumberOfNodes = Integer.parseInt(st.nextToken());
			node = new Node[NumberOfNodes];
			
			for (int i = 0; i < NumberOfNodes; i++) {
				node[i] = new Node();
				node[i].name = i;
			}
			
			Edges = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < Edges; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				Edge e = new Edge(node[to], node[from].edge1);
				node[from].edge1 = e;
			}
		} catch (IOException f) {
			f.printStackTrace();
		} finally {
			br.close();
		}
	}

	public void bfs(Node s) {
		initPredecessor(s);
		Queue queue = new Queue(NumberOfNodes - 1);
		queue.addToQueue(s);
		String nodes = "       Node | ";
		String pre = "Predecessor |   ";
		String dist = "   Distance | 0 ";
		System.out.print("BFS with start node "+ s.name+"\n");
		while(!queue.isEmpty()) {
			Node n = (Node)queue.nextInQueue();
			nodes += n.name+" ";
			for (Edge e = n.edge1; e != null; e = e.next) {
				Predecessor p = (Predecessor)e.to.d;
				if (p.distance == Predecessor.unlimited) {
					p.distance = ((Predecessor)n.d).distance + 1;
					p.predecessor = n;
					queue.addToQueue(e.to);
					pre += p.predecessor.name+" ";
					dist += p.distance+" ";
				}
			}
		}
		System.out.print("\n"+nodes+"\n"+pre+"\n"+dist);

	}
	
	private void initPredecessor(Node s) {
		for (int i = NumberOfNodes; i--> 0;) {
			node[i].d = new Predecessor();
		}
		((Predecessor)s.d).distance = 0;
	}
	
	public void TopologicalSort() {
		Node l = new Node();
		for (int i = NumberOfNodes; i-->0;) {
			node[i].d = new Topological();
		}
		for (int i = NumberOfNodes; i-->0;) {
			l = dfs_topological(node[i], l);
		}
		System.out.print(l.edge1.to.name);
	}
	
	private Node dfs_topological(Node n, Node l) {
		Topological ts = (Topological)n.d;
		l.name = n.name;
		if (ts.found) return l;
		ts.found = true;
		for (Edge e = n.edge1; e != null; e = e.next) l = dfs_topological(e.to, l);
		ts.next = l;
		return l;
	}
}