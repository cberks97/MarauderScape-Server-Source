package src.server.model.players.skills;

import src.server.Config;
import src.server.util.Misc;
import src.server.model.players.Client;
/**
 * Thieving.java
 *
 * @author Sanity
 *
 **/
 
public class Thieving {
	
	private Client c;
		
	public Thieving(Client c) {
		this.c = c;
	}
	
	public void stealFromNPC(int id) {
		if (System.currentTimeMillis() - c.lastThieve < 2000)
			return;
		for (int j = 0; j < npcThieving.length; j++) {
			if (npcThieving[j][0] == id) {
				if (c.playerLevel[c.playerThieving] >= npcThieving[j][1]) {
					if (Misc.random(c.playerLevel[c.playerThieving] + 2 - npcThieving[j][1]) != 1) {
						c.getPA().addSkillXP(npcThieving[j][2] * Config.THIEVING_EXPERIENCE, c.playerThieving);
						c.getItems().addItem(995, npcThieving[j][3]);
						c.startAnimation(881);
						c.lastThieve = System.currentTimeMillis();
						c.sendMessage("You thieve some money...");
						break;
					} else {
						c.setHitDiff(npcThieving[j][4]);
						c.setHitUpdateRequired(true);
						c.playerLevel[3] -= npcThieving[j][4];
						c.getPA().refreshSkill(3);
						c.lastThieve = System.currentTimeMillis() + 2000;
						c.sendMessage("You fail to thieve the NPC.");
						break;
					}
				} else {
					c.sendMessage("You need a thieving level of " + npcThieving[j][1] + " to thieve from this NPC.");
				}
			}		
		}
	}
	
	public void stealFromStall(int id, int xp, int level) {
		if (System.currentTimeMillis() - c.lastThieve < 2500)
			return;
		if (Misc.random(100) == 0) {
			
			return;
		}
		if (c.playerLevel[c.playerThieving] >= level) {
			if (c.getItems().addItem(id,1)) {
				c.startAnimation(832);
				c.getPA().addSkillXP(xp * Config.THIEVING_EXPERIENCE, c.playerThieving);
				c.lastThieve = System.currentTimeMillis();
				c.sendMessage("You steal a " + src.server.model.items.Item.getItemName(id) + ".");
			}		
		} else {
			c.sendMessage("You must have a thieving level of " + level + " to thieve from this stall.");
		}
	}
	//npc, level, exp, coin amount
	public int[][] npcThieving = {{1,1,8,3,1},{3,1,8,3,1},{16,1,8,3,1},{4,1,8,3,1},{5,1,8,3,1},{6,1,8,3,1},{25,1,8,3,1},{24,1,8,3,1},{2,1,8,3,1},{18,25,26,5,1},{9,40,47,10,2},
	{26,55,85,15,3},{20,70,152,20,4},{21,80,273,30,5}};

}






