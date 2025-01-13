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

        public static PickaxeItem registerPickaxe() {
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_pickaxe");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new PickaxeItem.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            PickaxeItem registeredItem = Registry.register(Registries.ITEM, key, new PickaxeItem(ToolMaterial.DIAMOND, 2, -2.8F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }
        public static SwordItem registerSword(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_sword");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new SwordItem.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            SwordItem registeredItem = Registry.register(Registries.ITEM, key, new SwordItem(ToolMaterial.DIAMOND, 4.5F, -1.8F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }

        public static AxeItem registerAxe(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_axe");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new AxeItem.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            AxeItem registeredItem = Registry.register(Registries.ITEM, key, new AxeItem(ToolMaterial.DIAMOND, 5.0F, -1.8F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }

        public static ShovelItem registerShovel(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_shovel");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new ShovelItem.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            ShovelItem registeredItem = Registry.register(Registries.ITEM, key, new ShovelItem(ToolMaterial.DIAMOND, 2.5F, -2.3F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }
        public static HoeItem registerHoe(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_hoe");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new HoeItem.Settings().registryKey(key).rarity(Rarity.COMMON);
            HoeItem registeredItem = Registry.register(Registries.ITEM, key, new HoeItem(ToolMaterial.DIAMOND, 2.5F, -2.3F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }

        public static final SwordItem EMERALD_SWORD = registerSword();
        public static final PickaxeItem EMERALD_PICKAXE = registerPickaxe();
        public static final AxeItem EMERALD_AXE = registerAxe();
        public static final ShovelItem EMERALD_SHOVEL = registerShovel();
        public static final HoeItem EMERALD_HOE = registerHoe();
        public static void registerModItems(){
            Extendomerald.LOGGER.info("Registering mod items for " + Extendomerald.MOD_ID);


    }
}
