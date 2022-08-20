package com.cds.util

import org.bukkit.entity.Item
import org.bukkit.scheduler.BukkitRunnable

class DroppedItem : BukkitRunnable() {
    val items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) {
        items.add(item)
    }

    override fun run() {
        for (i in items.indices.reversed()) {
            val item = items.get(i)
            if (item.isOnGround()) {
                item.getWorld().createExplosion(item.getLocation(), 0f)
                items.removeAt(i)
            }
        }
    }
}
