package Oving13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Graph {
	int N, E;
	Node[] node;
	
	public void new_graph(String nodes, String edges) throws IOException {
		StringTokenizer st = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(nodes)));
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			node = new Node[N];
			String line;
			int nodeNumber;
			while ((line = br.readLine()) != null) {
				st = new StringTokenizer(line);
				nodeNumber = Integer.parseInt(st.nextToken());
				node[nodeNumber] = new Node();
				node[nodeNumber].latitude = Double.parseDouble(st.nextToken());
				node[nodeNumber].longitude = Double.parseDouble(st.nextToken());
				node[nodeNumber].cos_bredth = Math.cos(node[nodeNumber].latitude);
			}
			System.out.println("Nodes read");
			br = new BufferedReader(new FileReader(new File(edges)));
			st = new StringTokenizer(br.readLine());
			E = Integer.parseInt(st.nextToken());
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				VEdge e = new VEdge(node[to], (VEdge)node[from].edge1, time);
				node[from].edge1 = e;
			}
			System.out.println("Edges read");
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}
	
	public ArrayList<Node> dijkstra(Node fromNode, Node toNode){
		int count = 0;
		
		init_predecessor(fromNode);
		Heap heap = new Heap(true);
		heap.insert(fromNode);
		
		while(!heap.isEmpty()) {
			Node current = heap.extractMin();
			count++;
			((Predecessor)current.d).visited = -1;
			
			for (VEdge e = (VEdge)current.edge1; e != null; e = (VEdge)e.next) abbreviate(current, null, e, true);
			
			Edge next = current.edge1;
			
			while(next != null) {
				if (((Predecessor)next.to.d).visited == 0) {
					heap.insert(next.to);
					((Predecessor)next.to.d).visited = -1;
				}
				next = next.next;
			}
			
			if (current == toNode) {
				ArrayList<Node> route = new ArrayList<Node>();
				
				while (current != null && ((Predecessor)current.d).distance != 0) {
					route.add(((Predecessor)current.d).predecessor);
					current = ((Predecessor)current.d).predecessor;
				}
				
				System.out.println("Nodes processed for dijkstra: "+count);
				return route;
			}
		}
		return null;
	}

	public ArrayList<Node> a_star(Node fromNode, Node toNode){
		int count = 0;
		
		init_predecessor(fromNode);
		Heap heap = new Heap(false);
		heap.insert(fromNode);
		
		while (!heap.isEmpty()) {
			Node current = heap.extractMin();
			count++;
			((Predecessor)current.d).visited = -1;
			
			for (VEdge e = (VEdge)current.edge1; e != null; e = (VEdge)e.next) abbreviate(current, toNode, e, false);
			
			Edge next = current.edge1;
			
			while(next != null) {
				if (((Predecessor)next.to.d).visited == 0) {
					heap.insert(next.to);
					((Predecessor)next.to.d).visited = -1;
				}
				next = next.next;
			}
			
			if (current == toNode) {
				ArrayList<Node> route = new ArrayList<Node>();
				
				while (current != null && ((Predecessor)current.d).distance != 0) {
					route.add(((Predecessor)current.d).predecessor);
					current = ((Predecessor)current.d).predecessor;
				}
				
				System.out.println("Nodes processed for A*: "+count);
				return route;
			}
		}
		return null;
	}
	
	public void abbreviate(Node n, Node toNode, VEdge e, boolean algorithm) {
		Predecessor nd = (Predecessor)n.d, md = (Predecessor)e.to.d;
		if (algorithm == true) {
			if (md.distance > nd.distance + e.time) {
				md.distance = nd.distance + e.time;
				md.predecessor = n;
			}
		} else {
			if (md.distance > nd.distance + e.time) {
				md.distance = nd.distance + e.time;
				md.estimatedDistance = md.distance + estimateDistance(e.to, toNode);
				md.predecessor = n;
			}
		}
	}
	
	private int estimateDistance(Node n1, Node n2) {
		double sin_length = Math.sin(((2*Math.PI/360)*(n1.latitude - n2.latitude))/2.0);
		double sin_width = Math.sin(((2*Math.PI/360)*(n1.longitude - n2.longitude))/2.0);
		return (int) (41701090.90909090909090909091*
				Math.asin(Math.sqrt(sin_width*sin_width+n1.cos_bredth*n2.cos_bredth*sin_length*sin_length)));
	}
	
	private void init_predecessor(Node s) {
		for (int i = N; i --> 0;) {
			node[i].d = new Predecessor();
		}
		((Predecessor)s.d).distance = 0;
	}
}
