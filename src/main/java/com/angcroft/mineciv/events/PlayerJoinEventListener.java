package com.angcroft.mineciv.events;

import com.angcroft.mineciv.MineCiv;
import com.angcroft.mineciv.managers.CityManager;
import com.angcroft.mineciv.models.City;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class PlayerJoinEventListener implements Listener {

    private MineCiv plugin;
    private CityManager cityManager;

    public PlayerJoinEventListener(CivilizationPlugin plugin) {
        this.plugin = plugin;
        this.cityManager = plugin.getCityManager();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        City playerCity = cityManager.getCity(player.getUniqueId());

        if (playerCity != null) {
            player.sendMessage("Welcome back to your city, " + playerCity.getName() + "!");
        } else {
            player.sendMessage("Welcome to the server! You can create your own city using /createcity <name>.");
        }

        // Additional actions to perform when a player joins
    }
}