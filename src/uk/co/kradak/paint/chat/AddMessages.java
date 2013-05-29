package uk.co.kradak.paint.chat;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AddMessages {
	
	public void sendPlayerRedMessage(Player player, String s) {
		player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED +  ChatColor.GREEN + "Paint" + ChatColor.GOLD + "] " + ChatColor.RED + s);
	}
	
	public void sendPlayerGreenMessage(Player player, String s) {
		player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED +  ChatColor.GREEN + "Paint" + ChatColor.GOLD + "] " + ChatColor.GREEN+ s);
	}

	public void sendPlayerGoldMessage(Player player, String s) {
		player.sendMessage(ChatColor.GOLD + "[" + ChatColor.RED +  ChatColor.GREEN + "Paint" + ChatColor.GOLD + "] " + ChatColor.GOLD + s);
	}
	
	public void sendMessageToConsole(String s) {
		final Logger logger = Logger.getLogger("mc");
		logger.info(s);
	}
	
	public void broadcastMessage(String s) {
		Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + s);
	}
}
