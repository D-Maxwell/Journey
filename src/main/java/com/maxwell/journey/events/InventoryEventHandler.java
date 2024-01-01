package com.maxwell.journey.events;

import com.maxwell.journey.gui.menus.JourneyMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.event.entity.player.PlayerContainerEvent;
import net.neoforged.neoforge.network.NetworkHooks;

public class InventoryEventHandler {


    @SubscribeEvent
    public void inventoryOpened(PlayerContainerEvent event) {


//        if (event.getContainer().getType() instanceof InventoryScreen) {
        if (event.getContainer() instanceof InventoryMenu) {
//            LocalPlayer player = Minecraft.getInstance().player;
            ServerPlayer serverPlayer = Minecraft.getInstance().player.getServer().getPlayerList().getPlayer( Minecraft.getInstance().player.getUUID() );

//            assert serverPlayer != null;

            NetworkHooks.openScreen(serverPlayer, new SimpleMenuProvider(
                (containerId, playerInventory, player) -> new JourneyMenu(containerId, playerInventory),
                Component.translatable("menu.title.journey.journey")
            ));

            System.out.println("The Journey Begins");
        }

    }


}