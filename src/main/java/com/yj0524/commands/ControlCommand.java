package com.yj0524.commands;

import com.yj0524.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ControlCommand implements CommandExecutor {

    Main main;

    public ControlCommand(Main main) {
        this.main = main;
    }

    public void saveConfig() {
        main.getConfig().set("joinMessage", main.joinMessage);
        main.getConfig().set("quitMessage", main.quitMessage);
        main.getConfig().set("deathMessage", main.deathMessage);
        main.getConfig().set("advancementMessage", main.advancementMessage);
        main.getConfig().set("chatMessage", main.chatMessage);
        main.saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            if (args.length == 0) {
                sender.sendMessage("§cUsage : /control <type> <bool>");
                return true;
            } else if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("§aUsage : /control <type> <bool>");
            } else if (args[0].equalsIgnoreCase("joinmessage")) {
                if (args.length == 1) {
                    sender.sendMessage("§a현재 JoinMessage 값 : " + main.joinMessage);
                    return false;
                }
                main.joinMessage = Boolean.parseBoolean(args[1]);
                saveConfig();
                sender.sendMessage("§aJoinMessage 값이 " + main.joinMessage + "로 변경되었습니다.");
            } else if (args[0].equalsIgnoreCase("quitmessage")) {
                if (args.length == 1) {
                    sender.sendMessage("§a현재 QuitMessage 값 : " + main.quitMessage);
                    return false;
                }
                main.quitMessage = Boolean.parseBoolean(args[1]);
                saveConfig();
                sender.sendMessage("§aQuitMessage 값이 " + main.quitMessage + "로 변경되었습니다.");
            } else if (args[0].equalsIgnoreCase("deathmessage")) {
                if (args.length == 1) {
                    sender.sendMessage("§a현재 DeathMessage 값 : " + main.deathMessage);
                    return false;
                }
                main.deathMessage = Boolean.parseBoolean(args[1]);
                saveConfig();
                sender.sendMessage("§aDeathMessage 값이 " + main.deathMessage + "로 변경되었습니다.");
            } else if (args[0].equalsIgnoreCase("advancementmessage")) {
                if (args.length == 1) {
                    sender.sendMessage("§a현재 AdvancementMessage 값 : " + main.advancementMessage);
                    return false;
                }
                main.advancementMessage = Boolean.parseBoolean(args[1]);
                saveConfig();
                sender.sendMessage("§aAdvancementMessage 값이 " + main.advancementMessage + "로 변경되었습니다.");
            } else if (args[0].equalsIgnoreCase("chatmessage")) {
                if (args.length == 1) {
                    sender.sendMessage("§a현재 ChatMessage 값 : " + main.chatMessage);
                    return false;
                }
                main.chatMessage = Boolean.parseBoolean(args[1]);
                saveConfig();
                sender.sendMessage("§aChatMessage 값이 " + main.chatMessage + "로 변경되었습니다.");
            } else {
                sender.sendMessage("§cUsage : /control <type> <bool>");
            }
        } else {
            sender.sendMessage("§cYou don't have permission to use this command.");
        }
        return false;
    }
}
