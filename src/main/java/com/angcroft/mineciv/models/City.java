package com.angcroft.mineciv.models;

import org.bukkit.Location;

import java.util.UUID;

public class City {

    private String name;
    private UUID owner;
    private Location location;
    private int population;
    private int resources;

    public City(String name, UUID owner, Location location) {
        this.name = name;
        this.owner = owner;
        this.location = location;
        this.population = 0; // Default initial population
        this.resources = 0; // Default initial resources
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public void addResources(int amount) {
        this.resources += amount;
    }

    public void removeResources(int amount) {
        if (this.resources - amount >= 0) {
            this.resources -= amount;
        } else {
            this.resources = 0; // Ensure resources do not go negative
        }
    }
}