package net.benceszalai.extendomerald;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static final TagKey<Item> REPAIRS_EMERALD = TagKey.of(RegistryKeys.ITEM, Identifier.of(Extendomerald.MOD_ID, "repairs_emerald"));
}