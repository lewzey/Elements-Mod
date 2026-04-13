package net.loos.elementsmod.world;

import net.loos.elementsmod.ElementsMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ONE_GRASS_GEM_ORE_PLACED = registerKey("one_grass_gem_ore_placed");
    public static final RegistryKey<PlacedFeature> MULTIPLE_GRASS_GEM_ORES_PLACED = registerKey("multiple_grass_gem_ores_placed");
    public static final RegistryKey<PlacedFeature> ONE_SPARK_STONE_ORE_PLACED = registerKey("one_spark_stone_ore");
    public static final RegistryKey<PlacedFeature> MULTIPLE_SPARK_STONE_ORES_PLACED = registerKey("multiple_spark_stone_ores");
    public static final RegistryKey<PlacedFeature> AERIS_VAPOR_BLOCK_PLACED = registerKey("aeris_vapor_block_placed");
    public static final RegistryKey<PlacedFeature> HYDROCITE_ORE_PLACED_KEY = registerKey("hydrocite_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);


        register(context,ONE_GRASS_GEM_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ONE_GRASS_GEM_ORE),
                ModOrePlacement.modifiersWithCount(100, HeightRangePlacementModifier.uniform(YOffset.fixed(60), YOffset.fixed(120))));
        register(context,MULTIPLE_GRASS_GEM_ORES_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MULTIPLE_GRASS_GEM_ORES),
                ModOrePlacement.modifiersWithCount(80, HeightRangePlacementModifier.uniform(YOffset.fixed(60), YOffset.fixed(120))));

        register(context, ONE_SPARK_STONE_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ONE_SPARK_STONE_ORE),
                ModOrePlacement.modifiersWithCount(40, HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(-20))));
        register(context, MULTIPLE_SPARK_STONE_ORES_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MULTIPLE_SPARK_STONE_ORES),
                ModOrePlacement.modifiersWithCount(30, HeightRangePlacementModifier.uniform(YOffset.fixed(-60), YOffset.fixed(-20))));

        //spawn one in every 22x22=512 chunk, very rare
        register(context, AERIS_VAPOR_BLOCK_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.AERIS_VAPOR_BLOCK), RarityFilterPlacementModifier.of(512),
                SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.fixed(150), YOffset.fixed(200)), BiomePlacementModifier.of());

        register(context, HYDROCITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HYDROCITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(80))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ElementsMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}