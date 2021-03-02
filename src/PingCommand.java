package dev.stan.plugin;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class PingCommand implements CommandExecutor {

	public static HashMap<Player, Boolean> enabled = new HashMap<Player, Boolean>();

	public void togglePluginState(Player player) {

		if (enabled.containsKey(player)) {
			if (enabled.get(player)) {
				enabled.put(player, false);
				player.sendMessage("Pings disabled.");
			} else {
				enabled.put(player, true);
				player.sendMessage(ChatColor.GREEN + "Pings enabled.");

			}
		} else {
			enabled.put(player, false); // If you want plugin enabled by default change this value to false.
			player.sendMessage(ChatColor.GREEN + "Pings disabled.");
		}

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("ping")) {

			if (sender instanceof Player) {

				Player player = (Player) sender;
				togglePluginState(player);
				return true;

			}

			else {

				System.out.println("You must be in-game to execute this command.");
			}
		}
		return false;
	}

}
