package me.evilterabite.bitsstocks.api;

import me.evilterabite.bitsstocks.events.StockPurchaseEvent;
import me.evilterabite.bitsstocks.files.PlayerConfig;
import me.evilterabite.bitsstocks.files.StockConfig;
import me.evilterabite.bitsstocks.stockutils.Stock;
import me.evilterabite.bitsstocks.utils.ExcelFunction;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class StockHandler {
    private static final FileConfiguration config = StockConfig.get();
    private static final FileConfiguration playerData = PlayerConfig.get();

    public static double predictNextPrice(Stock stock) {
        double volatility = stock.getVolatility();
        double openingPrice = config.getDouble("Stocks.%sym%.openingPrice".replace("%sym%", stock.getSymbol()));
        double inverseNormal = ExcelFunction.NORMINV(Math.random(), 0, volatility);
        return openingPrice * inverseNormal;
    }

    public static Stock getStockFromSymbol(String symbol){
        double volatility = config.getDouble("Stocks.%sym%.Volatility".replace("%sym%", symbol));
        double openingPrice = config.getDouble("Stocks.%sym%.openingPrice".replace("%sym%", symbol));
        double closingPrice = config.getDouble("Stocks.%sym%.closingPrice".replace("%sym%", symbol));
        double shares = config.getDouble("Stocks.%sym%.Shares".replace("%sym%", symbol));
        String name = config.getString("Stocks.%sym%.name".replace("%sym%", symbol));
        return new Stock(name,symbol,openingPrice,closingPrice,volatility, shares);
    }

    public static List<Stock> getStockList(){
        List<Stock> stocks = new ArrayList<>();
        List<String> stockStringList = new ArrayList<>(Objects.requireNonNull(config.getConfigurationSection("Stocks")).getKeys(false));
        for(String symbol : stockStringList) {
            stocks.add(getStockFromSymbol(symbol));
        }
        return stocks;
    }

    public static List<Stock> getStocksFromPlayer(Player player){
        UUID uuid = player.getUniqueId();
        List<String> stocksOwned = playerData.getStringList("Players.%uuid%.Stocks_Owned".replace("%uuid%", uuid.toString()));
        List<Stock> stocks = new ArrayList<>();
        for(String symbol : stocksOwned) {
            stocks.add(getStockFromSymbol(symbol));
        }
        return stocks;
    }

}
