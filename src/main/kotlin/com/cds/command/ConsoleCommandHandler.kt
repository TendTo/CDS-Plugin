package com.cds.command

import com.cds.CDSPlugin
import com.cds.handler.BaseHandler
import org.bukkit.command.Command
import org.bukkit.command.ConsoleCommandSender

public class ConsoleCommandHandler(plugin: CDSPlugin) : BaseHandler(plugin) {

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
