package Oving13boka;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Graph {
	int N, E;
	Node[] node;
	
	public void new_graph(BufferedReader nodefile, BufferedReader edgefile) throws IOException {
		StringTokenizer st = null;
		
		try {
			st = new StringTokenizer(nodefile.readLine());
			N = Integer.parseInt(st.nextToken());
			node = new Node[N];
			String line;
			int nodeNumber;
			while ((line = nodefile.readLine()) != null) {
				st = new StringTokenizer(line);
				nodeNumber = Integer.parseInt(st.nextToken());
				node[nodeNumber] = new Node();
				node[nodeNumber].latitude = Double.parseDouble(st.nextToken());
				node[nodeNumber].longitude = Double.parseDouble(st.nextToken());
				node[nodeNumber].cos_bredth = Math.cos(node[nodeNumber].latitude);
			}
			st = new StringTokenizer(edgefile.readLine());
			E = Integer.parseInt(st.nextToken());
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(edgefile.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				VEdge e = new VEdge(node[to], (VEdge)node[from].edge1, time);
				node[from].edge1 = e;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void abbreviate(Node n, VEdge e) {
		Predecessor nd = (Predecessor)n.d, md = (Predecessor)e.to.d;
		if (md.distance > (nd.distance + e.time)) {
			md.distance = (nd.distance + e.time);
			md.predecessor = n;
		}
	}
	
	public void abbreviate1(Node n, VEdge e, Node goal) {
		Predecessor nd = (Predecessor)n.d, md = (Predecessor)e.to.d;
		if (md.distance > (nd.distance + e.time)) {
			md.distance = nd.distance + e.time;
			md.estimatedDistance = md.distance + haversine_formula(e.to, goal);
			md.predecessor = n;
		}
	}
	
	public ArrayList<Node> dijkstra(Node fromNode, Node toNode){
		init_predecessor(fromNode);
		Node[] temp = new Node[N];
		make_priko(temp);
		for (int i = N; i > 1; i--) {
			Node current = get_min(i, temp);
			for (VEdge e = (VEdge)current.edge1; e != null; e = (VEdge)e.next) abbreviate(current, e);
			if (current == toNode) {
				ArrayList<Node> route = new ArrayList<Node>();
				while (current != null && ((Predecessor)current.d).distance != 0) {
					route.add(((Predecessor)current.d).predecessor);
					current = ((Predecessor)current.d).predecessor;
				}
				return route;
			}
		}
		return null;
	}
	/*
	public ArrayList<Node> a_star(Node fromNode, Node toNode){
		init_predecessor(fromNode);
		MinHeap h = new MinHeap();
		h.insert(fromNode);
		while (!h.isEmpty()) {
			Node current = h.extractMin();
			for (VEdge e = (VEdge)current.edge1; e != null; e = (VEdge)e.next) abbreviate1(current, e, toNode);
			Edge next = current.edge1;
			while (next != null) {
				if (!h.contains(next.to)) {
					((Predecessor)next.to.d).estimatedDistance = haversine_formula(next.to, toNode);
					h.insert(next.to);
				}
				next = next.next;
			}
			if (current == toNode) {
				ArrayList<Node> route = new ArrayList<Node>();
				current = toNode;
				while (current != null && ((Predecessor)current.d).distance != 0) {
					route.add(((Predecessor)current.d).predecessor);
					current = ((Predecessor)current.d).predecessor;
				}
				return route;
			}
		}
		return null;
	}
	*/
	
	
	private void init_predecessor(Node s) {
		for (int i = N; i --> 0;) {
			node[i].d = new Predecessor();
		}
		((Predecessor)s.d).distance = 0;
	}
	
	public int EstimatedDriveTime (Node n1, Node n2) {
		double sin_bredde = Math.sin((n1.latitude-n2.latitude)/2.0);
		double sin_lengde = Math.sin((n1.longitude-n2.longitude)/2.0);
		return (int) (41701090.90909090909090909091*Math.asin(Math.sqrt(
		sin_bredde*sin_bredde+n1.cos_bredth*n2.cos_bredth*sin_lengde*sin_lengde)));
		}
	
	private int haversine_formula(Node node1, Node node2) {
		double lat1 = (2*Math.PI*node1.latitude)/360;
		double lat2 = (2*Math.PI*node2.latitude)/360;
		double long1 = (2*Math.PI*node1.longitude)/360;
		double long2 = (2*Math.PI*node2.longitude)/360;
		return (int) ((2*6371000)*Math.asin((Math.sqrt((Math.sin((lat1-lat2)/2)*Math.sin((lat1-lat2)/2))+
				     Math.cos(lat1)*Math.cos(lat2)*(Math.sin((long1-long2)/2)*Math.sin((long1-long2)/2))))));
	}
	
	private void make_priko(Node[] s) {
		for (int i = 0; i < N; i++) {
			s[i] = node[i];
		}
	}
	
	private Node get_min(int a, Node[] t) {
		int min = 0;
		for (int i = a; --i > 0;) {
			if (((Predecessor)t[i].d).distance < ((Predecessor)t[min].d).distance) min = i;
		}
		Node temp = t[min];
		t[min] = t[a - 1];
		return temp;
	}
}
