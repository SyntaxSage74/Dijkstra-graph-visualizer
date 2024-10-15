package grafo.core;

public class Prop {
	private Node previous;
	private int dist;
	private boolean visited;
	
	public Prop() {
		previous = null;
		dist = Integer.MAX_VALUE;
		visited = false;
	}

	public Node getPrevious() {
		return previous;
	}

	public int getDist() {
		return dist;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
