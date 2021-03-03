package dev.stan.plugin.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev.stan.plugin.Executor;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class PingToggleCMD implements CommandExecutor {

	public static HashMap<Player, Boolean> enabled = new HashMap<Player, Boolean>();

	public void togglePluginState(Player player) {

		if (enabled.containsKey(player)) {
			if (enabled.get(player)) {
				enabled.put(player, false);
				player.sendMessage(Executor.prefix + ChatColor.RED + "Pings disabled.");
			} else {
				enabled.put(player, true);
				player.sendMessage(Executor.prefix + ChatColor.GREEN + "Pings enabled.");

			}
		} else {
			enabled.put(player, false); // If you want plugin enabled by default change this value to false.
			player.sendMessage(Executor.prefix + ChatColor.RED + "Pings disabled.");
		}

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("ping")) {
			
			if (sender instanceof Player) {
				
							Player player = (Player) sender;
				
				if (args.length == 0) {
					
					if (player.hasPermission("mention.command")) {
						
						togglePluginState(player);
					} else {
						player.sendMessage(Executor.noperms);
					}
					
				}
				
				else if (args.length == 1) {
					
					if (args[0].equalsIgnoreCase("github")) {
						
						TextComponent message = new TextComponent(Executor.prefix + ChatColor.DARK_AQUA + "[" + ChatColor.GREEN + "Click to visit the plugin github page" + ChatColor.DARK_AQUA + "]");
						message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/dev-stan/Mention"));
						
						player.spigot().sendMessage(message);
					}
					
					if (args[0].equalsIgnoreCase("help")) {

						player.sendMessage(Executor.prefix + ChatColor.GREEN + "Use the " + ChatColor.DARK_GREEN + "/ping " + ChatColor.GREEN + "command to toggle between the ability" + ChatColor.GREEN + " to ping (and be pinged). More info on our" + ChatColor.DARK_GREEN + " /ping github" + ChatColor.GREEN + ".");
					}
				}
			}
		}
		return false;
	}
}
