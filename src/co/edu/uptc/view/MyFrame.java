package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Menu menu;
	
	public MyFrame(ActionListener actionListener){
		super("BlackJack");
		this.initComponents();
		this.setSize(new Dimension(1000,700));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	
	private void initComponents() {
		menu =new Menu();
		add(menu);
	}
	
	public String getName() {
		return menu.getName();
	}
	
	public String getHost() {
		return menu.getHost();
	}
	
	public int getPort() {
		return menu.getPort();
	}
}

