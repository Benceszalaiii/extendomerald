package net.benceszalai.extendomerald;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

        public static Item register(String id, Item.Settings itemSettings, RegistryKey<ItemGroup> group) {
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, id);
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = itemSettings.registryKey(key);
            Item registeredItem = Registry.register(Registries.ITEM, key, new Item(settings));
            ItemGroupEvents.modifyEntriesEvent(group).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }
        public static PickaxeItem registerPickaxe() {
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_pickaxe");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new Item.Settings().registryKey(key);
            PickaxeItem registeredItem = Registry.register(Registries.ITEM, key, new PickaxeItem(ToolMaterial.DIAMOND, 2, -2.8F, settings));
            return registeredItem;
        }

        public static final Item EMERALD_SWORD = register("emerald_sword",  new SwordItem.Settings().maxCount(1), ItemGroups.COMBAT);
        public static final Item EMERALD_PICKAXE = registerPickaxe();
        public static final Item SUSPICIOUS_INSTANCE = register("suspicious_instance", new Item.Settings(), ItemGroups.INGREDIENTS);
    public static final Item EMERALD_TORCH = register("emerald_torch", new Item.Settings().maxCount(64), ItemGroups.BUILDING_BLOCKS);
        public static void registerModItems(){
            Extendomerald.LOGGER.info("Registering mod items for " + Extendomerald.MOD_ID);


    }
}
