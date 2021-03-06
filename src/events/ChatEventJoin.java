package dev.stan.plugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import dev.stan.plugin.Executor;
import net.md_5.bungee.api.ChatColor;

public class ChatEventJoin extends JavaPlugin implements Listener{
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if (player.isOp()) {
			
			if (Executor.update) {
				player.sendMessage(Executor.prefix + ChatColor.DARK_GREEN + "The mention plugin is up to date, head over to " + ChatColor.DARK_GREEN + "/help github" + ChatColor.DARK_GREEN + " if you've encountered a bug you want to report! ");
				
			} else {
				player.sendMessage(Executor.prefix + ChatColor.DARK_GREEN + "you're running an outdated version of the plugin, please download the latest release at" + ChatColor.DARK_GREEN + " https://github.com/dev-stan/mention");
			}
			
		}
		
		else {
			
			player.sendMessage("This is a test mesasge which would be sent to ops, I'm just trying to see if  the if statement works.");
		}
	}							
}
