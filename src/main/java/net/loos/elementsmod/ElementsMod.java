package net.loos.elementsmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.entity.ModEntities;
import net.loos.elementsmod.entity.custom.ButterflyEntity;
import net.loos.elementsmod.item.ModItemGroups;
import net.loos.elementsmod.item.ModItems;
import net.loos.elementsmod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementsMod implements ModInitializer {
	public static final String MOD_ID = "elementsmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		FabricDefaultAttributeRegistry.register(ModEntities.BUTTERFLY, ButterflyEntity.createAttributes());
	}
}