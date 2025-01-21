package net.benceszalai.extendomerald;

import net.benceszalai.extendomerald.items.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModItems {
        private static Item registerBasicItem(String name, Item.Settings settings){
                Identifier itemId = Identifier.of(Extendomerald.MOD_ID, name);
                RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
                Item registeredItem = Registry.register(Registries.ITEM, key, new Item(settings.registryKey(key)));
                return registeredItem;
        }
        public static final SharpenedEmerald SHARPENED_EMERALD = SharpenedEmerald.register();
        public static final Item EMERALD_CLUMP = registerBasicItem("emerald_clump", new Item.Settings().maxCount(16));
        public static final Item HARDENED_EMERALD = registerBasicItem("hardened_emerald", new Item.Settings());
        public static final EmeraldSword EMERALD_SWORD = EmeraldSword.register();
        public static final EmeraldPickaxe EMERALD_PICKAXE = EmeraldPickaxe.register();
        public static final EmeraldAxe EMERALD_AXE = EmeraldAxe.register();
        public static final EmeraldShovel EMERALD_SHOVEL = EmeraldShovel.register();
        public static final EmeraldHoe EMERALD_HOE = EmeraldHoe.register();
        public static final EmeraldBow EMERALD_BOW = EmeraldBow.register();
        public static final EmeraldShard EMERALD_SHARD = EmeraldShard.register();
        public static void registerModItems(){
            Extendomerald.LOGGER.info("Registering mod items for " + Extendomerald.MOD_ID);

    }
}
