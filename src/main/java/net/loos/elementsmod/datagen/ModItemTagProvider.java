package net.loos.elementsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.loos.elementsmod.item.ModItems;
import net.loos.elementsmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.AERIS_CONCENTRATE)
                .add(ModItems.AERIS_VAPOR)
                .add(ModItems.AETHERIUS)
                .add(ModItems.COSMOLIGHT)

                .add(ModItems.BLOOM_CROWN)
                .add(ModItems.BLOOM_STAFF)
                .add(ModItems.BLOOM_STICK)
                .add(ModItems.BUTTERFLY_SPAWN_EGG)
                .add(ModItems.ELEMENTS_MOD_ICON)
                .add(ModItems.GRASS_GEM)
                .add(ModItems.GRASS_GEM_BOOTS)
                .add(ModItems.GRASS_GEM_CHESTPLATE)
                .add(ModItems.GRASS_GEM_HELMET)
                .add(ModItems.GRASS_GEM_LEGGINGS)
                .add(ModItems.FLUTTERBLOOM)
                .add(ModItems.FLUTTERBLOOM_SEEDS)
                .add(ModItems.ELEMENTS_MOD_ICON)
                .add(ModItems.HYDROCITE_GEM)
                .add(ModItems.HYDROCITE_SHARD)
                .add(ModItems.HYDROCITE_HELMET)
                .add(ModItems.HYDROCITE_CHESTPLATE)
                .add(ModItems.HYDROCITE_LEGGINGS)
                .add(ModItems.HYDROCITE_BOOTS)
                .add(ModItems.WATER_STAFF)
                .add(ModItems.RAW_GRASS_GEM)
                .add(ModItems.RAW_SPARK_STONE)
                .add(ModItems.SPARK_STONE)
                .add(ModItems.SPARK_STONE_SWORD);
    }

}
