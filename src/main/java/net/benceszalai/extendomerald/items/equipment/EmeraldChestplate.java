package net.benceszalai.extendomerald.items.equipment;

import net.benceszalai.extendomerald.Extendomerald;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class EmeraldChestplate extends ArmorItem {

    public EmeraldChestplate(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }
    public static EmeraldChestplate register(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_chestplate");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
        Settings settings = new Settings().registryKey(key).rarity(Rarity.UNCOMMON);
        EmeraldChestplate registeredItem = Registry.register(Registries.ITEM, key, new EmeraldChestplate(ModArmorMaterial.EMERALD_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings));
        return registeredItem;
    }
}
