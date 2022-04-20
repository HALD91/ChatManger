package me.HALD91.Chat.OnOff;

import me.HALD91.Chat.ChatCore;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatOnOffListener implements Listener {
    ChatCore main = JavaPlugin.getPlugin(ChatCore.class);
    String prefix = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Prefix"));
    @EventHandler
    public void onchat(PlayerChatEvent e) {
        if (ChatOnOff.chat != true) {
            if (e.getPlayer().hasPermission("Chat.on")) {
                e.setCancelled(false);

            } else {
                e.setCancelled(true);
                e.getPlayer().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&7Chat is turned &coff &7you can't type right now"));
            }
        }
    }
}
