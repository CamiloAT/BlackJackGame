package co.edu.uptc.model;

import co.edu.uptc.client.Client;
import co.edu.uptc.server.Server;

public class PlayerThread extends Thread{

	private Player player;
	private Server server;
	private boolean flag;

	public PlayerThread(Player player, Server server) {
		this.player = player;
		this.server = server;
		this.flag = true;
	}
	
	@Override
	public void run() {
		while (flag) {
			if (server.getNumberPlayers()>=3) {
				server.sendBooleanToChange(true);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
