package me.evilterabite.bitsstocks.files;

import me.evilterabite.bitsstocks.BitsStocks;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class StockConfig {

    private static File file;
    private static FileConfiguration playerFile;

    public static void setup(){
        Plugin plugin = BitsStocks.getPlugin(BitsStocks.class);
        file = new File(plugin.getDataFolder(), "stocks.yml");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ignored) {

            }
        }
        playerFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return playerFile;
    }

    public static void save(){
        try{
            playerFile.save(file);
        } catch (IOException e){
            Bukkit.getLogger().severe("Could not save stocks.yml, this is a serious issue, please report it!");
        }
    }

    public static void reload(){
        playerFile = YamlConfiguration.loadConfiguration(file);
    }
}
