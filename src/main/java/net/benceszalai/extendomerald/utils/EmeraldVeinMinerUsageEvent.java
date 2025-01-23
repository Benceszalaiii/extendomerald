package net.benceszalai.extendomerald.utils;

import net.benceszalai.extendomerald.items.tools.EmeraldAxe;
import net.benceszalai.extendomerald.items.tools.EmeraldPickaxe;
import net.benceszalai.extendomerald.items.tools.EmeraldShovel;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class EmeraldVeinMinerUsageEvent implements PlayerBlockBreakEvents.Before {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    public static Item getIsEmeraldTool(Item item) {
        if (item instanceof EmeraldPickaxe pickaxeItem) {
            return pickaxeItem;
        }
        if (item instanceof EmeraldShovel emeraldShovel){
            return emeraldShovel;
        }
        if (item instanceof EmeraldAxe emeraldAxe){
            return emeraldAxe;
        }
        return null;
    }

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos,
                                    BlockState state, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();
        if (player instanceof ServerPlayerEntity serverPlayer) {
            if (player.isCreative() || !player.isInSneakingPose()) {
                return true;
            }
            Item emeraldMiningTool = getIsEmeraldTool(mainHandItem.getItem());
            if (emeraldMiningTool == null) {
                return true;
            }
            if (HARVESTED_BLOCKS.contains(pos)) {
                return true;
            }
            for (BlockPos position : EmeraldPickaxe.getBlocksToBeDestroyed(1, pos, serverPlayer)) {
                if (pos == position || !emeraldMiningTool.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(position);
                serverPlayer.interactionManager.tryBreakBlock(position);
                HARVESTED_BLOCKS.remove(position);
            }
        }


        return true;
    }
}
