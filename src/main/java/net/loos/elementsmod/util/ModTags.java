package net.loos.elementsmod.util;

import net.minecraft.item.SwordItem;
import net.minecraft.registry.tag.TagKey;
import net.loos.elementsmod.ElementsMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SPARK_STONE_TOOL = createTag("needs_spark_stone_tool");
        public static final TagKey<Block> INCORRECT_FOR_SPARK_STONE_TOOL = createTag("incorrect_for_spark_stone_tool");
        public static final TagKey<Block> NEEDS_GRASS_GEM_TOOL = createTag("needs_grass_gem_tool");
        public static final TagKey<Block> INCORRECT_FOR_GRASS_GEM_TOOL = createTag("incorrect_for_grass_gem_tool");
        public static final TagKey<Block> NEEDS_HYDROCITE_TOOL = createTag("needs_hydrocite_tool");
        public static final TagKey<Block> INCORRECT_FOR_HYDROCITE_TOOL = createTag("incorrect_for_hydrocite_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ElementsMod.MOD_ID, name));
        }
    }


    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ElementsMod.MOD_ID, name));
        }
    }

    public class Biomes {
        public static final TagKey<Biome> GRASS_GEM_BIOMES = createTag("grass_gem_biomes");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(ElementsMod.MOD_ID, name));
        }
    }

}
