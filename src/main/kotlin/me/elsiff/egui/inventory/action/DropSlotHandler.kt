package me.elsiff.egui.inventory.action

import me.elsiff.egui.inventory.InventoryGui
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * Created by elsiff on 2019-01-28.
 */
class DropSlotHandler : InventoryActionHandler {
    override val handlingActions: Collection<InventoryAction> = setOf(
        InventoryAction.DROP_ALL_SLOT,
        InventoryAction.DROP_ONE_SLOT
    )

    override fun handle(event: InventoryClickEvent, gui: InventoryGui) {
        event.isCancelled = true
    }
}