package net.windwaker.textureme.listener;

import net.windwaker.textureme.TextureMe;
import net.windwaker.textureme.gui.Selector;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TmPlayerListener implements Listener {
	
	private TextureMe plugin;
	
	public TmPlayerListener(TextureMe plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void attachPrompt(PlayerJoinEvent event) {
		SpoutPlayer player = (SpoutPlayer) event.getPlayer();
		if(plugin.getConfig().getBoolean("prompt on login") && player.hasPermission("textureme.select")) {
			player.getMainScreen().attachPopupScreen(new Selector(plugin, player));
		}
	}
}