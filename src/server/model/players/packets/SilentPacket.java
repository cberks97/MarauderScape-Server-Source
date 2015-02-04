package src.server.model.players.packets;

import src.server.model.players.Client;
import src.server.model.players.PacketType;

/**
 * Slient Packet
 **/
public class SilentPacket implements PacketType {
	
	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
			
	}	
}
