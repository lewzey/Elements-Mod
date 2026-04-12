package net.loos.elementsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.loos.elementsmod.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.FOREST,
                BiomeKeys.FLOWER_FOREST,
                BiomeKeys.DARK_FOREST,
                BiomeKeys.BIRCH_FOREST,
                BiomeKeys.PLAINS,
                BiomeKeys.SUNFLOWER_PLAINS,
                BiomeKeys.MEADOW
        ), SpawnGroup.CREATURE, ModEntities.BUTTERFLY, 50, 4, 8);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.JUNGLE,
                BiomeKeys.DARK_FOREST,
                BiomeKeys.DRIPSTONE_CAVES,
                BiomeKeys.DESERT,
                BiomeKeys.GROVE,
                BiomeKeys.SWAMP,
                BiomeKeys.SAVANNA
        ), SpawnGroup.CREATURE, ModEntities.SPARK_SNAKE, 20, 3, 5);


        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(
                BiomeKeys.COLD_OCEAN,
                BiomeKeys.DEEP_LUKEWARM_OCEAN,
                BiomeKeys.DEEP_OCEAN,
                BiomeKeys.WARM_OCEAN,
                BiomeKeys.RIVER,
                BiomeKeys.DEEP_COLD_OCEAN,
                BiomeKeys.LUKEWARM_OCEAN,
                BiomeKeys.OCEAN
        ), SpawnGroup.WATER_AMBIENT, ModEntities.LUMINOUS_RAY, 70, 3, 5);

        SpawnRestriction.register(ModEntities.BUTTERFLY, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
