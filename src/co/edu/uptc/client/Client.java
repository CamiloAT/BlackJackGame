package co.edu.uptc.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import co.edu.uptc.model.ClientThread;
import co.edu.uptc.model.Player;
import co.edu.uptc.view.CardLabel;
import co.edu.uptc.view.MyFrame;

public class Client implements ActionListener {

	private Player player;
	private MyFrame myFrame;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private ClientThread threadClient;

	public Client() {
		myFrame = new MyFrame(this);
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
			this.changeToWaitScreen();
			break;
		case "Request":
			this.reciveCard();
		default:

			break;
		}
	}

	public Boolean signToChange() {
		Boolean flag = false;
		try {
			flag = (Boolean) in.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void changeToWaitScreen() {
		myFrame.showWaitPanel(this);
	}

	public void changeToPlayScreen() {
		myFrame.showPlayPanel(this);
		this.reciveCard();
		this.reciveCard();

	}

	public boolean endThreadClient() {
		return myFrame.endThreadClient();
	}

	public void reciveCard() {
		try {
			CardLabel cardLabel = (CardLabel) in.readObject();
			myFrame.reciveCard(cardLabel);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initSocket() {
		try {
			socket = new Socket("localhost", 8088);
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			threadClient = new ClientThread(this);
			threadClient.start();
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