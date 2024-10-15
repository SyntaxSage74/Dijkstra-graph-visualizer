package grafo.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private Grafo grafo;

	private Node startingNode;
	private Node endingNode;
	private Node startingNodeSelected, endingNodeSelected;

	public DrawingPanel(Grafo grafo) {
		this.grafo = grafo;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for(Node node : grafo.getNodes()) {
			node.draw(g2d);
		}
		
		for(Arc arc : grafo.getArcs()) {
			arc.draw(g2d);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Node node : grafo.getNodes()) {
			if (node.isSelected(e.getX(), e.getY())) {
				if(startingNodeSelected == null) {
					startingNodeSelected = node;
					node.setColor(Color.GREEN);
				} else if(endingNodeSelected == null) {
					endingNodeSelected = node;
					node.setColor(Color.RED);
				}
				this.repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		for (Node node : grafo.getNodes()) {
			if (node.isSelected(e.getX(), e.getY())) {
				startingNode = node;
				return;
			}
		}

		String nodeName = new JOptionPane().showInputDialog(null, "Inserisci il nome del nodo:");
		Node newNode = new Node(nodeName, e.getX(), e.getY());
		grafo.insertNode(newNode);				
		
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(startingNode != null) {
			for (Node node : grafo.getNodes()) {
				if (node.isSelected(e.getX(), e.getY()) && node != startingNode) {
					String weight = new JOptionPane().showInputDialog(null, "Inserisci il peso:");
					
					endingNode = node;
					
					if(weight != null && !weight.isBlank() && !weight.isEmpty())
						grafo.insertArc(startingNode, endingNode, Integer.parseInt(weight));
					
					this.repaint();
					return;
				}
			}
		}
		
		startingNode = null;
		endingNode = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseDragged(MouseEvent e) {
		if((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
			if(startingNode != null) {
				startingNode.setX(e.getX());
				startingNode.setY(e.getY());;
			}
		}
		
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

}
