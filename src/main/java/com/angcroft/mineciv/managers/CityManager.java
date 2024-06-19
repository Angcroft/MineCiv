package com.angcroft.mineciv.managers;

import com.angcroft.mineciv.MineCiv;
import com.angcroft.mineciv.events.CityDestroyEvent;
import com.angcroft.mineciv.models.City;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.UUID;

public class CityManager {

    private MineCiv plugin;
    private HashMap<UUID, City> cities;

    public CityManager(CivilizationPlugin plugin) {
        this.plugin = plugin;
        this.cities = new HashMap<>();
        loadCities();
    }

    public void createCity(UUID owner, String name, Location location) {
        City city = new City(name, owner, location);
        cities.put(owner, city);
        saveCities();
    }

    public void deleteCity(UUID owner) {
        City city = cities.remove(owner);
        if (city != null) {
            saveCities();
            // Trigger the CityDestroyEvent
            CityDestroyEvent event = new CityDestroyEvent(city);
            Bukkit.getServer().getPluginManager().callEvent(event);
        }
    }

    public void loadCities() {
        // Load cities from configuration or database
        FileConfiguration config = plugin.getConfig();
        // Code to load cities into the cities HashMap
    }

    public void saveCities() {
        // Save cities to configuration or database
        FileConfiguration config = plugin.getConfig();
        // Code to save cities from the cities HashMap
    }

    public City getCity(UUID owner) {
        return cities.get(owner);
    }

    public City getCityByName(String name) {
        for (City city : cities.values()) {
            if (city.getName().equalsIgnoreCase(name)) {
                return city;
            }
        }
        return null;
    }

    public void declareWar(City city1, City city2) {
        // Logic to handle the declaration of war
        // This could involve setting states, updating data, and notifying players
    }

    // Additional methods to manage cities
}