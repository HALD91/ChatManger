package me.HALD91.Chat;

import me.HALD91.Chat.Mute.Mute;
import me.HALD91.Chat.OnOff.ChatOnOff;
import me.HALD91.Chat.OnOff.ChatOnOffListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ChatCore extends JavaPlugin {
    @Override
    public void onEnable() {
        Logger.getLogger(ChatColor.translateAlternateColorCodes('&',"&a&lEnabling ChatManager"));
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("mute").setExecutor(new Mute());
        getCommand("unmute").setExecutor(new Mute());
        getCommand("chatmanager").setExecutor(new Mute());
        getCommand("chat").setExecutor(new ChatOnOff());
        Bukkit.getServer().getPluginManager().registerEvents(new Mute(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ChatOnOffListener(), this);
    }

    @Override
    public void onDisable() {
        Logger.getLogger(ChatColor.translateAlternateColorCodes('&',"&c&lDisabling ChatManager"));
    }
}
