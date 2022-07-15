package com.luis.flightwings.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InventoryUtil {
    public static int itemAmount(Player player, Item item) {
        int itemsAmount = 0;

        for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
            ItemStack stack = player.getInventory().getItem(slot);

            if (!stack.isEmpty() && stack.sameItem(new ItemStack(item))) {
                itemsAmount += 1;
            }
        }

        return itemsAmount;
    }

    public static int getFirstInventoryIndex(Player player, Item item) {
        for(int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack currentStack = player.getInventory().getItem(i);
            if (!currentStack.isEmpty() && currentStack.sameItem(new ItemStack(item))) {
                return i;
            }
        }

        return -1;
    }
}
