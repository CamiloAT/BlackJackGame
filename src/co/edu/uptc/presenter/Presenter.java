package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.uptc.view.MyFrame;

public class Presenter implements ActionListener{

	private MyFrame myFrame;
	
	public Presenter() {
		myFrame = new MyFrame(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "": 
			
			break;
		default:
			
			break;
		}
	}

	public static void main(String[] args) {
		new Presenter();
	}
}
