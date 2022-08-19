package com.cds.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.cds.handler.BaseHandler;
import com.cds.util.DroppedItem;

public class WorldEventListener extends BaseHandler implements Listener {
    private DroppedItem droppedItem = new DroppedItem();

    public WorldEventListener(JavaPlugin plugin) {
        super(plugin);
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Salut! Ora sei sul minecraffen dei CDS!");
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        String lowercaseName = event.getItemDrop().getName().toLowerCase();
        if (lowercaseName.contains("t") || lowercaseName.contains("n")) {
            droppedItem.addItem(event.getItemDrop());
            event.getItemDrop().getWorld().createExplosion(event.getItemDrop().getLocation(), 0);
        }
    }

    public void registerRunner() {
        droppedItem.runTaskTimer(plugin, 0, 2L);
    }
}
