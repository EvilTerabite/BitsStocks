package me.evilterabite.bitsstocks;

import me.evilterabite.bitsstocks.files.StockConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class BitsStocks extends JavaPlugin {

    @Override
    public void onEnable() {
        loadConfigs();
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "BitsStocks Started!");

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "BitsStocks Stopped!");
    }

    public void loadConfigs(){
        saveResource("stocks.yml", false);
        saveResource("playerdata.yml", false);
        saveDefaultConfig();
        StockConfig.setup();;
    }
}
