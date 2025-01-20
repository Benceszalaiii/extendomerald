package net.benceszalai.extendomerald.items;

import net.benceszalai.extendomerald.Extendomerald;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import java.util.ArrayList;
import java.util.List;

public class EmeraldPickaxe extends PickaxeItem {
    public EmeraldPickaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public static EmeraldPickaxe register(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_pickaxe");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
        Item.Settings settings = new EmeraldPickaxe.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
        EmeraldPickaxe registeredItem = Registry.register(Registries.ITEM, key, new EmeraldPickaxe(ModToolMaterial.EmeraldMaterial, 2, -2.8F, settings));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
            itemgroup.add(registeredItem);
        });
        return registeredItem;
    }
    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            if(blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                    }
                }
            }

            if(blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                    }
                }
            }

            if(blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                    }
                }
            }
        }

        return positions;
    }

}
