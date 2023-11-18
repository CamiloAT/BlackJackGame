package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PlayPanel() {
		this.initComponents();
	}

	private void initComponents() {
		this.setLayout(null);
		this.setBackground(new Color(34, 97, 42));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Icon foodIcon = new ImageIcon("imgs/Background.png");
		foodIcon.paintIcon(this, g, 0, 0);
	}
}
