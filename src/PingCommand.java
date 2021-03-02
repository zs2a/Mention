package dev.stan.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equals("ping")) {

			if (sender instanceof Player) { // Check if command is being sent from console
				
				System.out.println("Ping [+]");

			}

			else {

				System.out.println("You must be in-game to execute this command.");
			}
		}
		return false;
	}
}
