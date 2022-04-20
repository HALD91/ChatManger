package me.HALD91.Chat.OnOff;

import me.HALD91.Chat.ChatCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatOnOff implements CommandExecutor {
    ChatCore main = JavaPlugin.getPlugin(ChatCore.class);
    String prefix = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Prefix"));
    public static boolean chat = true;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("chat")){
            if (sender.hasPermission("chat.command.use")){
                if (args.length == 0){
                    sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&7Plz specify if you wanna turn the chat &aon &7or &coff"));
                    return true;
                }
                if (args.length == 1){
                    if(args[0].equalsIgnoreCase("on")){
                        chat = true;
                        sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&7Chat is turned &aon &7you can now type"));
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("off")){
                        chat = false;
                        sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&7Chat is turned &coff &7you can't type right now"));;
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
