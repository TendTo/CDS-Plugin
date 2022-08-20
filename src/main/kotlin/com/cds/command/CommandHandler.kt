package com.cds.command

import com.cds.CDSPlugin
import com.cds.handler.BaseHandler
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player

public class CommandHandler(plugin: CDSPlugin) : BaseHandler(plugin) {
    val consoleCommands = ConsoleCommandHandler(plugin)
    val gameCommandHandler = GameCommandHandler(plugin)

    fun handleCommand(
            sender: CommandSender,
            cmd: Command,
            label: String,
            args: Array<String>
    ): Boolean =
            when (sender) {
                is ConsoleCommandSender -> consoleCommands.handleCommand(sender, cmd, label, args)
                is Player -> gameCommandHandler.handleCommand(sender, cmd, label, args)
                else -> false
            }
}
