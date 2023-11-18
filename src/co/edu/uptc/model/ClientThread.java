package co.edu.uptc.model;

import co.edu.uptc.client.Client;

public class ClientThread extends Thread{

	private Client client;
	private boolean flag;
	
	public ClientThread(Client client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		while (flag) {
			if (client.signToChange()) {
				client.changeToPlayScreen();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
