package co.edu.uptc.model;

import java.io.Serializable;
import java.util.ArrayList;
import co.edu.uptc.view.CardLabel;

public class Player implements Serializable{

	private String name;
	private String host;
	private int port;
	private int score;
	private ArrayList<CardLabel> cards;
	
	public Player(String name, String host, int port) {
		super();
		this.name = name;
		this.host = host;
		this.port = port;
		this.score = 0;
		this.cards = new ArrayList<>();
		
	}

	public void addCard(CardLabel card) {
		this.cards.add(card);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
