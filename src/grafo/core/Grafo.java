package grafo.core;

import java.util.HashSet;

public class Grafo {
	private HashSet<Node> nodes = new HashSet<Node>();
	private HashSet<Arc> arcs = new HashSet<Arc>();
	
	void insertNode(Node node) {
		nodes.add(node);
	}
	
	void insertArc(Node a, Node b, int dist) {
		a.insertAdjacent(b, dist);
		b.insertAdjacent(a, dist);
		arcs.add(new Arc(a, b, dist));
	}
	
	public HashSet<Node> getNodes() {
		return nodes;
	}
	
	public HashSet<Arc> getArcs() {
		return arcs;
	}
}
