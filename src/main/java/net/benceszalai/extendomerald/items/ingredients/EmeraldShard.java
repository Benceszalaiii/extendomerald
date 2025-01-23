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

import java.util.List;

public class EmeraldShard extends Item {
    public EmeraldShard(Settings settings) {
        super(settings);
    }
    public static EmeraldShard register(){
        Identifier itemid = Identifier.of(Extendomerald.MOD_ID, "emerald_shard");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemid);
        Item.Settings settings = new Settings().registryKey(key);
        EmeraldShard registeredItem = Registry.register(Registries.ITEM, key, new EmeraldShard(settings));
        return registeredItem;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.extendomerald.emerald_shard.tooltip"));
        tooltip.add(Text.translatable("item.extendomerald.emerald_shard.tooltip2"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
