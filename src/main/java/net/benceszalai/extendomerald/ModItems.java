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

        public static EmeraldPickaxe registerPickaxe() {
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_pickaxe");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new EmeraldPickaxe.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            EmeraldPickaxe registeredItem = Registry.register(Registries.ITEM, key, new EmeraldPickaxe(ToolMaterial.DIAMOND, 2, -2.8F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }
        public static EmeraldSword registerSword(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_sword");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new EmeraldSword.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            EmeraldSword registeredItem = Registry.register(Registries.ITEM, key, new EmeraldSword(ToolMaterial.DIAMOND, 4.5F, -1.8F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }

        public static EmeraldAxe registerAxe(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_axe");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new EmeraldAxe.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            EmeraldAxe registeredItem = Registry.register(Registries.ITEM, key, new EmeraldAxe(ToolMaterial.DIAMOND, 5.0F, -1.8F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }

        public static EmeraldShovel registerShovel(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_shovel");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new EmeraldShovel.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
            EmeraldShovel registeredItem = Registry.register(Registries.ITEM, key, new EmeraldShovel(ToolMaterial.DIAMOND, 2.5F, -2.3F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }
        public static EmeraldHoe registerHoe(){
            Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_hoe");
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
            Item.Settings settings = new EmeraldHoe.Settings().registryKey(key).rarity(Rarity.COMMON);
            EmeraldHoe registeredItem = Registry.register(Registries.ITEM, key, new EmeraldHoe(ToolMaterial.DIAMOND, 2.5F, -2.3F, settings));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
                itemgroup.add(registeredItem);
            });
            return registeredItem;
        }

        public static final EmeraldSword EMERALD_SWORD = registerSword();
        public static final EmeraldPickaxe EMERALD_PICKAXE = registerPickaxe();
        public static final EmeraldAxe EMERALD_AXE = registerAxe();
        public static final EmeraldShovel EMERALD_SHOVEL = registerShovel();
        public static final EmeraldHoe EMERALD_HOE = registerHoe();
        public static void registerModItems(){
            Extendomerald.LOGGER.info("Registering mod items for " + Extendomerald.MOD_ID);


    }
}
