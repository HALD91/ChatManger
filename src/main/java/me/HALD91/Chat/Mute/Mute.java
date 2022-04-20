package me.HALD91.Chat.Mute;


import me.HALD91.Chat.ChatCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Mute implements CommandExecutor, Listener {
    public static ArrayList<String> IsMuted = new ArrayList<>();
    ChatCore main = JavaPlugin.getPlugin(ChatCore.class);
    String prefix = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Prefix") + "");
    //HelpMessages
    String ChatManagerHelpReload = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.ReloadConfig") + "");
    String ChatManagerHelpPermsMessage = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.PermsMessage") + "");
    String ChatManagerHelpMessage = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message") + "");
    String ChatManagerHelpMessage1 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message1") + "");
    String ChatManagerHelpMessage2 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message2") + "");
    String ChatManagerHelpMessage3 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message3") + "");
    String ChatManagerHelpMessage4 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message4") + "");
    String ChatManagerHelpMessage5 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message5") + "");
    String ChatManagerHelpMessage6 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message6") + "");
    String ChatManagerHelpMessage7 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message7") + "");
    String ChatManagerHelpMessage8 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message8") + "");
    String ChatManagerHelpMessage9 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Help.message9") + "");
    //Muted
    String ChatManagerPermsMessage = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Mute.PermsMessage") + "");
    String ChatManagerMutedMessage = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Mute.MutedMessage") + "");
    String ChatManagerWhosMuted1 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Mute.Who'sBeenMuted1") + "");
    String ChatManagerWhosMuted2 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Mute.Who'sBeenMuted2") + "");
    String ChatManagerAlreadyMuted = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Mute.Alreadymuted") + "");
    String ChatManagerNotOnline1 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.Mute.NotOnline") + "");
    //Unmuted
    String ChatManagerUnmutedperms = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.UnMute.PermsMessage") + "");
    String ChatManagerUnmuted = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.UnMute.UnMutedMessage") + "");
    String ChatManagerWhosBeenUnMuted1 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.UnMute.Who'sBeenUnMuted1") + "");
    String ChatManagerWhosBeenUnMuted2 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.UnMute.Who'sBeenUnMuted2") + "");
    String ChatManagerNotmuted = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.UnMute.Notmuted") + "");
    String ChatManagerNotOnline2 = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("ChatManager.UnMute.NotOnline") + "");


    @EventHandler
    public void onPlayerChat(PlayerChatEvent e) {
        if(IsMuted.contains(e.getPlayer().getName())){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + ChatManagerMutedMessage));
        } else {
            e.setCancelled(false);
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("chatmanager")) {
            if (sender.hasPermission("chatmanager.admin.use")) {
                if (!(args.length == 0)) {
                    if (args[0].equalsIgnoreCase("help")) {
                        sender.sendMessage(ChatManagerHelpMessage);
                        sender.sendMessage(ChatManagerHelpMessage1);
                        sender.sendMessage(ChatManagerHelpMessage2);
                        sender.sendMessage(ChatManagerHelpMessage3);
                        sender.sendMessage(ChatManagerHelpMessage4);
                        sender.sendMessage(ChatManagerHelpMessage5);
                        sender.sendMessage(ChatManagerHelpMessage6);
                        sender.sendMessage(ChatManagerHelpMessage7);
                        sender.sendMessage(ChatManagerHelpMessage8);
                        sender.sendMessage(ChatManagerHelpMessage9);
                    }
                    if (args[0].equalsIgnoreCase("perms")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7chatmanager.admin.use &b- To use the ChatManager command."));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7mute.command.use &b- To use the Mute command."));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7unmute.command.use &b- To use the Unmute command."));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7chat.command.use &b- To use the Chat command.")); // Chat.on
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Chat.on &b- Use this permission to give a player access to talk when the chat is turned off."));
                    }
                } else {
                    sender.sendMessage(prefix + " " + ChatManagerHelpMessage1);
                }
            } else {
                sender.sendMessage(prefix + " " + ChatManagerHelpPermsMessage);
            }
        }

        if (sender instanceof Player) {
          if (command.getName().equalsIgnoreCase("mute")) {
              if (sender.hasPermission("mute.command.use")) {
                  if (!(args.length == 0)) {
                      Player M = Bukkit.getPlayer(args[0]);
                      if ((M == null)) {
                          sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + ChatManagerNotOnline1));
                      } else {
                          Player m = Bukkit.getPlayer(args[0]);
                          if (!(IsMuted.contains(m.getPlayer().getName()))) {
                              IsMuted.add(m.getName());
                              m.sendMessage(prefix + " " + ChatManagerMutedMessage);
                              sender.sendMessage(prefix + " " + ChatManagerWhosMuted1 + " " + m.getName() + " " + ChatManagerWhosMuted2);
                              return true;
                          } else {
                              sender.sendMessage(prefix + " " + m.getName() + " " + ChatManagerAlreadyMuted);
                          }
                      }
                  } else {
                      sender.sendMessage(prefix + " " + ChatManagerHelpMessage1);
                  }
              } else {
                  sender.sendMessage(prefix + " " + ChatManagerPermsMessage);
              }
          }
          if (command.getName().equalsIgnoreCase("unmute")) {
              if (sender.hasPermission("unmute.command.use")) {
                  if (!(args.length == 0)) {
                      Player UM = Bukkit.getPlayer(args[0]);
                      if (UM == null) {
                          sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + ChatManagerNotOnline2));
                      } else {
                          Player m = Bukkit.getPlayer(args[0]);
                          if (!(IsMuted.contains(m.getPlayer().getName()))) {
                              sender.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + " " + m.getName() + " " + ChatManagerNotmuted));
                          } else {
                              IsMuted.remove(m.getName());
                              m.sendMessage(prefix + " " + ChatManagerUnmuted);
                              sender.sendMessage(prefix + " " + ChatManagerWhosBeenUnMuted1 + " " + m.getName() + " " + ChatManagerWhosBeenUnMuted2);
                              return true;
                          }
                      }
                  } else {
                      sender.sendMessage(prefix + " " + ChatManagerHelpMessage1);
                  }
              } else {
                  sender.sendMessage(prefix + " " + ChatManagerUnmutedperms);
              }
          }
        } return true;
    }
}
