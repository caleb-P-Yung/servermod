package com.caleb.servermod.block;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class VOIDBlock extends Block {

    public VOIDBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {

        if (!level.isClientSide()) {
            Minecraft.getInstance().execute(() -> {
                player.sendSystemMessage(
                        Component.literal("TMT Block activated!")
                );
            });
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

}
