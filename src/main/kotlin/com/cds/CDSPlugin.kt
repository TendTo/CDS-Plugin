package com.cds

import PermissionManager
import com.cds.command.CommandHandler
import com.cds.listener.WorldEventListener
import java.util.Stack
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class CDSPlugin : JavaPlugin() {
    val worldEventListener = WorldEventListener(this)
    val commandHandler = CommandHandler(this)
    val permissionManager = PermissionManager(this)
    val runnables = Stack<BukkitRunnable>()

    override fun onEnable() {
        saveDefaultConfig()
        getServer().getPluginManager().registerEvents(this.worldEventListener, this)
        while (!runnables.empty()) {
            runnables.pop().runTaskTimer(this, 0, 2)
        }
    }

    override fun onDisable() {
        permissionManager.detachAllPermissions()
    }

    override fun onCommand(
            sender: CommandSender,
            cmd: Command,
            label: String,
            args: Array<String>
    ): Boolean = commandHandler.handleCommand(sender, cmd, label, args)
}
