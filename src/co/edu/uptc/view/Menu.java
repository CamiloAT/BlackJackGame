package co.edu.uptc.view;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Menu extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel tittle ;
	private ButtonRound btnPlay;
	private MyTextField namePlayer; 
	private MyTextField host;
	private MyTextField port;

	public Menu(ActionListener actionListener) {
		this.initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		setBackground(new Color(0,63,28,255));
		setSize(new Dimension(1000, 700));
		setLayout(null);
		
		tittle = new JLabel();
		tittle.setIcon(new ImageIcon(Menu.class.getResource("/resources/PhotoRoom-20231115_120615 (1).png")));
		tittle.setBounds(96, -22, 1000, 500);
		add(tittle);
		
		btnPlay = new ButtonRound(" JUGAR", new Color(26, 25, 61), (String) null, (Dimension) null);
		btnPlay.setBounds(352, 586, 270, 42);
		btnPlay.addActionListener(actionListener);
		btnPlay.setActionCommand("Play");
		add(btnPlay);
		
		namePlayer = new MyTextField();
		namePlayer.setPrefixIcon(new ImageIcon(getClass().getResource("/resources/cartas-de-poquer.png")));
		namePlayer.setBounds(352, 419, 270, 42);
		add(namePlayer);
		
		host = new MyTextField();
		host.setHint("          Host");
		host.setBounds(352, 476, 270, 42);
		add(host);
		
		port = new MyTextField();
		port.setHint("        Puerto");
		port.setBounds(352, 534, 270, 42);
		add(port);
	}
	
	public String getName() {
		return namePlayer.getText();
	}
	
	public String getHost() {
		return host.getText();
	}
	
	public int getPort() {
		return Integer.parseInt( port.getText());
	}
}
