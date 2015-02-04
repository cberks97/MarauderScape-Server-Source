package src.server.model.players.packets;

import src.server.Config;
import src.server.model.players.Client;
import src.server.model.players.PacketType;

/**
 * Trading
 */
public class Trade implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int tradeId = c.getInStream().readSignedWordBigEndian();
		c.getPA().resetFollow();
		
		if(c.arenas()) {
			c.sendMessage("You can't trade inside the arena!");
			return;
		}
		if(c.inWild()) {  
			c.sendMessage("You can't trade in the Wilderness!");
			return;
		}
		if (c.tradeTimer > 0) {
			c.sendMessage("You must wait 30 minutes to trade after creating an account.");
			return;
		}
		if(c.playerRights == 2 && !Config.ADMIN_CAN_TRADE) {
			c.sendMessage("Trading as an admin has been disabled.");
			return;
		}
		if(c.playerRights == 1 && !Config.MOD_CAN_TRADE) {
			c.sendMessage("Trading as an admin has been disabled.");
			return;
		}
		if (tradeId != c.playerId)
			c.getTradeAndDuel().requestTrade(tradeId);
	}
		
}
