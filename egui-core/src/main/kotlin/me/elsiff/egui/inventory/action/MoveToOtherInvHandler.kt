package me.elsiff.egui.inventory.action

import me.elsiff.egui.inventory.InventoryGui
import me.elsiff.egui.state.GuiItemChangeState
import me.elsiff.egui.util.ItemDeliverer
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * Created by elsiff on 2018-08-22.
 */
class MoveToOtherInvHandler : InventoryActionHandler {
    override val handlingActions: Set<InventoryAction> = setOf(InventoryAction.MOVE_TO_OTHER_INVENTORY)

    override fun handle(event: InventoryClickEvent, gui: InventoryGui) {

        val topInv = event.view.topInventory
        val bottomInv = event.view.bottomInventory

        if (event.clickedInventory == topInv) {
            if (gui.isControllable(event.rawSlot)) {
                gui.handleItemChange(GuiItemChangeState.of(event))
            } else {
                event.isCancelled = true
            }
        } else if (event.clickedInventory == bottomInv) {
            event.isCancelled = true
            event.currentItem?.let { ItemDeliverer.deliver(it, topInv, gui.controllableSlots()) }
            gui.handleItemChange(GuiItemChangeState.of(event))
        }
    }
}