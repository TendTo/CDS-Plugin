package com.cds

import com.cds.command.CommandHandler
import com.cds.listener.WorldEventListener
import java.util.Stack
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class Main : JavaPlugin() {
    val worldEventListener = WorldEventListener(this)
    val commandHandler = CommandHandler(this)
    val runnables = Stack<BukkitRunnable>()

    override fun onEnable() {
        saveDefaultConfig()
        getServer().getPluginManager().registerEvents(this.worldEventListener, this)
        while (!runnables.empty()) {
            runnables.pop().runTaskTimer(this, 0, 2)
        }
    }

    override fun onCommand(
            sender: CommandSender,
            cmd: Command,
            label: String,
            args: Array<String>
    ): Boolean {
        return commandHandler.handleCommand(sender, cmd, label, args)
    }
}
