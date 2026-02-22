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
        SpawnRestriction.register(ModEntities.BUTTERFLY, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
