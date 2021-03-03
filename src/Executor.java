package dev.stan.plugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Executor extends JavaPlugin implements Listener {
	
	// On enable method, execute as soon as plugin is enabled.
	@Override
	public void onEnable() {
		
		getLogger().info("Mention Plugin enabled.");
		getCommand("ping").setExecutor(new PingCommand()); / Create new instance of Commands class and point to executor
		getServer().getPluginManager().registerEvents(new ChatEvents(), this); // Create new instance of Events class and point to executor
	}
}
