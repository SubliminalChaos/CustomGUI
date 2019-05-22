package org.waqe.pl.customguis

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.Listener
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import java.util.ArrayList

class CustomItem {
    private val awesomeSword: ItemStack = ItemStack(Material.DIAMOND_SWORD)
    private val awesomePick: ItemStack = ItemStack(Material.DIAMOND_PICKAXE)
    var customItemInv = Bukkit.createInventory(null, 9, "Custom items")

    init {
        val swordMeta = this.awesomeSword.itemMeta
        if (swordMeta != null) swordMeta.displayName = "Awesome Sword"
        val lore1 = ArrayList<String>()
        lore1.add(" ")
        lore1.add("This sword does NOT break!")
        swordMeta?.lore = lore1
        swordMeta?.isUnbreakable = true
        swordMeta?.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        swordMeta?.addEnchant(Enchantment.DAMAGE_ALL, 5, true)
        this.awesomeSword.itemMeta = swordMeta

        val pickMeta = this.awesomePick.itemMeta
        if (pickMeta != null) pickMeta.displayName = "Awesome Pick"
        val lore2 = ArrayList<String>()
        lore2.add(" ")
        lore2.add("This pick does NOT break!")
        pickMeta?.lore = lore2
        pickMeta?.isUnbreakable = true
        pickMeta?.addItemFlags(ItemFlag.HIDE_UNBREAKABLE)
        pickMeta?.addEnchant(Enchantment.DIG_SPEED, 1, true)
        this.awesomePick.itemMeta = pickMeta

        customItemInv.addItem(this.getAwesomeSword(), this.getAwesomePick())

    }

    fun getAwesomeSword() : ItemStack {
        return this.awesomeSword
    }

    fun getAwesomePick() : ItemStack {
        return this.awesomePick
    }

    fun getGUI() : Inventory {
        return this.customItemInv
    }
}