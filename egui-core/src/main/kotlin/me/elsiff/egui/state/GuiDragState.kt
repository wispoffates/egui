package me.elsiff.egui.state

import org.bukkit.entity.Player
import org.bukkit.event.inventory.DragType
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.inventory.ItemStack

/**
 * Created by elsiff on 2019-01-05.
 */
data class GuiDragState(
    val player: Player,
    val cursor: ItemStack?,
    val slots: Set<Int>,
    val newItems: Map<Int, ItemStack>,
    val oldCursor: ItemStack,
    val dragType: DragType
) : GuiState {
    companion object {
        fun of(event: InventoryDragEvent): GuiDragState {
            return GuiDragState(
                player = event.whoClicked as Player,
                cursor = event.cursor ?: null,
                slots = event.rawSlots,
                newItems = event.newItems,
                oldCursor = event.oldCursor,
                dragType = event.type
            )
        }
    }
}