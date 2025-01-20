package net.benceszalai.extendomerald.items;

import net.benceszalai.extendomerald.Extendomerald;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class EmeraldShovel extends ShovelItem {
    public EmeraldShovel(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public static EmeraldShovel register(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_shovel");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
        Item.Settings settings = new EmeraldShovel.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
        EmeraldShovel registeredItem = Registry.register(Registries.ITEM, key, new EmeraldShovel(ModToolMaterial.EmeraldMaterial, 2.5F, -2.3F, settings));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
            itemgroup.add(registeredItem);
        });
        return registeredItem;
    }
}
