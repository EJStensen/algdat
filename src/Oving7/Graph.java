package Oving7;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph {
	int Nodes, Edges;
	Node[] node;

	class Predecessor {
		int distance;
		int namep;
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
	public void new_undirectedGraph(BufferedReader br) throws IOException {
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
			Nodes = Integer.parseInt(st.nextToken());
			node = new Node[Nodes];
			for (int i = 0; i < Nodes; i++) {
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
			br.close();
		} catch (IOException f) {
			f.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param s - Start node
	 */
	public void bfs(Node s) {
		initPredecessor(s);
		Queue queue = new Queue(Nodes - 1);
		queue.addToQueue(s);
		while(!queue.isEmpty()) {
			Node n = (Node)queue.nextInQueue();
			System.out.println(n.name);
			for (Edge e = n.edge1; e != null; e = e.next) {
				Predecessor p = (Predecessor)e.to.d;
				System.out.println(p.distance);
				if (p.distance == Predecessor.unlimited) {
					p.distance = ((Predecessor)n.d).distance + 1;
					p.predecessor = n;
					queue.addToQueue(e.to);
				}
			}
		}
	}
	
	private void initPredecessor(Node s) {
		for (int i = Nodes; i-- > 0;) {
			node[i].d = new Predecessor();
		}
		((Predecessor)s.d).distance = 0;
	}
	
	public Node TopologicalSort() {
		Node l = null;
		for (int i = Nodes; i-->0;) {
			node[i].d = new Topological();
		}
		for (int i = Nodes; i-->0;) {
			l = df_topo(node[i], l);
			System.out.println(l);
		}
		return l;
	}
	
	private Node df_topo(Node n, Node l) {
		Topological ts = (Topological)n.d;
		if (ts.found) return l;
		ts.found = true;
		for (Edge e = n.edge1; e != null; e = e.next) {
			l = df_topo(e.to, l);
		}
		ts.next = l;
		return n;
	}
	
	public void testskit() {
		for (int i = 0; i < node.length; i++) {
			System.out.println();
		}
	}
}