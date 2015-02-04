package src.server.model.players.packets;

import src.server.Server;
import src.server.model.players.Client;
import src.server.model.players.PacketType;
import src.server.util.Misc;


/**
 * Clicking stuff (interfaces)
 **/
public class ClickingStuff implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		if (c.inTrade) {
			if(!c.acceptedTrade) {
				Misc.println("trade reset");
				c.getTradeAndDuel().declineTrade();
			}
		}

		Client o = (Client) Server.playerHandler.players[c.duelingWith];
		if(o != null) {
			if(c.duelStatus >= 1 && c.duelStatus <= 4) {
				c.getTradeAndDuel().declineDuel();
				o.getTradeAndDuel().declineDuel();
			}
		}
		
		if(c.duelStatus == 6) {
			c.getTradeAndDuel().claimStakedItems();		
		}
	
	}
		
}
