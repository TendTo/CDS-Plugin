package com.cds.command

import com.cds.handler.BaseHandler
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

public class CommandHandler(plugin: JavaPlugin) : BaseHandler(plugin) {
    val consoleCommands = ConsoleCommandHandler(plugin)
    val gameCommandHandler = GameCommandHandler(plugin)

    fun handleCommand(
            sender: CommandSender,
            cmd: Command,
            label: String,
            args: Array<String>
    ): Boolean {
        if (sender is ConsoleCommandSender)
                return consoleCommands.handleCommand(sender, cmd, label, args)
        if (sender is Player) return gameCommandHandler.handleCommand(sender, cmd, label, args)
        return false
    }
}
