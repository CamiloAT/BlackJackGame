package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Menu menu;
	private PlayPanel playPanel;
	private WaitingRoom waitPanel;
	private JPanel cardLayout;
	private CardLayout card;

	public MyFrame(ActionListener actionListener){
		super("BlackJack");
		this.initComponents(actionListener);
		this.setSize(1000,700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}

	private void initComponents(ActionListener actionListener) {
		card = new CardLayout();
		cardLayout = new JPanel(card);
		cardLayout.setBounds(0, 0, this.getWidth(), this.getHeight());

		menu = new Menu(actionListener);
		menu.setBounds(0, 0, 893, 556);
		cardLayout.add(menu, "Menu");
		card.show(cardLayout, "Menu");
		add(cardLayout);
	}
	
	public void showMenuPanel() {
		card.show(cardLayout, "Menu");
		cardLayout.revalidate();
		cardLayout.repaint();
	}
	
	public void showPlayPanel(ActionListener actionListener) {
		playPanel = new PlayPanel(actionListener);
		cardLayout.add(playPanel, "Play");
		card.show(cardLayout, "Play");
		cardLayout.revalidate();
		cardLayout.repaint();
	}
	
	public void showWaitPanel(ActionListener actionListener) {
		waitPanel = new WaitingRoom();
		cardLayout.add(waitPanel, "Wait");
		card.show(cardLayout, "Wait");
		cardLayout.revalidate();
		cardLayout.repaint();
	}

	public void reciveCard(CardLabel cardLabel){
		playPanel.reciveCard(cardLabel);
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

