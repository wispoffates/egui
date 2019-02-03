package me.elsiff.egui.inventory.action

import me.elsiff.egui.inventory.InventoryGui
import me.elsiff.egui.state.ComponentClickState
import me.elsiff.egui.state.GuiItemChangeState
import org.bukkit.event.inventory.InventoryAction
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * Created by elsiff on 2018-08-22.
 */
class StandardClickHandler : InventoryActionHandler {
    override val handlingActions: Set<InventoryAction> = setOf(
        InventoryAction.CLONE_STACK,
        InventoryAction.DROP_ALL_CURSOR,
        InventoryAction.DROP_ONE_CURSOR,
        InventoryAction.PICKUP_ALL,
        InventoryAction.PICKUP_HALF,
        InventoryAction.PICKUP_ONE,
        InventoryAction.PICKUP_SOME,
        InventoryAction.PLACE_ALL,
        InventoryAction.PLACE_ONE,
        InventoryAction.PLACE_SOME,
        InventoryAction.SWAP_WITH_CURSOR
    )

    override fun handle(event: InventoryClickEvent, gui: InventoryGui) {
        if (event.clickedInventory == event.view.topInventory && !gui.isControllable(event.slot)) {
            event.isCancelled = true

            gui.handleComponentClick(ComponentClickState.of(event))
        } else {
            gui.handleItemChange(GuiItemChangeState.of(event))
        }
    }
}