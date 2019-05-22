package org.waqe.pl.customguis

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.waqe.pl.customguis.CustomItem
import org.waqe.pl.customguis.listeners.PlayerListener

class CustomGUIs : JavaPlugin() {

    private final val customItem = CustomItem()

     override fun onEnable() {
        try {
            getCommand("customitems").executor = CustomItemsCommand(this)
            server.pluginManager.registerEvents(PlayerListener(this), this)
        } catch(e: Exception) {
            e.printStackTrace()
        }
        Bukkit.getLogger().info("onEnable......")

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun getCustomItem() : CustomItem {
        return customItem
    }
}