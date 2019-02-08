package me.elsiff.egui

import me.elsiff.egui.state.GuiOpenState
import org.bukkit.entity.Player

/**
 * Created by elsiff on 2019-01-05.
 */
class GuiOpener(
    private val guiRegistry: GuiRegistry
) {
    fun open(player: Player, gui: Gui) {
        player.closeInventory()
        gui.handleOpen(GuiOpenState(player))
        gui.showTo(player)
        if (!guiRegistry.isRegistered(gui)) {
            guiRegistry.register(gui)
        }
    }
}