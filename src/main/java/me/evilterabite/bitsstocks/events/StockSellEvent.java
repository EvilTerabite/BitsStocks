package me.evilterabite.bitsstocks.events;

import me.evilterabite.bitsstocks.stockutils.Stock;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StockSellEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Stock stockSold;

    public StockSellEvent(Stock stockSold) {
        this.stockSold = stockSold;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS;
    }

    public Stock getStockSold() {
        return stockSold;
    }
}
