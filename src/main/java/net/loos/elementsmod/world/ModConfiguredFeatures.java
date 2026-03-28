package net.loos.elementsmod.world;

import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ? >> ONE_GRASS_GEM_ORE = registerKey("one_grass_gem_ore");
    public static final RegistryKey<ConfiguredFeature<?, ? >> MULTIPLE_GRASS_GEM_ORES = registerKey("multiple_grass_gem_ores");
    public static final RegistryKey<ConfiguredFeature<?, ? >> ONE_SPARK_STONE_ORE = registerKey("one_spark_stone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ? >> MULTIPLE_SPARK_STONE_ORES = registerKey("multiple_spark_stone_ores");

    public static final RegistryKey<ConfiguredFeature<?, ? >> AERIS_VAPOR_BLOCK = registerKey("aeris_vapor_block");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest dirtReplaceables = new BlockMatchRuleTest(Blocks.DIRT);
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreFeatureConfig.Target> dirtGrassGemOres =
                List.of(OreFeatureConfig.createTarget(dirtReplaceables, ModBlocks.GRASS_GEM_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> stoneSparkStoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SPARK_STONE_ORE.getDefaultState()));


        SimpleBlockFeatureConfig vaporBlockConfig = new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.AERIS_VAPOR_BLOCK));

        // this is how I make the clouds spawn
        RandomPatchFeatureConfig cloudConfig = new RandomPatchFeatureConfig(96, 7, 1,
                RegistryEntry.of(new PlacedFeature(RegistryEntry.of(new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, vaporBlockConfig)),
                        List.of(BlockFilterPlacementModifier.of(BlockPredicate.matchingBlocks(Blocks.AIR)))
                ))
        );
        register(context, ONE_GRASS_GEM_ORE, Feature.ORE, new OreFeatureConfig(dirtGrassGemOres, 1));
        register(context, MULTIPLE_GRASS_GEM_ORES, Feature.ORE, new OreFeatureConfig(dirtGrassGemOres, 3));

        register(context, ONE_SPARK_STONE_ORE, Feature.ORE, new OreFeatureConfig(stoneSparkStoneOres, 1));
        register(context, MULTIPLE_SPARK_STONE_ORES, Feature.ORE, new OreFeatureConfig(stoneSparkStoneOres, 4));
        register(context, AERIS_VAPOR_BLOCK, Feature.RANDOM_PATCH, cloudConfig);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ElementsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}