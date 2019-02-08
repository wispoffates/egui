package me.elsiff.egui.inventory.action

import me.elsiff.egui.inventory.InventoryGui
import org.bukkit.Material
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

/**
 * Created by elsiff on 2018-08-22.
 */
class CollectToCursorHandler : InventoryActionHandler {
    override val handlingActions: Set<InventoryAction> = setOf(InventoryAction.COLLECT_TO_CURSOR)

    override fun handle(event: InventoryClickEvent, gui: InventoryGui) {
        val anySimilarToCursor = gui.slots.minus(gui.controllableSlots()).any { slot ->
            val itemStack = event.view.topInventory.getItem(slot) ?: ItemStack(Material.AIR)
            itemStack.isSimilar(event.cursor)
        }
        if (anySimilarToCursor) {
            event.isCancelled = true
        }
    }
}