package me.HALD91.Chat.OnOff;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatOnOff implements CommandExecutor {
    String prefix = "" + ChatColor.GRAY + "[" + ChatColor.GOLD + "Chat" + ChatColor.DARK_AQUA + "Control" + ChatColor.GRAY + "]" + " ";
    public static boolean chat = true;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("chat")){
            if (sender.hasPermission("chat.command.use")){
                if (args.length == 0){
                    sender.sendMessage(prefix + ChatColor.GRAY + "Plz specify if you wanna turn the chat " + ChatColor.GREEN + "on " + ChatColor.GRAY + "or " + ChatColor.RED + "off");
                    return true;
                }
                if (args.length == 1){
                    if(args[0].equalsIgnoreCase("on")){
                        chat = true;
                        sender.sendMessage(prefix + ChatColor.GRAY + "Chat is turned " + ChatColor.GREEN + "on " + ChatColor.GRAY + "you can now type");
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("off")){
                        chat = false;
                        sender.sendMessage(prefix + ChatColor.GRAY + "Chat is turned " + ChatColor.RED + "off " + ChatColor.GRAY + "you can't type right now");;
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("help")){
                        sender.sendMessage(prefix + ChatColor.GRAY + "Turn the chat on or off by using " + ChatColor.RED + "/chat on/off");
                        sender.sendMessage(prefix + ChatColor.GRAY + "To get help on how you use this command use " + ChatColor.RED + "/chat help");
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
