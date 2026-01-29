package net.loos.elementsmod;

import net.fabricmc.api.ModInitializer;

import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementsMod implements ModInitializer {
	public static final String MOD_ID = "elementsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}