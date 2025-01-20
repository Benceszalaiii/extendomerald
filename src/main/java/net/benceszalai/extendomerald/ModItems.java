package net.benceszalai.extendomerald;

import net.benceszalai.extendomerald.items.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
        public static final SharpenedEmerald SHARPENED_EMERALD = SharpenedEmerald.register();
        public static final EmeraldSword EMERALD_SWORD = EmeraldSword.register();
        public static final EmeraldPickaxe EMERALD_PICKAXE = EmeraldPickaxe.register();
        public static final EmeraldAxe EMERALD_AXE = EmeraldAxe.register();
        public static final EmeraldShovel EMERALD_SHOVEL = EmeraldShovel.register();
        public static final EmeraldHoe EMERALD_HOE = EmeraldHoe.register();
        public static final EmeraldBow EMERALD_BOW = EmeraldBow.register();
        public static void registerModItems(){
            Extendomerald.LOGGER.info("Registering mod items for " + Extendomerald.MOD_ID);

    }
}
