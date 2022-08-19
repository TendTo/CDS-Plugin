package com.cds.command;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.cds.handler.BaseHandler;

public class GameCommandHandler extends BaseHandler {

    public GameCommandHandler(JavaPlugin plugin) {
        super(plugin);
    }

    public boolean handleCommand(Player sender, Command cmd, String label, String[] args) {
        // Case Insensitive Command
        String ciCmd = cmd.getName().toLowerCase();
        switch (ciCmd) {
            case "ded":
                return handleDed(sender);
            default:
                return false;
        }
    }

    private boolean handleDed(Player sender) {
        sender.setHealth(0);
        return true;
    }
}
