package src.server.model.players.packets;

/**
 * @author Ryan / Lmctruck30
 */

import src.server.model.items.UseItem;
import src.server.model.players.Client;
import src.server.model.players.PacketType;

public class ItemOnItem implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int usedWithSlot = c.getInStream().readUnsignedWord();
		int itemUsedSlot = c.getInStream().readUnsignedWordA();
		int useWith = c.playerItems[usedWithSlot] - 1;
		int itemUsed = c.playerItems[itemUsedSlot] - 1;
		UseItem.ItemonItem(c, itemUsed, useWith);
	}

}
