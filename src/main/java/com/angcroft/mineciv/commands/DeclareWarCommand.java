package com.angcroft.mineciv.commands;

import com.angcroft.mineciv.managers.CityManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeclareWarCommand implements CommandExecutor {

    private CityManager cityManager;

    public DeclareWarCommand(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can declare war.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("Please specify the name of the city you want to declare war on.");
            return false;
        }

        String targetCityName = args[0];
        UUID playerCityOwnerId = player.getUniqueId();
        City playerCity = cityManager.getCity(playerCityOwnerId);

        if (playerCity == null) {
            player.sendMessage("You do not own a city.");
            return true;
        }

        City targetCity = cityManager.getCityByName(targetCityName);

        if (targetCity == null) {
            player.sendMessage("The specified city does not exist.");
            return true;
        }

        if (targetCity.getOwner().equals(playerCityOwnerId)) {
            player.sendMessage("You cannot declare war on your own city.");
            return true;
        }

        // Declare war logic here
        cityManager.declareWar(playerCity, targetCity);
        player.sendMessage("War declared on " + targetCityName + "!");
        
        // Optionally broadcast the declaration of war
        Bukkit.getServer().broadcastMessage(player.getName() + " has declared war on the city: " + targetCityName + "!");

        return true;
    }
}