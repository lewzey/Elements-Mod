package net.loos.elementsmod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.loos.elementsmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID = Identifier.of("minecraft", "blocks/short_grass");
    private static final Identifier FERN_ID = Identifier.of("minecraft", "blocks/fern");
    private static final Identifier SHIPWRECK_SUPPLY_ID = Identifier.of("minecraft", "chests/shipwreck_supply");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(GRASS_BLOCK_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.FLUTTERBLOOM_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            // aetheria seed drops above Y=150 25 percent chance
            if(GRASS_BLOCK_ID.equals(key.getValue()) || FERN_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .conditionally(LocationCheckLootCondition.builder(
                                LocationPredicate.Builder.create().y(NumberRange.DoubleRange.atLeast(150.0))))
                        .with(ItemEntry.builder(ModItems.AETHERIA_SEEDS));

                tableBuilder.pool(poolBuilder.build());
            }

            // aetheria seeds drop in shipwreck
            if(SHIPWRECK_SUPPLY_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.AETHERIA_SEEDS)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f))));

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.ANCIENT_CITY_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.BLOOM_SHATTERER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(LootTables.VILLAGE_ARMORER_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.BLOOM_STICK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (LootTables.FISHING_TREASURE_GAMEPLAY.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.AQUABLOOM_SEEDS))
                        .conditionally(RandomChanceLootCondition.builder(0.25f));

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}