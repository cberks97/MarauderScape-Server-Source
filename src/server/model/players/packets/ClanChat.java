package src.server.model.players.packets;

import src.server.util.Misc;
import src.server.model.players.Client;
import src.server.model.players.PacketType;
import src.server.Server;
/**
 * Chat
 **/
public class ClanChat implements PacketType {

	@Override
	public void processPacket(Client c, int packetType, int packetSize) {
		String textSent = Misc.longToPlayerName2(c.getInStream().readQWord());
		textSent = textSent.replaceAll("_", " ");
		//c.sendMessage(textSent);
		Server.clanChat.handleClanChat(c, textSent);
	}	
}
