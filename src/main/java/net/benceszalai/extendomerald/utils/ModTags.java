package net.benceszalai.extendomerald.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public class BlockTags{
        public static final TagKey<Block> NEEDS_EMERALD_TOOL = createTag("needs_emerald_tool");
        public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = createTag("incorrect_for_emerald_tool");
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("extendomerald", name));
        }
    }
}
