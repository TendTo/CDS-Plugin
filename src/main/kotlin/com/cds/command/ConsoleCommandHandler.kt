package com.cds.command

import com.cds.handler.BaseHandler
import org.bukkit.command.Command
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.plugin.java.JavaPlugin

public class ConsoleCommandHandler(plugin: JavaPlugin) : BaseHandler(plugin) {

    fun handleCommand(
            sender: ConsoleCommandSender,
            cmd: Command,
            label: String,
            args: Array<String>
    ): Boolean {
        // Case Insensitive Command
        val ciCmd = cmd.getName().lowercase()
        return when (ciCmd) {
            else -> false
        }
    }
}
