package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlayPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private ButtonRound passButton;
	private ButtonRound plantButton;
	private ButtonRound requestButton;
	private int xPoint;
	
	public PlayPanel(ActionListener actionListener) {
		this.initComponents(actionListener);
		this.xPoint = 300;
	}

	private void initComponents(ActionListener actionListener) {
		this.setLayout(null);
		this.setBackground(new Color(34, 97, 42));
		
		passButton = new ButtonRound(" PASAR", new Color(26, 25, 61), (String) null, (Dimension) null);
		passButton.setBounds(10, 10, 270, 42);
		passButton.addActionListener(actionListener);
		passButton.setActionCommand("Pass");
		add(passButton);
		
		plantButton = new ButtonRound(" PLANTARSE", new Color(26, 25, 61), (String) null, (Dimension) null);
		plantButton.setBounds(10, 62, 270, 42);
		plantButton.addActionListener(actionListener);
		plantButton.setActionCommand("Plant");
		add(plantButton);
		
		requestButton = new ButtonRound(" PEDIR", new Color(26, 25, 61), (String) null, (Dimension) null);
		requestButton.setBounds(10, 114, 270, 42);
		requestButton.addActionListener(actionListener);
		requestButton.setActionCommand("Request");
		add(requestButton);
	}

	public void reciveCard(CardLabel cardLabel){
		cardLabel.setLocation(xPoint, 550);
		xPoint += 50;
		add(cardLabel);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Icon foodIcon = new ImageIcon("imgs/Background.png");
		foodIcon.paintIcon(this, g, 0, 0);
	}
}
