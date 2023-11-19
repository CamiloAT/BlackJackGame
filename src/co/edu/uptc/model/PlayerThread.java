package co.edu.uptc.model;

import co.edu.uptc.server.Server;

public class PlayerThread extends Thread{

	
	private Player player;
	private Server server;
	private boolean flag;
	private boolean flag2;

	public PlayerThread(Player player, Server server) {
		this.player = player;
		this.server = server;
		this.flag = true;
		this.flag2 = true;
	}
	
	@Override
	public void run() {
		while (flag) {
			try {
				if (server.getNumberPlayers()>=1) {
					server.sendBooleanToChange(true);
					server.sendCards(2);
					flag2 = false;
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (flag) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}