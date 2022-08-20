package com.cds.listener

import com.cds.CDSPlugin
import com.cds.handler.BaseHandler
import com.cds.util.DroppedItem
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class WorldEventListener(plugin: CDSPlugin) : BaseHandler(plugin), Listener {
    val droppedItem = DroppedItem()

    @EventHandler
    fun onLogin(event: PlayerJoinEvent) {
        event.player.sendMessage("Salut! Ora sei sul minecraffen dei CDS!")
        plugin.permissionManager.restorePermissions(event.player)
    }

    @EventHandler
    fun onDrop(event: PlayerDropItemEvent) {
        val lowercaseName = event.itemDrop.name.lowercase()
        if (lowercaseName.contains("t") || lowercaseName.contains("n")) {
            droppedItem.addItem(event.itemDrop)
            event.itemDrop.world.createExplosion(event.itemDrop.location, 0f)
        }
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        plugin.permissionManager.detachPermissions(event.player)
    }

    fun registerRunner() {
        droppedItem.runTaskTimer(plugin, 0, 2L)
    }
}
