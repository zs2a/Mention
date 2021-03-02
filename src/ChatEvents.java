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

		for (Player onlineplayers : Bukkit.getServer().getOnlinePlayers()) { // Loop through online players

			if (event.getMessage().contains(onlineplayers.getName())) { // Check if message contains player name

				String msg = event.getMessage().replace(onlineplayers.getName(), ChatColor.BLUE + onlineplayers.getName());
				event.setMessage(msg); // Replace original message
			} else {
				
				System.out.println("[-]");
			}
		}
	}
}
