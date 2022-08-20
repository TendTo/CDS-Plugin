package com.cds.command

import com.cds.handler.BaseHandler
import org.bukkit.command.Command
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class GameCommandHandler(plugin: JavaPlugin) : BaseHandler(plugin) {

    fun handleCommand(sender: Player, cmd: Command, label: String, args: Array<String>): Boolean {
        // Case Insensitive Command
        val ciCmd = cmd.getName().lowercase()
        return when (ciCmd) {
            "ded" -> handleDed(sender)
            else -> false
        }
    }

    fun handleDed(sender: Player): Boolean {
        sender.setHealth(0.0)
        return true
    }
}
