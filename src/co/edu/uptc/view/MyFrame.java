package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Menu menu;
	public MyFrame(){
		super("BlackJack");
		menu =new Menu();
		add(menu);
		initComponents();


	}
	private void initComponents() {
//		setIconImage(new ImageIcon(getClass().getResource("/resources/serpiente.png")).getImage());
		setSize(new Dimension(1000,700));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
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
	public static void main(String[] args) {
		new MyFrame();
	}
}

