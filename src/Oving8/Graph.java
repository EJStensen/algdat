package Oving8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Graph {
	int NumberOfNodes, Edges;
	Node[] node;

	class Predecessor {
		int distance;
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

	public class DEdge extends Edge {
		int distance;
		int weight;
		public DEdge(Node n, DEdge nxt, int w) {
			super(n, nxt);
			weight = w;
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
	
	public void new_directedGraph(String filename) throws IOException {
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
				int weight = Integer.parseInt(st.nextToken());
				DEdge e = new DEdge(node[to], (DEdge)node[from].edge1, weight);
				node[from].edge1 = e;
			}
		} catch (IOException f) {
			f.printStackTrace();
		} finally {
			br.close();
		}
	}
	
	public void dijkstra(Node s) {
		initPredecessor(s);
		Heap h = new Heap(node);
		h.make_heap();
		System.out.print(h.get_max());
		/*
		for (int i = NumberOfNodes; i > 1; i--) {
			Node n = h.get_min(i, h);
			for (DEdge e = (DEdge)n.edge1; e != null; e = (DEdge)e.next) {
				shorten(n, e);
			}
		}
		*/
	}
	
	public void shorten(Node n, DEdge e) {
		Predecessor p1 = (Predecessor)n.d, p2 = (Predecessor)e.to.d;
		if (p2.distance > p1.distance + e.weight) {
			p2.distance = p1.distance + e.weight;
			p2.predecessor = n;
		}
	}
	
	private void initPredecessor(Node s) {
		for (int i = NumberOfNodes; i--> 0;) {
			node[i].d = new Predecessor();
		}
		((Predecessor)s.d).distance = 0;
	}
	
}