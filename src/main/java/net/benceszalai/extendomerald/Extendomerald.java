package net.benceszalai.extendomerald;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Extendomerald implements ModInitializer {
	public static final String MOD_ID = "extendomerald";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.initialize();
	}
}