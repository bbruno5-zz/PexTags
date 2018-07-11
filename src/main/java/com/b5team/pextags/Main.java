package com.b5team.pextags;

import java.util.logging.Logger;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	private static Logger logger;
	
	@Override
	public void onEnable() {
		
		plugin = this;
		logger = this.getLogger();
		this.getServer().getPluginManager().registerEvents(new PlayerEventsListener(), this);
		
		Metrics metrics = new Metrics(this);
		
		if (metrics.getPluginData() != null) {
			
			logger.info("Metrics enabled!");
		}
	}
	
	@Override
	public void onDisable() {
		
		logger.info("PexTags is now disabled.");
	}
	
	static Main getInstance() {
		return plugin;
	}
	
	static Logger getMainLogger() {
		return logger;
	}
}
