package com.maxwell.journey;

import com.maxwell.journey.gui.menus.JourneyMenu;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Registries {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Journey.MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Journey.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, Journey.MODID);
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(net.minecraft.core.registries.Registries.MENU, Journey.MODID);


    public static final DeferredHolder<MenuType<?>, MenuType<JourneyMenu>> JOURNEY_MENU = MENUS.register("journey_menu", () -> new MenuType<>(JourneyMenu::new, FeatureFlags.DEFAULT_FLAGS));

}