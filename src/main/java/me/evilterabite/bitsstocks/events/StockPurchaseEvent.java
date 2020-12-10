package me.evilterabite.bitsstocks.events;

import me.evilterabite.bitsstocks.stockutils.Stock;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StockPurchaseEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private Stock stockBought;

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS;
    }

    public Stock getStockBought() {
        return stockBought;
    }
}
