package net.benceszalai.extendomerald.items;

import net.benceszalai.extendomerald.Extendomerald;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EmeraldSword extends Item {

    public EmeraldSword(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material.applySwordSettings(settings, attackDamage, attackSpeed));
    }
    public static EmeraldSword register(){
        Identifier itemId = Identifier.of(Extendomerald.MOD_ID, "emerald_sword");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, itemId);
        Item.Settings settings = new EmeraldSword.Settings().registryKey(key).rarity(Rarity.UNCOMMON);
        EmeraldSword registeredItem = Registry.register(Registries.ITEM, key, new EmeraldSword(ModToolMaterial.EmeraldMaterial, 4.5F, -1.8F, settings));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemgroup) -> {
            itemgroup.add(registeredItem);
        });
        return registeredItem;
    }
    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null , user.getBlockPos(), SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            Extendomerald.LOGGER.info("Fireball launched!");
            FireballEntity fireballEntity = new FireballEntity(EntityType.FIREBALL, world);
            fireballEntity.setVelocity(user, user.getPitch(), user.getYaw(), 2.0F, 1.5F, 1.0F);
            world.spawnEntity(fireballEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return ActionResult.SUCCESS;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 0));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 2));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

}