package grafo.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.HashMap;

import grafo.settings.ApplicationSettings;
import grafo.settings.NodeSpecification;

public class Node implements NodeSpecification{
	private String name;
	private int x, y;
	private Color color;
	private HashMap<Node, Integer> adjacents = new HashMap<Node, Integer>();

	public Node(String name, int xPos, int yPos) {
		this.name = name;
		this.x = xPos;
		this.y = yPos;
		this.color = ApplicationSettings.PALETTE_GRAY;
	}

	void draw(Graphics2D g2d) {
		Font font = new Font("Sans Serif", Font.BOLD, 12);
		g2d.setFont(font);
		FontMetrics fm = g2d.getFontMetrics();
		if(name != null) {
			int larghezzaTesto = fm.stringWidth(name);

			g2d.setColor(color);
			g2d.drawString(name, x - larghezzaTesto / 2, y - RADIUS / 2 - Y_OFFSET);
			g2d.setColor(color);
			g2d.fillOval(x - RADIUS / 2, y - RADIUS / 2, RADIUS, RADIUS);
		}
	}
	
	public void insertAdjacent(Node node, int dist) {
		adjacents.put(node, dist);
	}
	
	public boolean isSelected(int dx, int dy) {
		int distanceX = dx - x;
		int distanceY = dy - y;
		int distanceSquared = distanceX * distanceX + distanceY * distanceY;
		int radiusSquared = RADIUS * RADIUS;
		return distanceSquared <= radiusSquared;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}
}
