package co.edu.uptc.view;

import javax.swing.JLabel;

public class CardLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	private int value;
	private String type;
	private String name;

	public CardLabel(int value, String type, String name) {
		this.value = value;
		this.type = type;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
