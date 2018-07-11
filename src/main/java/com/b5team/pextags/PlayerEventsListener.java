package com.b5team.pextags;

import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;
import ru.tehkode.permissions.events.PermissionEntityEvent;

class PlayerEventsListener implements Listener {
	
	@EventHandler
	static void onPlayerJoinListener(PlayerJoinEvent event) {
		
		BukkitRunnable r = new BukkitRunnable() {
			
			@Override
			public void run() {
				
				try {
					
					PermissionUser user = PermissionsEx.getUser(event.getPlayer());
					String prefix = user.getPrefix();
					String suffix = user.getSuffix();
					
					if (prefix.equals(null)) {
						prefix = "";
					}
					
					if (suffix.equals(null)) {
						suffix = "";
					}
					
					ParseNameTag.ParseToNameTag(event.getPlayer(), prefix, suffix);
				} catch (NullPointerException e) {
					
					Main.getMainLogger().info("NullPointerException due to player disconnect before login.");
				} catch (ArrayIndexOutOfBoundsException e) {
					
					Main.getMainLogger().info("ArrayIndexOutOfBoundsException. Trying to change tag again.");
					
					PermissionUser user = PermissionsEx.getUser(event.getPlayer());
					String prefix = user.getPrefix();
					String suffix = user.getSuffix();
					
					if (prefix.equals(null)) {
						prefix = "";
					}
					
					if (suffix.equals(null)) {
						suffix = "";
					}
					
					ParseNameTag.ParseToNameTag(event.getPlayer(), prefix, suffix);
				}
			}
		};
		r.runTaskAsynchronously(Main.getInstance());
	}
	
	@EventHandler
	static void onPlayerLoginListener(PlayerLoginEvent event) {
		
		BukkitRunnable r = new BukkitRunnable() {
			
			@Override
			public void run() {
				
				try {
					
					PermissionUser user = PermissionsEx.getUser(event.getPlayer());
					String prefix = user.getPrefix();
					String suffix = user.getSuffix();
					
					if (prefix.equals(null)) {
						prefix = "";
					}
					
					if (suffix.equals(null)) {
						suffix = "";
					}
					
					ParseNameTag.ParseToNameTag(event.getPlayer(), prefix, suffix);
				} catch (NullPointerException e) {
					
					Main.getMainLogger().info("NullPointerException due to player disconnect before login.");
				} catch (ArrayIndexOutOfBoundsException e) {
					
					Main.getMainLogger().info("ArrayIndexOutOfBoundsException. Trying to change tag again.");
					
					PermissionUser user = PermissionsEx.getUser(event.getPlayer());
					String prefix = user.getPrefix();
					String suffix = user.getSuffix();
					
					if (prefix.equals(null)) {
						prefix = "";
					}
					
					if (suffix.equals(null)) {
						suffix = "";
					}
					
					ParseNameTag.ParseToNameTag(event.getPlayer(), prefix, suffix);
				}
			}
		};
		r.runTaskAsynchronously(Main.getInstance());
	}
	
	@EventHandler
	static void onPlayerChangeTags(PermissionEntityEvent event) throws EventException {
		
		BukkitRunnable r = new BukkitRunnable() {
			
			@Override
			public void run() {
				
				try {
					
					if (event.getAction().name().equals("OPTIONS_CHANGED") || event.getAction().name().equals("PERMISSIONS_CHANGED") || event.getAction().name().equals("RANK_CHANGED") || event.getAction().name().equals("INHERITANCE_CHANGED")) {
						
						String playername = event.getEntity().getName();
						Player player = Main.getInstance().getServer().getPlayer(playername);
						PermissionUser user = PermissionsEx.getUser(Main.getInstance().getServer().getPlayer(event.getEntity().getName()));
						String prefix = user.getPrefix();
						String suffix = user.getSuffix();
						
						if (prefix.equals(null)) {
							prefix = "";
						}
						
						if (suffix.equals(null)) {
							suffix = "";
						}
						
						ParseNameTag.ParseToNameTag(player, prefix, suffix);
					}
				} catch (NullPointerException e) {
					
					Main.getMainLogger().info("NullPointerException due to player disconnect before login.");
				} catch (ArrayIndexOutOfBoundsException e) {
					
					Main.getMainLogger().info("ArrayIndexOutOfBoundsException. Trying to change tag again.");
					
					if (event.getAction().name().equals("OPTIONS_CHANGED") || event.getAction().name().equals("PERMISSIONS_CHANGED") || event.getAction().name().equals("RANK_CHANGED") || event.getAction().name().equals("INHERITANCE_CHANGED")) {
						
						String playername = event.getEntity().getName();
						Player player = Main.getInstance().getServer().getPlayer(playername);
						PermissionUser user = PermissionsEx.getUser(Main.getInstance().getServer().getPlayer(event.getEntity().getName()));
						String prefix = user.getPrefix();
						String suffix = user.getSuffix();
						
						if (prefix.equals(null)) {
							prefix = "";
						}
						
						if (suffix.equals(null)) {
							suffix = "";
						}
						
						ParseNameTag.ParseToNameTag(player, prefix, suffix);
					}
				}
			}
		};
		r.runTaskAsynchronously(Main.getInstance());
	}
}
