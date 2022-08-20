package com.cds.listener

import com.cds.handler.BaseHandler
import com.cds.util.DroppedItem
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class WorldEventListener(plugin: JavaPlugin) : BaseHandler(plugin), Listener {
    val droppedItem = DroppedItem()

    @EventHandler
    fun onLogin(event: PlayerJoinEvent) {
        event.getPlayer().sendMessage("Salut! Ora sei sul minecraffen dei CDS!")
    }

    @EventHandler
    fun onDrop(event: PlayerDropItemEvent) {
        val lowercaseName = event.getItemDrop().getName().lowercase()
        if (lowercaseName.contains("t") || lowercaseName.contains("n")) {
            droppedItem.addItem(event.getItemDrop())
            event.getItemDrop().getWorld().createExplosion(event.getItemDrop().getLocation(), 0f)
        }
    }

    fun registerRunner() {
        droppedItem.runTaskTimer(plugin, 0, 2L)
    }
}
