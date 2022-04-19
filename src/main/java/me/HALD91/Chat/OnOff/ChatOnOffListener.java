package me.HALD91.Chat.OnOff;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatOnOffListener implements Listener {
    String prefix = "" + ChatColor.GRAY + "[" + ChatColor.GOLD + "Chat" + ChatColor.DARK_AQUA + "Control" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";

    @EventHandler
    public void onchat(PlayerChatEvent e) {
        if (ChatOnOff.chat != true) {
            if (e.getPlayer().hasPermission("Chat.on")) {
                e.setCancelled(false);

            } else {
                e.setCancelled(true);
                e.getPlayer().sendMessage(prefix + ChatColor.GRAY + "Chat is turned " + ChatColor.RED + "off " + ChatColor.GRAY + "you can't type right now");
            }
        }
    }
}
