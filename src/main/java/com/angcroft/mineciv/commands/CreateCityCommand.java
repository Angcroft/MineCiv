package com.angcroft.mineciv.commands;

import com.angcroft.mineciv.managers.CityManager;
import com.angcroft.mineciv.models.City;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CreateCityCommand implements CommandExecutor {

    private CityManager cityManager;

    public CreateCityCommand(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can create cities.");
            return true;
        }

        Player player = (Player) sender;
        UUID playerId = player.getUniqueId();

        if (args.length < 1) {
            player.sendMessage("Please specify a name for your city.");
            return false;
        }

        String cityName = args[0];
        Location location = player.getLocation();

        // Check if the player already owns a city
        if (cityManager.getCity(playerId) != null) {
            player.sendMessage("You already own a city.");
            return true;
        }

        // Create the city
        cityManager.createCity(playerId, cityName, location);
        player.sendMessage("City " + cityName + " has been created!");

        // Optionally broadcast the creation of the new city
        Bukkit.getServer().broadcastMessage(player.getName() + " has founded a new city: " + cityName + "!");

        return true;
    }
}