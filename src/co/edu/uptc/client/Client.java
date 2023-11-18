package co.edu.uptc.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import co.edu.uptc.model.Player;
import co.edu.uptc.view.MyFrame;

public class Client implements ActionListener{

	private Player player;
	private MyFrame myFrame;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;


	public Client() {
		myFrame = new MyFrame(this);
	}

	public void changeScreen() {
		Boolean initialFlag = false;
		try {
			initialFlag = (Boolean)in.readObject();
		} catch (ClassNotFoundException e) {

		} catch (IOException e) {

		}
		myFrame.changeToWaitScreen(initialFlag);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "Play": 
			player = new Player(myFrame.getName(), myFrame.getHost(), myFrame.getPort());
			this.initSocket();
			try {
				out.writeObject(player);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			this.changeScreen();
			break;
		default:

			break;
		}
	}

	public void initSocket(){
		try {
			socket = new Socket("localhost", 8086);
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}
