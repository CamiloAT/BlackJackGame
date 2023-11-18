package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Menu menu;
	private PlayPanel playPanel;

	public MyFrame(ActionListener actionListener){
		super("BlackJack");
		this.initComponents(actionListener);
		this.setSize(new Dimension(1000,700));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}

	private void initComponents(ActionListener actionListener) {
		menu =new Menu(actionListener);
		add(menu);
//		playPanel = new PlayPanel();
//		add(playPanel);
	}
	
	public void changeToWaitScreen(Boolean flag) {
		if (flag) {
			System.out.println("ola");
		}else {
			System.out.println("noola");
		}
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

