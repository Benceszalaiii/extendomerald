package net.benceszalai.extendomerald.items.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class ModToolMaterial {
    public static ToolMaterial EmeraldMaterial = getEmeraldMaterial();
    public static ToolMaterial getEmeraldMaterial() {
        return new ToolMaterial(BlockTags.NEEDS_DIAMOND_TOOL, 2561, 9.0F, 2.5F, 13, ItemTags.DIAMOND_TOOL_MATERIALS);
    }
}