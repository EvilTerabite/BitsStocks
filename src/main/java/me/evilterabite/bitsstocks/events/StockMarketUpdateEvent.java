package me.evilterabite.bitsstocks.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StockMarketUpdateEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS;
    }
}
