package net.loos.elementsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        //grass
        List<ItemConvertible> GRASS_GEM_SMELTABLES = List.of(ModItems.RAW_GRASS_GEM, ModBlocks.GRASS_GEM_ORE);

        offerSmelting(recipeExporter, GRASS_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GRASS_GEM, 0.20f, 180, "grass_gem");
        offerBlasting(recipeExporter, GRASS_GEM_SMELTABLES, RecipeCategory.MISC, ModItems.GRASS_GEM, 0.20f, 180, "grass_gem");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GRASS_GEM, RecipeCategory.DECORATIONS, ModBlocks.GRASS_GEM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLOOM_STICK)
                .pattern("@$@")
                .pattern("$S$")
                .pattern("@$@")
                .input('$', ModItems.GRASS_GEM)
                .input('@', ItemTags.FLOWERS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.GRASS_GEM), conditionsFromItem(ModItems.GRASS_GEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLOOM_STAFF)
                .pattern("$@$")
                .pattern(" S ")
                .pattern(" S ")
                .input('$', ModItems.GRASS_GEM)
                .input('@', Items.GOLD_INGOT)
                .input('S', ModItems.BLOOM_STICK)
                .criterion(hasItem(ModItems.GRASS_GEM), conditionsFromItem(ModItems.GRASS_GEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLOOM_CROWN)
                .pattern("S$S")
                .pattern("S S")
                .input('$', ModItems.GRASS_GEM)
                .input('S', ModItems.BLOOM_STICK)
                .criterion(hasItem(ModItems.GRASS_GEM), conditionsFromItem(ModItems.GRASS_GEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GRASS_GEM_HELMET)
                .pattern("$$$")
                .pattern("$ $")
                .input('$', ModItems.GRASS_GEM)
                .criterion(hasItem(ModItems.GRASS_GEM), conditionsFromItem(ModItems.GRASS_GEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GRASS_GEM_CHESTPLATE)
                .pattern("$ $")
                .pattern("$$$")
                .pattern("$$$")
                .input('$', ModItems.GRASS_GEM)
                .criterion(hasItem(ModItems.GRASS_GEM), conditionsFromItem(ModItems.GRASS_GEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GRASS_GEM_LEGGINGS)
                .pattern("$$$")
                .pattern("$ $")
                .pattern("$ $")
                .input('$', ModItems.GRASS_GEM)
                .criterion(hasItem(ModItems.GRASS_GEM), conditionsFromItem(ModItems.GRASS_GEM))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GRASS_GEM_BOOTS)
                .pattern("$ $")
                .pattern("$ $")
                .input('$', ModItems.GRASS_GEM)
                .criterion(hasItem(ModItems.GRASS_GEM), conditionsFromItem(ModItems.GRASS_GEM))
                .offerTo(recipeExporter);

        //water
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.HYDROCITE_GEM, RecipeCategory.DECORATIONS, ModBlocks.HYDROCITE_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYDROCITE_GEM)
                .pattern("$$$")
                .pattern("$$$")
                .pattern("$$$")
                .input('$', ModItems.HYDROCITE_SHARD)
                .criterion(hasItem(ModItems.HYDROCITE_SHARD), conditionsFromItem(ModItems.HYDROCITE_SHARD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WATER_STAFF)
                .pattern("N$N")
                .pattern("$S$")
                .pattern("@")
                .input('$', ModItems.HYDROCITE_GEM)
                .input('S', Items.NETHER_STAR)
                .input('N',Items.NETHERITE_INGOT)
                .input('@', Items.STICK)
                .criterion(hasItem(ModItems.HYDROCITE_GEM), conditionsFromItem(ModItems.HYDROCITE_GEM))
                .offerTo(recipeExporter);


        //fire
        List<ItemConvertible> SPARK_STONE_SMELTABLES = List.of(ModItems.RAW_SPARK_STONE, ModBlocks.SPARK_STONE_ORE);

        offerSmelting(recipeExporter, SPARK_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.SPARK_STONE, 0.20f, 170, "spark_stone");
        offerBlasting(recipeExporter, SPARK_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.SPARK_STONE, 0.20f, 70, "spark_stone");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SPARK_STONE, RecipeCategory.DECORATIONS, ModBlocks.SPARK_STONE_BLOCK);

        //air
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.AERIS_CONCENTRATE, RecipeCategory.DECORATIONS, ModBlocks.AERIS_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AERIS_CONCENTRATE)
                .pattern("VV")
                .pattern("VV")
                .input('V', ModItems.AERIS_VAPOR)
                .criterion(hasItem(ModItems.AERIS_VAPOR), conditionsFromItem(ModItems.AERIS_VAPOR))
                .offerTo(recipeExporter, Identifier.of(ElementsMod.MOD_ID, "aeris_concentrate_from_aeris_vapor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AETHERIUS)
                .pattern(" V ")
                .pattern("VXV")
                .pattern(" Z ")
                .input('V', ModItems.AERIS_CONCENTRATE)
                .input('X', Items.NETHER_STAR)
                .input('Z', Items.STICK)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .offerTo(recipeExporter);

    }

}
