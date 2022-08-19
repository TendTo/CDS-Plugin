package com.cds.handler;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class BaseHandler {
    protected JavaPlugin plugin;

    protected BaseHandler(JavaPlugin plugin) {
        this.plugin = plugin;
    }
}
