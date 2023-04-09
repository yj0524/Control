package com.yj0524;

import com.yj0524.commands.*;
import com.yj0524.TabCom.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin implements Listener {

    public Boolean joinMessage;
    public Boolean quitMessage;
    public Boolean deathMessage;
    public Boolean advancementMessage;
    public Boolean chatMessage;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin Enabled");

        // Config.yml 파일 생성
        loadConfig();
        File cfile = new File(getDataFolder(), "config.yml");
        if (cfile.length() == 0) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        getCommand("control").setExecutor(new ControlCommand(this));
        getCommand("control").setTabCompleter(new ControlTabCom());
        getCommand("configreload").setExecutor(new ConfigReloadCommand(this));
        getCommand("configreload").setTabCompleter(new ConfigReloadTabCom());

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin Disabled");
    }

    public void loadConfig() {
        // Load config
        FileConfiguration config = getConfig();
        joinMessage = config.getBoolean("joinMessage", true);
        quitMessage = config.getBoolean("quitMessage", true);
        deathMessage = config.getBoolean("deathMessage", true);
        advancementMessage = config.getBoolean("advancementMessage", true);
        chatMessage = config.getBoolean("chatMessage", true);
        // Save config
        config.set("joinMessage", joinMessage);
        config.set("quitMessage", quitMessage);
        config.set("deathMessage", deathMessage);
        config.set("advancementMessage", advancementMessage);
        config.set("chatMessage", chatMessage);
        saveConfig();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!joinMessage) {
            event.joinMessage(null);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (!quitMessage) {
            event.quitMessage(null);
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (!deathMessage) {
            event.deathMessage(null);
        }
    }

    @EventHandler
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent event) {
        if (!advancementMessage) {
            event.message(null);
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (!chatMessage) {
            event.setCancelled(true);
        }
    }
}
