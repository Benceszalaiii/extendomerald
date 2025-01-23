package net.benceszalai.extendomerald.mixin;

import net.benceszalai.extendomerald.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class EmeraldMixin {

    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void onUseOnBlock(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack stack = context.getStack();
        if (stack.isOf(Items.EMERALD)) {
            PlayerEntity player = context.getPlayer();
            World world = context.getWorld();
            if (player != null && !world.isClient) {
                Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
                if (player.isInSneakingPose() && clickedBlock == Blocks.OBSIDIAN) {
                    player.sendMessage(Text.literal("You sharpened an emerald on obsidian!"), true);
                    player.getMainHandStack().decrement(1);
                    if (world.getRandom().nextFloat() < 0.36) {
                        player.giveItemStack(new ItemStack(ModItems.EMERALD_SHARD, 1));
                    }
                }
            }
            cir.setReturnValue(ActionResult.SUCCESS);
        }
    }
}
