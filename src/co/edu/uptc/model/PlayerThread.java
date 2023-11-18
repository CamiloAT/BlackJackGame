package co.edu.uptc.model;

import co.edu.uptc.client.Client;
import co.edu.uptc.server.Server;

public class PlayerThread extends Thread{

	private Player player;
	private Server server;
	private Client client;
	private boolean flag;

	public PlayerThread(Player player, Server server) {
		this.player = player;
		this.server = server;
		this.flag = true;
	}
	
	@Override
	public void run() {
		this.server.sendBooleanToChange(true);

	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
