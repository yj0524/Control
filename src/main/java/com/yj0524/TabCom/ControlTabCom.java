package com.yj0524.TabCom;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ControlTabCom implements TabCompleter {

    List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] arg) {
        if (arguments.isEmpty()) {
            arguments.add("help");
            arguments.add("joinmessage");
            arguments.add("quitmessage");
            arguments.add("deathmessage");
            arguments.add("advancementmessage");
            arguments.add("chatmessage");
        }

        List<String> result = new ArrayList<>();

        if (arg.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(arg[0].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        }

        if (arg.length >= 3) {
            result.clear();
            return result;
        }

        // help Command
        if (arg[0].equalsIgnoreCase("help")) {
            result.clear();
            return result;
        }

        // joinmessage Command
        if (arg[0].equalsIgnoreCase("joinmessage")) {
            result.clear();
            result.add("true");
            result.add("false");
            return result;
        }

        // quitmessage Command
        if (arg[0].equalsIgnoreCase("quitmessage")) {
            result.clear();
            result.add("true");
            result.add("false");
            return result;
        }

        // deathmessage Command
        if (arg[0].equalsIgnoreCase("deathmessage")) {
            result.clear();
            result.add("true");
            result.add("false");
            return result;
        }

        // advancementmessage Command
        if (arg[0].equalsIgnoreCase("advancementmessage")) {
            result.clear();
            result.add("true");
            result.add("false");
            return result;
        }

        // chatmessage Command
        if (arg[0].equalsIgnoreCase("chatmessage")) {
            result.clear();
            result.add("true");
            result.add("false");
            return result;
        }

        return arguments;
    }
}