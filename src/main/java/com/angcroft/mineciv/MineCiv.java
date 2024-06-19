package com.angcroft.mineciv;

import com.angcroft.civilizationplugin.commands.CreateCityCommand;
import com.angcroft.civilizationplugin.commands.DeclareWarCommand;
import com.angcroft.civilizationplugin.events.PlayerJoinEvent;
import com.angcroft.civilizationplugin.managers.CityManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MineCiv extends JavaPlugin {

    private CityManager cityManager;

    @Override
    public void onEnable() {
        // Load configuration
        saveDefaultConfig();

        // Initialize managers
        cityManager = new CityManager(this);

        // Register commands
        getCommand("createcity").setExecutor(new CreateCityCommand(cityManager));
        getCommand("declarewar").setExecutor(new DeclareWarCommand());

        // Register events
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);

        // Log enable message
        getLogger().info("MineCiv has been enabled!");
    }

    @Override
    public void onDisable() {
        // Save data
        cityManager.saveCities();

        // Log disable message
        getLogger().info("MineCiv has been disabled!");
    }

    public CityManager getCityManager() {
        return cityManager;
    }
}