package dev.stan.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.ChatColor;

public class ChatEvents implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = event.getPlayer();

		for (Player onlineplayers : Bukkit.getServer().getOnlinePlayers()) {

			if (event.getMessage().contains("@" + onlineplayers.getName())) {

				String msg = event.getMessage().replace("@" + onlineplayers.getName(), ChatColor.AQUA + onlineplayers.getName() + ChatColor.RESET);
				event.setMessage(msg);
			} else {
				
				System.out.println("Hey " + player.getName() + "! That's a random message.");
			}
			
			if (PingCommand.enabled(player, true)) {
				return true;
			}
		}
	}
}
