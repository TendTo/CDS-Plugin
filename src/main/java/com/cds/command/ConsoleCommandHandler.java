package com.cds.command;

import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.cds.handler.BaseHandler;

public class ConsoleCommandHandler extends BaseHandler {

    ConsoleCommandHandler(JavaPlugin plugin) {
        super(plugin);
    }

    public boolean handleCommand(ConsoleCommandSender sender, Command cmd, String label, String[] args) {
        return false;
    }
}
