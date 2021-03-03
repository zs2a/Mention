package dev.stan.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dev.stan.plugin.commands.PingToggleCMD;
import net.md_5.bungee.api.ChatColor;

public class ChatEvents implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		
		

		for (Player pinged : Bukkit.getServer().getOnlinePlayers()) { // Loop through all players

			if (event.getMessage().contains("@" + pinged.getName())) { // Check if message contains a player.


				if (PingToggleCMD.enabled.get(player)) { // Check if player has turned on pings
					
					if (pinged.hasPermission("ping.red")) {
						
						String msg = event.getMessage().replace("@" + pinged.getName(), ChatColor.RED + pinged.getName() + ChatColor.RESET);
						event.setMessage(msg);
					}
					
					else if (pinged.hasPermission("ping.yellow")) {
						
						String msg = event.getMessage().replace("@" + pinged.getName(), ChatColor.YELLOW + pinged.getName() + ChatColor.RESET);
						event.setMessage(msg);
					} else {
						
						String msg = event.getMessage().replace("@" + pinged.getName(), ChatColor.GREEN + pinged.getName() + ChatColor.RESET);
						event.setMessage(msg);
					}
					
					pinged.getWorld().playSound(pinged.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F); // Play sound at player pos

					return;
				}

			}
		}
	}
}
