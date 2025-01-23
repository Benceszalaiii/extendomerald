package net.benceszalai.extendomerald.items.ingredients;

import net.benceszalai.extendomerald.Extendomerald;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class SharpenedEmerald extends Item {
    public SharpenedEmerald(Settings settings) {
        super(settings);
    };
    public static SharpenedEmerald register(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "sharpened_emerald");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
        Item.Settings settings = new Settings().registryKey(key).rarity(Rarity.RARE);
        return Registry.register(Registries.ITEM, key, new SharpenedEmerald(settings));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.extendomerald.sharpened_emerald.tooltip"));
        super.appendTooltip(stack, context, tooltip, type);

    }
}
