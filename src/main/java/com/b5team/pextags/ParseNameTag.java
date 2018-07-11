package com.b5team.pextags;

import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;

class ParseNameTag {
	
	static void ParseToNameTag(Player player, String prefix, String suffix) {
		
		if (prefix.equals("") || prefix.equals(null)) {
			prefix = null;
		}
		
		if (suffix.equals("") || suffix.equals(null)) {
			suffix = null;
		}
		
		NametagEdit.getApi().setPrefix(player, prefix);
		NametagEdit.getApi().setSuffix(player, suffix);
		NametagEdit.getApi().setNametag(player, prefix, suffix);
	}
}
