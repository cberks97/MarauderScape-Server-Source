package src.server.model.players.packets;

import src.server.model.players.Client;
import src.server.model.players.PacketType;
import src.server.util.Misc;

/**
 * Item Click 3 Or Alternative Item Option 1
 * 
 * @author Ryan / Lmctruck30
 * 
 * Proper Streams
 */

public class ItemClick3 implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int itemId11 = c.getInStream().readSignedWordBigEndianA();
		int itemId1 = c.getInStream().readSignedWordA();
		int itemId = c.getInStream().readSignedWordA();
		if (c.usingCarpet) {
			return;
		}
		switch (itemId) {
		case 2552:
			c.getPA().handleROD(itemId);
			break;
		case 1712:
			c.getPA().handleGlory(itemId);
			break;
		case 3853:
			c.getPA().handleGamesNeck(itemId);
			break; 

		default:
			if (c.playerRights == 3)
				Misc.println(c.playerName+ " - Item3rdOption: "+itemId+" : "+itemId11+" : "+itemId1);
			break;
		}

	}

}
