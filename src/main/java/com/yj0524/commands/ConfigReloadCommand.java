package com.yj0524.commands;

import com.yj0524.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigReloadCommand implements CommandExecutor {

    Main main;

    public ConfigReloadCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            main.loadConfig();
            sender.sendMessage("§aConfig Reloaded!");
        }
        else {
            sender.sendMessage("§cYou don't have permission to use this command!");
        }
        return false;
    }
}
