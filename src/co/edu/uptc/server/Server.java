package co.edu.uptc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import co.edu.uptc.model.CardGenerator;
import co.edu.uptc.model.Player;
import co.edu.uptc.model.PlayerThread;
import co.edu.uptc.view.CardLabel;

public class Server {

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private ServerSocket serverSocket;
	private CardGenerator cardGenerator;
	private ArrayList<CardLabel> deck;
	private ArrayList<Player> players;
	private ArrayList<Player> playerTurn;
	private boolean playingState;
	private int counter;

	public Server() {
		this.cardGenerator = new CardGenerator();
		this.deck=cardGenerator.getDeck();
		this.players = new ArrayList<>();
		this.playerTurn = new ArrayList<>();
		this.playingState = false;
		this.counter=0;
		this.initSocket();
	}

	private void initSocket() {
		try {
			serverSocket = new ServerSocket(8088);
			while (true) {
				System.out.println("Esperando");
				Socket playerSocket = serverSocket.accept();
				out = new ObjectOutputStream(playerSocket.getOutputStream());
				in = new ObjectInputStream(playerSocket.getInputStream());
				System.out.println("Conectado");
				Player newPlayer = (Player)in.readObject();
				this.aceptPlayers(newPlayer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendBooleanToChange(Boolean flag) {
		try {
			out.writeObject(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendCards(int numbersCards){
		try {
			for (int i = 0; i <= numbersCards; i++) {
				out.writeObject(deck.remove((int)(Math.random()* deck.size())));	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendInitCards(Boolean flag) {
		try {
			out.writeObject(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getNumberPlayers() {
		return this.players.size();
	}
	
	public void aceptPlayers(Player player) {
		if (this.players.size()<=2&&!this.verifyName(player.getName())) {
			players.add(player);
			Thread thread = new PlayerThread(player, this);
			thread.start();
		} else {
			System.out.println("Cliente con nombre duplicado. Conexión rechazada.");
		}
	}

	private boolean verifyName(String name) {
		boolean flag = false;
		for (Player player : players) {
			if (name.equals(player.getName())) {
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
