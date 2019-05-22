package org.waqe.pl.customguis

import org.bukkit.Bukkit
import org.bukkit.Bukkit.getLogger
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.inventory.CraftingInventory
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import java.lang.NullPointerException
import java.util.*

class CustomItemsCommand(customGUIs: CustomGUIs) : CommandExecutor {

    val pl = customGUIs

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("Command only for player use.")
            return true
        }

        val player = sender.player

        if (!player.hasPermission("customitems.main")) {
            player.sendMessage("You need the permission: customitems.main")
            return true
        }
        if (args.size < 1) {
            player.sendMessage("You need to specify arguments.")
            return true
        }
        try {
            player.sendMessage("arguments sent = ${args.size}")
            if (args.get(0).equals("awesomesword", ignoreCase = true)) {
//                if (!player.hasPermission("customitems.summon.sword")) {
//                    player.sendMessage("You need the permission: customitems.summon.sword")
//                }
                player.inventory.addItem(pl.getCustomItem().getAwesomeSword())
                player.sendMessage("You have been given the item " + args[0])
            } else if (args.get(0).equals("awesomepick", ignoreCase = true)) {
//                if (!player.hasPermission("customitems.summon.pick")) {
//                    player.sendMessage("You need the permission: customitems.summon.pick")
//                }
                player.inventory.addItem(pl.getCustomItem().getAwesomePick())
                player.sendMessage("You have been given the item " + args[0])

            } else if (args.get(0).equals("gui", ignoreCase = true)) {
                player.openInventory(pl.getCustomItem().getGUI())
            } else {
                player.sendMessage("Not valid item.")
            }
        } catch(e: Exception) {
            e.printStackTrace()
        }

        return true
    }
}

