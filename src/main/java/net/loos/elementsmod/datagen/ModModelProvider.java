package net.loos.elementsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

//custom item models do not go here
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRASS_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRASS_GEM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPARK_STONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPARK_STONE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AERIS_VAPOR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AERIS_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HYDROCITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HYDROCITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GRASS_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GRASS_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOM_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUTTERFLY_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.registerArmor((ArmorItem) ModItems.GRASS_GEM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GRASS_GEM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GRASS_GEM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GRASS_GEM_BOOTS);


        itemModelGenerator.register(ModItems.SPARK_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SPARK_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPARK_STONE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.AERIS_CONCENTRATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AERIS_VAPOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHERIUS, Models.GENERATED);

        itemModelGenerator.register(ModItems.HYDROCITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HYDROCITE_SHARD, Models.GENERATED);

    }

}
