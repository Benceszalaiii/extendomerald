package net.benceszalai.extendomerald.items.tools;

import net.benceszalai.extendomerald.Extendomerald;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class EmeraldAxe extends AxeItem {
    public EmeraldAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    public static EmeraldAxe register(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_axe");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
        Item.Settings settings = new EmeraldAxe.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
        EmeraldAxe registeredItem = Registry.register(Registries.ITEM, key, new EmeraldAxe(ModToolMaterial.EmeraldMaterial, 5.0F, -1.8F, settings));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemgroup) -> {
            itemgroup.add(registeredItem);
        });
        return registeredItem;
    }
}
