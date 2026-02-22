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
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ONE_GRASS_GEM_ORE_PLACED = registerKey("one_grass_gem_ore_placed");
    public static final RegistryKey<PlacedFeature> MULTIPLE_GRASS_GEM_ORES_PLACED = registerKey("multiple_grass_gem_ores_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context,ONE_GRASS_GEM_ORE_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.ONE_GRASS_GEM_ORE),
                ModOrePlacement.modifiersWithCount(100, HeightRangePlacementModifier.uniform(YOffset.fixed(60), YOffset.fixed(120))));
        register(context,MULTIPLE_GRASS_GEM_ORES_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.MULTIPLE_GRASS_GEM_ORES),
                ModOrePlacement.modifiersWithCount(80, HeightRangePlacementModifier.uniform(YOffset.fixed(60), YOffset.fixed(120))));
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