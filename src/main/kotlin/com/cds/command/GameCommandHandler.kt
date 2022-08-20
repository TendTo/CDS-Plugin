package com.cds.command

import PermissionKeys
import com.cds.CDSPlugin
import com.cds.handler.BaseHandler
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.entity.Player

class GameCommandHandler(plugin: CDSPlugin) : BaseHandler(plugin) {

    fun handleCommand(sender: Player, cmd: Command, label: String, args: Array<String>): Boolean {
        // Case Insensitive Command
        val ciCmd = cmd.getName().lowercase()
        return when (ciCmd) {
            "ded" -> handleDed(sender)
            "mucri" -> handleMucri(sender, cmd, label, args)
            else -> false
        }
    }

    fun handleDed(sender: Player): Boolean {
        sender.setHealth(0.0)
        return true
    }

    fun handleMucri(sender: Player, cmd: Command, label: String, args: Array<String>): Boolean {
        if (!sender.hasPermission(PermissionKeys.MUCRO.key)) {
            sender.sendMessage("Non sei mucro, mi dispy :'(")
            return true
        }
        if (args.size < 1) return false

        args
                .map { Bukkit.getOfflinePlayer(it).uniqueId }
                .filter { plugin.permissionManager.hasAttachment(it) }
                .forEach { plugin.permissionManager.setPermission(it, PermissionKeys.MUCRO) }
        plugin.permissionManager.savePermissions()

        sender.sendMessage("Complimenti! Hai mucrizzato ${args.joinToString(", ")}")

        return true
    }
}
