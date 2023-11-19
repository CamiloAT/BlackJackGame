package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private final static String PLAY = "play";
	private final static String MENU = "menu";
	private final static String WAIT = "wait";

	private static final long serialVersionUID = 1L;
	private Menu menu;
	private PlayPanel playPanel;
	private WaitingRoom waitPanel;
	private JPanel cardLayout;
	private CardLayout card;
	private boolean flagThreadClient;

	public MyFrame(ActionListener actionListener){
		super("BlackJack");
		this.initComponents(actionListener);
		this.setSize(1000,700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.flagThreadClient = true;
	}

	private void initComponents(ActionListener actionListener) {
		card = new CardLayout();
		cardLayout = new JPanel(card);
		cardLayout.setBounds(0, 0, this.getWidth(), this.getHeight());

		menu = new Menu(actionListener);
		menu.setBounds(0, 0, 893, 556);

		cardLayout.add(menu, MENU);
		card.show(cardLayout, MENU);

		playPanel = new PlayPanel(actionListener);
		cardLayout.add(playPanel, PLAY);

		waitPanel = new WaitingRoom();
		cardLayout.add(waitPanel, WAIT);

		add(cardLayout);
	}
	
	public void showMenuPanel() {
		card.show(cardLayout, MENU);
		cardLayout.revalidate();
		cardLayout.repaint();
	}
	
	public void showPlayPanel(ActionListener actionListener) {
		playPanel = new PlayPanel(actionListener);
		cardLayout.add(playPanel, "Play");
		card.show(cardLayout, "Play");
		card.show(cardLayout, PLAY);
		cardLayout.revalidate();
		cardLayout.repaint();
		flagThreadClient = false;
		System.out.println("Pantalla cambiada");
	}
	
	public void showWaitPanel(ActionListener actionListener) {
		card.show(cardLayout, WAIT);
		cardLayout.revalidate();
		cardLayout.repaint();
	}


	public boolean endThreadClient(){
		return flagThreadClient;
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
