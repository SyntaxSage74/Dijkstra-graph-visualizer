package grafo.core;

import java.awt.Graphics2D;

public class Arc {
	private Node nodeA, nodeB;
	private int dist;

	public Arc(Node nodeA, Node nodeB, int dist) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.dist = dist;
	}

	public void draw(Graphics2D g2d) {
		if(nodeA != null && nodeB != null) {
			int centerX = (nodeA.getX() + nodeB.getX()) / 2;
			int centerY = (nodeA.getY() + nodeB.getY()) / 2;
			g2d.drawString(String.valueOf(dist), centerX, centerY);
			g2d.drawLine(nodeA.getX(), nodeA.getY(), nodeB.getX(), nodeB.getY());
		}
	}
}
