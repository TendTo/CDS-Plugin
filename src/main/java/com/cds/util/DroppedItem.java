package com.cds.util;

import java.util.LinkedList;

import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

public class DroppedItem extends BukkitRunnable {
    private LinkedList<Item> items = new LinkedList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void run() {
        for (int i = items.size() - 1; i >= 0; i--) {
            Item item = items.get(i);
            if (item.isOnGround()) {
                item.getWorld().createExplosion(item.getLocation(), 0);
                items.remove(i);
            }
        }
    }

}
