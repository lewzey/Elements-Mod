package net.loos.elementsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.loos.elementsmod.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);

    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GRASS_GEM_BLOCK)
                .add(ModBlocks.HYDROCITE_BLOCK)
                .add(ModBlocks.HYDROCITE_ORE)
                .add(ModBlocks.SPARK_STONE_BLOCK)
                .add(ModBlocks.SPARK_STONE_ORE);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.GRASS_GEM_ORE)
                .add(ModBlocks.AERIS_BLOCK)
                .add(ModBlocks.AERIS_VAPOR_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SPARK_STONE_BLOCK)
                .add(ModBlocks.SPARK_STONE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GRASS_GEM_ORE)
                .add(ModBlocks.GRASS_GEM_BLOCK);

        //for water and air, there is no needs tool for netherite+ in this version, only diamond+
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.HYDROCITE_BLOCK)
                .add(ModBlocks.HYDROCITE_ORE)
                .add(ModBlocks.AERIS_BLOCK)
                .add(ModBlocks.AERIS_VAPOR_BLOCK);
    }
}
