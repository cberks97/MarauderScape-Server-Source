package src.server.model.players.packets;

import src.server.Server;
import src.server.model.items.UseItem;
import src.server.model.players.Client;
import src.server.model.players.PacketType;


public class ItemOnNpc implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		int itemId = c.getInStream().readSignedWordA();
		int i = c.getInStream().readSignedWordA();
		int slot = c.getInStream().readSignedWordBigEndian();
		int npcId = Server.npcHandler.npcs[i].npcType;
		
		UseItem.ItemonNpc(c, itemId, npcId, slot);
	}
}
