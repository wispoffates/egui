package me.elsiff.egui.example

import me.elsiff.egui.Gui
import me.elsiff.egui.GuiOpener
import me.elsiff.egui.GuiRegistry
import me.elsiff.egui.example.gui.ContainerGui
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created by elsiff on 2019-02-08.
 */
class ExamplePlugin : JavaPlugin() {
    private val guiRegistry = GuiRegistry(this)
    private val guiOpener = GuiOpener(guiRegistry)

    override fun onEnable() {
        logger.info("Plugin has been enabled")
    }

    override fun onDisable() {
        logger.info("Plugin has been disabled")
    }

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<String>
    ): Boolean {
        if (label == "egui") {
            if (sender !is Player) {
                sender.sendMessage("Only an in-game player is allowed to use this command.")
                return true
            }
            if (args.size != 1) {
                sender.sendMessage("Invalid command. Use '/egui <gui>'")
                return true
            }

            val gui: Gui? = when (args[0]) {
                "container" -> ContainerGui(server)
                else -> null
            }

            if (gui == null) {
                sender.sendMessage("There's no gui named '${args[0]}'")
            } else {
                guiOpener.open(sender, gui)
            }
            return true
        }
        return false
    }
}