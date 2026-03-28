package net.loos.elementsmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.entity.ModEntities;
import net.loos.elementsmod.entity.custom.ButterflyEntity;
import net.loos.elementsmod.item.ModItemGroups;
import net.loos.elementsmod.item.ModItems;
import net.loos.elementsmod.util.HammerUsageEvent;
import net.loos.elementsmod.util.ModLootTableModifiers;
import net.loos.elementsmod.world.gen.ModWorldGeneration;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import org.intellij.lang.annotations.Identifier;
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
		ModLootTableModifiers.modifyLootTables();

		PlayerBlockBreakEvents.BEFORE.register((new HammerUsageEvent()));
		FabricDefaultAttributeRegistry.register(ModEntities.BUTTERFLY, ButterflyEntity.createAttributes());
		CompostingChanceRegistry.INSTANCE.add(ModItems.BLOOM_CROWN,0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.FLUTTERBLOOM_SEEDS,0.25f);

	}
}