package net.benceszalai.extendomerald;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks{
    public static Block registerTorch(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_torch");
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, itemId);
        Block.Settings settings = AbstractBlock.Settings.copy(Blocks.TORCH).registryKey(key);
        return Registry.register(Registries.BLOCK, key, new Block(settings));
    };
    public static void registerModItems(){
            Extendomerald.LOGGER.info("Registering Mod Blocks for Extendomerald");
    }
    public static void initialize(){
        registerModItems();
    }
}
