package net.benceszalai.extendomerald;

import net.benceszalai.extendomerald.utils.EmeraldVeinMinerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Extendomerald implements ModInitializer {
	public static final String MOD_ID = "extendomerald";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.initialize();
		ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
	}
	private void onServerTick(MinecraftServer server) {
		// Loop through all players on the server
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
			// Check if the player is holding the desired item in their main hand
			if (player.getMainHandStack().getItem() == ModItems.EMERALD_PICKAXE) {
				// Apply Luck II (duration in ticks, amplifier starts at 0)
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20, 1));
			}
		};
		PlayerBlockBreakEvents.BEFORE.register(new EmeraldVeinMinerUsageEvent());
	}

}