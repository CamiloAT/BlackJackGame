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
	private ArrayList<PlayerThread> playerTurn;
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
	
	public void sendBooleanToChange(Boolean flag) throws InterruptedException {
		try {
			out.writeObject(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendCards(int numbersCards){
		try {
			for (int i = 0; i <= numbersCards; i++) {
				out.reset();
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
			PlayerThread thread = new PlayerThread(player, this);
			thread.start();
			playerTurn.add(thread);
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
	public void sendCard() throws IOException {
		out.writeObject(deck.remove((int) (Math.random()*deck.size())));
	}
	
	public synchronized void passShift(Player player) {
		for (PlayerThread hilo : playerTurn) {
			if(hilo.getPlayer().equals(player)) {
			try {
				hilo.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
			else {
				System.out.println("porfavor espere");
			}
			
		}
		
		
	}
	public static void main(String[] args) {
		new Server();
	}
}
