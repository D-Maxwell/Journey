package com.maxwell.journey.gui.menus;

import com.maxwell.journey.Registries;
import com.maxwell.journey.registries.Menus;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class JourneyMenu extends AbstractContainerMenu {


    public JourneyMenu(int containerId, Inventory playerInventory) {
        super(Registries.JOURNEY_MENU.get(), containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.inventoryMenu.stillValid(player);
    }


}