package dev.stan.plugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ChatEventDiscord extends JavaPlugin implements Listener{
	
	@EventHandler
	public void onDiscord(AsyncPlayerChatEvent event) {
		
		if (event.getMessage().contains("discord")) {
			
			TextComponent clickLink = new TextComponent("discord");
			clickLink.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "DICORD_LINK"));
			
			String msg = event.getMessage().replace("discord", ChatColor.AQUA + clickLink.toString());
			event.setMessage(msg);
			
			event.setMessage(msg);
		}
	}

}
