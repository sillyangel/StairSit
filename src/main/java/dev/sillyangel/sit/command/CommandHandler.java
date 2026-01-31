package dev.sillyangel.sit.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;

public class CommandHandler {

    public static void register(Command... cmds) {
        // Paper provides direct access to CommandMap without reflection
        CommandMap commandMap = Bukkit.getServer().getCommandMap();
        
        for (Command cmd : cmds) {
            commandMap.register(cmd.getName(), cmd);
        }
    }
}
