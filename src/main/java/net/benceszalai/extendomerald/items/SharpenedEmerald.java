package net.benceszalai.extendomerald.items;

import net.benceszalai.extendomerald.Extendomerald;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class SharpenedEmerald extends Item {
    public SharpenedEmerald(Settings settings) {
        super(settings);
    };
    public static SharpenedEmerald register(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "sharpened_emerald");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
        Item.Settings settings = new EmeraldSword.Settings().registryKey(key).rarity(Rarity.RARE);
        return Registry.register(Registries.ITEM, key, new SharpenedEmerald(settings));
    }
}
