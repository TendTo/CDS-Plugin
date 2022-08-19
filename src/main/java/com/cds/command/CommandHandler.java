package com.cds.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.cds.handler.BaseHandler;

public class CommandHandler extends BaseHandler {
    private ConsoleCommandHandler consoleCommands = new ConsoleCommandHandler(plugin);
    private GameCommandHandler gameCommandHandler = new GameCommandHandler(plugin);

    public CommandHandler(JavaPlugin plugin) {
        super(plugin);
    }

    public boolean handleCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender)
            return consoleCommands.handleCommand((ConsoleCommandSender) sender, cmd, label, args);
        if (sender instanceof Player)
            return gameCommandHandler.handleCommand((Player) sender, cmd, label, args);
        return false;
    }
}
