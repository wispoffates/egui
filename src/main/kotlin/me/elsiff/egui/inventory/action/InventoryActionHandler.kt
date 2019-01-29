package me.elsiff.egui.inventory.action

import me.elsiff.egui.inventory.InventoryGui
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * Created by elsiff on 2018-08-22.
 */
interface InventoryActionHandler {
    val handlingActions: Collection<InventoryAction>

    fun handle(event: InventoryClickEvent, gui: InventoryGui)
}