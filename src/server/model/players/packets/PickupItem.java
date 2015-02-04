package src.server.model.players.packets;

import src.server.Server;
import src.server.model.players.Client;
import src.server.model.players.PacketType;


/**
 * Pickup Item
 **/
public class PickupItem implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
	c.pItemY = c.getInStream().readSignedWordBigEndian();
	c.pItemId = c.getInStream().readUnsignedWord();
	c.pItemX = c.getInStream().readSignedWordBigEndian();
	if (Math.abs(c.getX() - c.pItemX) > 25 || Math.abs(c.getY() - c.pItemY) > 25) {
		c.resetWalkingQueue();
		return;
	}
	c.getCombat().resetPlayerAttack();
	if(c.getX() == c.pItemX && c.getY() == c.pItemY) {
		Server.itemHandler.removeGroundItem(c, c.pItemId, c.pItemX, c.pItemY, true);
	} else {
		c.walkingToItem = true;
	}
	
	}

}
