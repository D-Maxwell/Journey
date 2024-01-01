package com.maxwell.journey;

import com.maxwell.journey.events.InventoryEventHandler;
import com.maxwell.journey.registries.Blocks;
import com.maxwell.journey.registries.Items;
import com.maxwell.journey.registries.Tabs;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Journey.MODID)
public class Journey
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "journey";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();



    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Journey(IEventBus modEventBus)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        Registries.BLOCKS.register(modEventBus);
        Registries.ITEMS.register(modEventBus);
        Registries.CREATIVE_MODE_TABS.register(modEventBus);
        Registries.MENUS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(new InventoryEventHandler());
//        // Register the item to a creative tab
//        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {}


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }


}
