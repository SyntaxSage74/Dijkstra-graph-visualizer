package grafo.entry;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import grafo.core.DrawingPanel;
import grafo.core.Grafo;
import grafo.core.Window;
import grafo.settings.ApplicationSettings;

public class EntryPoint {
	private static boolean playSelected = false;
	private static boolean pauseVisible = false;

	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
		    ex.printStackTrace();
		}
		
		Grafo grafo = new Grafo();

		Window window = new Window("Grafo", 1080, 620);

		JToolBar toolBar = new JToolBar();
		toolBar.setLayout(new FlowLayout());
		toolBar.setPreferredSize(new Dimension(toolBar.getWidth(), 45));
		toolBar.setBackground(ApplicationSettings.PALETTE_BLACK);
		toolBar.setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(ApplicationSettings.PALETTE_DARK_BLUE, 1);
		toolBar.setBorder(border);
		
		ImageIcon playIcon = new ImageIcon("icons/PlayButton.png");
		ImageIcon pauseIcon = new ImageIcon("icons/PauseButton.png");
		ImageIcon stopIcon = new ImageIcon("icons/StopButton.png");
		
		JButton playButton = new JButton();
		JButton pauseButton = new JButton();
		pauseButton.setVisible(false);
		
		playButton.setIcon(playIcon);
		playButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				playSelected = !playSelected;
				pauseVisible = !pauseVisible;
				playButton.setIcon(playSelected ? stopIcon : playIcon);
				pauseButton.setVisible(pauseVisible);
			}
		});
		
		playButton.setRolloverEnabled(true);
		playButton.setBorderPainted(false);
		playButton.setPreferredSize(new Dimension(30, 30));
		playButton.setBackground(Color.BLACK);
		playButton.setFocusable(false);

		pauseButton.setBorderPainted(false);
		pauseButton.setPreferredSize(new Dimension(30, 30));
		pauseButton.setBackground(Color.BLACK);
		pauseButton.setFocusable(false);

		pauseButton.setIcon(pauseIcon);
		
		toolBar.add(playButton);
		toolBar.add(pauseButton);
		
		toolBar.setOrientation(SwingConstants.HORIZONTAL);
		toolBar.setFloatable(true);
		
		DrawingPanel drawingPanel = new DrawingPanel(grafo);
		drawingPanel.setBackground(ApplicationSettings.PALETTE_DARK_GRAY);
		drawingPanel.addMouseListener(drawingPanel);
		drawingPanel.addMouseMotionListener(drawingPanel);

		window.add(drawingPanel);
		window.addContentPane(toolBar, BorderLayout.NORTH);
		window.run();
	}

}
