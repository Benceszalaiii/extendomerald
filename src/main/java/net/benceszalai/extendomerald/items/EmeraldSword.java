package net.benceszalai.extendomerald.items;

import net.benceszalai.extendomerald.Extendomerald;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class EmeraldSword extends SwordItem {

    public EmeraldSword(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 0));
        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 2));
        return true;
    }
}
