package grafo.core;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Window {
	private String title;
	private int width, height;
	
	private JFrame frame;
	
	public Window(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		init();
	}
	
	private void init() {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
	}
	
	public void setMenuBar(JMenuBar menuBar) {
		frame.setJMenuBar(menuBar);
	}
	
	public void add(Component... components) {
		for(Component component : components) 
			frame.add(component);
	}
	
	public void addContentPane(Component component, String layout) {
		frame.getContentPane().add(component, layout);
	}
	
	public void refresh() {
		frame.repaint();
	}
	
	public void run() {
		frame.setVisible(true);
	}

}
