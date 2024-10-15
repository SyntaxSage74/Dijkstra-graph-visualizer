package grafo.core;

import java.util.HashMap;
import java.util.Map.Entry;

public class Djikstra {
	private Grafo grafo;
	private HashMap<Node, Prop> table = new HashMap<Node, Prop>();
	private Node start, end;
	
	public Djikstra(Grafo grafo, Node start, Node end) {
		this.grafo = grafo;
		this.start = start;
		this.end = end;
		
		for(Node node : grafo.getNodes()) {
			table.put(node, new Prop());
		}
		
		table.get(start).setDist(0);
	}
	
	private Node getShorterDist() {
		Node temp = null;
		int distMin = Integer.MAX_VALUE;
		for(Entry<Node, Prop> e : table.entrySet()) {
			Node node = e.getKey();
			Prop prop = e.getValue();
			int dist = prop.getDist();
			if(dist < distMin && !prop.isVisited()) {
				temp = node;
				distMin = dist;
			}
		}

		return temp;
	}
	
	void percorso() {
		System.out.println("--------------------------------------------------");
		table.get(start).setDist(0);
		Node attuale = getShorterDist();
		System.out.println("Nodo a distanza minore: " + attuale);
	}
}
