package co.edu.uptc.model;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import co.edu.uptc.view.CardLabel;

public class CardGenerator {

	private ArrayList<CardLabel> deck;
	private static final int CARD_WIDTH = 140;
	private static final int CARD_HEIGHT = 198;
	
	public CardGenerator() {
		this.initCards();
	}
	
	private void initCards() {
		deck = new ArrayList<>();
		
		for (int i = 1; i < 14; i++) {
			int value = (i>=10)?10:i;
			String name = (i==1)?"A":"";
			CardLabel card = new CardLabel(value, "Heart", name);
			card.setBounds(0, 0, CARD_WIDTH, CARD_HEIGHT);
			this.setImageLabel(card, "imgs/Hearts"+i+".png");
			deck.add(card);
		}
		for (int i = 1; i < 14; i++) {
			int value = (i>=10)?10:i;
			String name = (i==1)?"A":"";
			CardLabel card = new CardLabel(value, "Diamond", name);
			card.setBounds(0, 0, CARD_WIDTH, CARD_HEIGHT);
			this.setImageLabel(card, "imgs/Diamonds"+i+".png");
			deck.add(card);
		}
		for (int i = 1; i < 14; i++) {
			int value = (i>=10)?10:i;
			String name = (i==1)?"A":"";
			CardLabel card = new CardLabel(value, "Club", name);
			card.setBounds(0, 0, CARD_WIDTH, CARD_HEIGHT);
			this.setImageLabel(card, "imgs/Clubs"+i+".png");
			deck.add(card);
		}
		for (int i = 1; i < 14; i++) {
			int value = (i>=10)?10:i;
			String name = (i==1)?"A":"";
			CardLabel card = new CardLabel(value, "Spade", name);
			card.setBounds(0, 0, CARD_WIDTH, CARD_HEIGHT);
			this.setImageLabel(card, "imgs/Spades"+i+".png");
			deck.add(card);
		}
	}
	
	public ArrayList<CardLabel> getDeck() {
		return deck;
	}

	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		labelName.repaint();
	}
}
