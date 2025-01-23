package net.benceszalai.extendomerald.items.equipment;

import net.benceszalai.extendomerald.Extendomerald;
import net.benceszalai.extendomerald.ModTags;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModArmorMaterial {
    public static final int BASE_DURABILITY = 50;
    public static final RegistryKey<EquipmentAsset> REGISTRY_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Extendomerald.MOD_ID, "emerald_armor"));
    public static final ArmorMaterial EMERALD_ARMOR_MATERIAL = new
            ArmorMaterial(BASE_DURABILITY,
            Map.of(EquipmentType.HELMET, 5,
                    EquipmentType.CHESTPLATE, 7,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 4), 5,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, ModTags.REPAIRS_EMERALD, REGISTRY_KEY);
}
