package org.waqe.pl.customguis.listeners

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventException
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.Plugin
import org.waqe.pl.customguis.CustomGUIs
import java.lang.NullPointerException

class PlayerListener(val plugin: CustomGUIs) : Listener {

//    var plugin: CustomGUIs? = null
//    init {
//        plugin = customGUIs
//
//    }

    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent) {
        var inv: InventoryView = e.view
//            Bukkit.getLogger().info("Clicked Inventory Title: ${e.clickedInventory.getTitle()}")
        if (inv.getTitle() != null) Bukkit.getLogger().info("Clicked Inventory Title: ${inv.getTitle().toString()}")
        if (inv.getTitle().equals("Custom items")) {
            Bukkit.getLogger().info("1-> ${inv.cursor.getItemMeta().getDisplayName()}")
            Bukkit.getLogger().info("2-> ${inv.topInventory.getItem(0)}")
            Bukkit.getLogger().info("3-> ${e.getCursor()}")

            if (inv.getTopInventory().getItem(0) == (e.getCursor())) {
                Bukkit.getLogger().info("  Awesome selection!!")
                // perm check here
                inv.player.getInventory().addItem(plugin.getCustomItem().getAwesomeSword())
            } else if (inv.getTopInventory().getItem(0) == (e.getCursor())) {
                Bukkit.getLogger().info("  Awesome selection!!")
                // perm check here
                inv.player.getInventory().addItem(plugin.getCustomItem().getAwesomePick())
            }
            e.setCancelled(true)
        }
        if (inv.cursor == null) return
        if (inv.cursor.getItemMeta() == null) return
        if (inv.cursor.getItemMeta().getDisplayName() == null) return

    }

    @EventHandler
    fun onPlayerPrepareCraft(e: PrepareItemCraftEvent) {
        Bukkit.getLogger().info("PrepareItemCraftEvent......")
        val inv: CraftingInventory = e.getInventory()
        val matrix: Array<ItemStack> = inv.getMatrix()
        if (matrix.size < 9) {
            Bukkit.getLogger().info("log output......")
            return
        }
        try {
            if ((matrix[1].type.equals(Material.DIAMOND_BLOCK))) {
                if ((matrix[4].type.equals(Material.DIAMOND_BLOCK))) {
                    if (matrix[7].type.equals(Material.STICK)) {
                        Bukkit.getLogger().info("adding awesomesword")
                        inv.setResult(plugin.getCustomItem().getAwesomeSword())
                    }
                }
            }
        } catch(e: NullPointerException) {
            Bukkit.getLogger().info("pointer pain......")
            e.printStackTrace()
        }
    }


}