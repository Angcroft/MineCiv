package com.angcroft.mineciv.events;

import com.angcroft.mineciv.models.City;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CityDestroyEvent extends Event {
    
    private static final HandlerList HANDLERS = new HandlerList();
    private City city;

    public CityDestroyEvent(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}