package com.caleb.servermod.item;

import com.caleb.servermod.block.*;
import com.caleb.servermod.Servermod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Servermod.MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Servermod.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Servermod.MODID);


    public static final RegistryObject<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> TMT_BLOCK_ITEM = ITEMS.register(
            "tmt_block",
            () -> new TMTBlockItem(
                    ModBlocks.TMT_BLOCK.get(),
                    new Item.Properties()
            )
    );
    public static final RegistryObject<Item> VOID_BLOCK_ITEM = ITEMS.register(
            "void_block",
            () -> new BlockItem(
                    ModBlocks.VOID_BLOCK.get(),
                    new Item.Properties()
            )
    );

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("server_mod", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("creativetab.servermod"))
            .icon(() -> COPPER_COIN.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(TMT_BLOCK_ITEM.get());
                output.accept(COPPER_COIN.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());
           public ModItems(FMLJavaModLoadingContext context)    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }
}
