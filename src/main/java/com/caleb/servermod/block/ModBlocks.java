package com.caleb.servermod.block;

import com.caleb.servermod.Servermod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Servermod.MODID);

    public static final RegistryObject<Block> TMT_BLOCK = BLOCKS.register(
            "tmt_block",
            () -> new TMTBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(3.0f, 6.0f)
                    .requiresCorrectToolForDrops()
            )
    );    public static final RegistryObject<Block> VOID_BLOCK = BLOCKS.register(
            "void_block",
            () -> new VOIDBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLACK)
                    .strength(3.0f, 6.0f)
                    .requiresCorrectToolForDrops()
            )
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
