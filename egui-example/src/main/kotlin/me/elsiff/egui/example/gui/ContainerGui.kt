package me.elsiff.egui.example.gui

import me.elsiff.egui.example.edit
import me.elsiff.egui.inventory.ChestInventoryGui
import me.elsiff.egui.state.ComponentClickState
import me.elsiff.egui.state.GuiDragState
import me.elsiff.egui.state.GuiItemChangeState
import org.bukkit.Material
import org.bukkit.Server
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/**
 * Created by elsiff on 2019-02-08.
 */
class ContainerGui(
    server: Server
) : ChestInventoryGui(server, 6, "Container Gui") {
    init {
        val icon = ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE)
        icon.edit<ItemMeta> {
            displayName = " "
        }
        for (slot in slotsOf(0..8, 5)) {
            inventory.setItem(slot, icon)
        }

        for (slot in slotsOf(0..8, 0..4)) {
            controllableSlots.add(slot)
        }
    }

    override fun handleItemChange(state: GuiItemChangeState) {
        state.player.sendMessage(state.toString())
    }

    override fun handleComponentClick(state: ComponentClickState) {
        state.player.sendMessage(state.toString())
    }

    override fun handleDrag(state: GuiDragState) {
        //TODO send debug message to the player
    }
}