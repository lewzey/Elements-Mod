package net.loos.elementsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.loos.elementsmod.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.FOREST,
                BiomeKeys.FLOWER_FOREST,
                BiomeKeys.DARK_FOREST,
                BiomeKeys.BIRCH_FOREST,
                BiomeKeys.PLAINS,
                BiomeKeys.SUNFLOWER_PLAINS,
                BiomeKeys.MEADOW,
                BiomeKeys.SAVANNA),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ONE_GRASS_GEM_ORE_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.FOREST,
                BiomeKeys.FLOWER_FOREST,
                BiomeKeys.DARK_FOREST,
                BiomeKeys.BIRCH_FOREST,
                BiomeKeys.PLAINS,
                BiomeKeys.SUNFLOWER_PLAINS,
                BiomeKeys.MEADOW,
                BiomeKeys.SAVANNA),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.MULTIPLE_GRASS_GEM_ORES_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ONE_SPARK_STONE_ORE_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.MULTIPLE_SPARK_STONE_ORES_PLACED);
    }
}
