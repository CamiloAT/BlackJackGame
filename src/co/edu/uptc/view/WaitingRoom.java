package co.edu.uptc.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class WaitingRoom extends JPanel {
	private JLabel infPersonWaitting;
	private JLabel personWaitting;
	
	public WaitingRoom() {
		this.setBackground(new Color(0, 128, 0));
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1000, 700));
		this.initComponent();
	}
	
	private void initComponent() {
		infPersonWaitting = new JLabel("Personas en la sala: ");
		infPersonWaitting.setFont(new Font("Stencil Std", Font.PLAIN, 15));
		infPersonWaitting.setForeground(new Color(255, 255, 255));
		infPersonWaitting.setBounds(402, 196, 186, 39);
		add(infPersonWaitting);
		
		personWaitting = new JLabel("");
		personWaitting.setForeground(new Color(255, 255, 255));
		personWaitting.setFont(new Font("Stencil Std", Font.PLAIN, 15));
		personWaitting.setBounds(603, 199, 46, 32);
		add(personWaitting);
		
		JLabel infWaitting = new JLabel("Esperando...");
		infWaitting.setFont(new Font("Stencil Std", Font.PLAIN, 25));
		infWaitting.setForeground(new Color(255, 255, 255));
		infWaitting.setBounds(419, 246, 228, 47);
		add(infWaitting);
		
		JLabel jLabelInformation = new JLabel("");
		jLabelInformation.setFont(new Font("Stencil Std", Font.PLAIN, 20));
		jLabelInformation.setBounds(354, 169, 321, 315);
	    Color backgroundColor = new Color(0,0,0 , 200); 
	    jLabelInformation.setBackground(backgroundColor);
	    jLabelInformation.setOpaque(true);
	    add(jLabelInformation);
		
	    JLabel backgroundJLabel = new JLabel("");
	    backgroundJLabel.setBounds(0, 0, 1000, 700);
	    this.setImageLabel(backgroundJLabel, "resources/backgroundWaittingRoom.png");
	    add(backgroundJLabel);
	}
	
	public void setNumberPerson(int numberPerson) {
		personWaitting.setText(numberPerson + "");
	}
	
	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
	}
}
