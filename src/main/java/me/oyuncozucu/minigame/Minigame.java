package me.oyuncozucu.minigame;

import me.oyuncozucu.minigame.command.ArenaCommand;
import me.oyuncozucu.minigame.listener.ConnectListener;
import me.oyuncozucu.minigame.listener.GameListener;
import me.oyuncozucu.minigame.manager.ArenaManager;
import me.oyuncozucu.minigame.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minigame extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {

        ConfigManager.setupConfig(this);
        arenaManager = new ArenaManager(this);

        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);

        getCommand("arena").setExecutor(new ArenaCommand(this));

    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }



}
