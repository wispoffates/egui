package me.elsiff.egui.util

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import kotlin.math.min

/**
 * Created by elsiff on 2019-01-28.
 */
object ItemDeliverer {
    fun deliver(
        delivery: ItemStack,
        inventory: Inventory,
        destinationSlots: List<Int> = (0 until inventory.size).toList()
    ) {
        val contents = destinationSlots.mapNotNull { slot -> inventory.getItem(slot) ?: null }
        for (invItem in contents.filter { it.isSimilar(delivery) }) {
            val givingAmount = min(delivery.amount, invItem.maxStackSize - invItem.amount)
            invItem.amount = invItem.amount + givingAmount
            delivery.amount = delivery.amount - givingAmount

            if (delivery.amount == 0)
                break
        }

        for (emptySlot in destinationSlots.filter(inventory::isEmptyAt)) {
            val placingAmount = min(delivery.amount, delivery.maxStackSize)
            inventory.setItem(emptySlot, delivery.clone().apply { amount = placingAmount })
            delivery.amount = delivery.amount - placingAmount
        }
    }
}

private fun Inventory.isEmptyAt(slot: Int): Boolean {
    val item = getItem(slot)
    return item == null || item.type == Material.AIR
}