package com.cds;

import java.util.Stack;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.cds.command.CommandHandler;
import com.cds.listener.WorldEventListener;

public class Main extends JavaPlugin {
	WorldEventListener worldEventListener = new WorldEventListener(this);
	CommandHandler commandHandler = new CommandHandler(this);
	Stack<BukkitRunnable> runnables = new Stack<>();

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this.worldEventListener, this);
		while (!runnables.empty()) {
			runnables.pop().runTaskTimer(this, 0, 2);
		}
	}

	public void registerTask(BukkitRunnable runnable) {
		runnables.add(runnable);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return commandHandler.handleCommand(sender, cmd, label, args);
	}

}
