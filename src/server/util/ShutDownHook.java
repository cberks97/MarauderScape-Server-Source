package src.server.util;

import src.server.model.players.Client;
import src.server.model.players.PlayerSave;
import src.server.Server;

public class ShutDownHook extends Thread {

	@Override
	public void run() {
		System.out.println("Shutdown thread run.");
		for (int j = 0; j < Server.playerHandler.players.length; j++) {
			if (Server.playerHandler.players[j] != null) {
				Client c = (Client)Server.playerHandler.players[j];
				src.server.model.players.PlayerSave.saveGame(c);			
			}		
		}
		System.out.println("Shutting down...");
	}

}