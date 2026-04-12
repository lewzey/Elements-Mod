package net.loos.elementsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ELEMENT_MOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ElementsMod.MOD_ID, "element_mod"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ELEMENTS_MOD_ICON))
                    .displayName(Text.translatable("itemgroup.elements.elements_mod_icon"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GRASS_GEM);
                        entries.add(ModItems.RAW_GRASS_GEM);
                        entries.add(ModItems.BLOOM_STICK);
                        entries.add(ModItems.BLOOM_STAFF);
                        entries.add(ModBlocks.GRASS_GEM_ORE);
                        entries.add(ModBlocks.GRASS_GEM_BLOCK);
                        entries.add(ModItems.BLOOM_CROWN);
                        entries.add(ModItems.BUTTERFLY_SPAWN_EGG);
                        entries.add(ModItems.GRASS_GEM_HELMET);
                        entries.add(ModItems.GRASS_GEM_CHESTPLATE);
                        entries.add(ModItems.GRASS_GEM_LEGGINGS);
                        entries.add(ModItems.GRASS_GEM_BOOTS);
                        entries.add(ModItems.FLUTTERBLOOM);
                        entries.add(ModItems.FLUTTERBLOOM_SEEDS);
                        entries.add(ModItems.BLOOM_SHATTERER);

                        entries.add(ModItems.SPARK_STONE);
                        entries.add(ModItems.RAW_SPARK_STONE);
                        entries.add(ModBlocks.SPARK_STONE_BLOCK);
                        entries.add(ModBlocks.SPARK_STONE_ORE);
                        entries.add(ModItems.SPARK_STONE_SWORD);
                        entries.add(ModItems.SPARK_STAFF);
                        entries.add(ModItems.SPARK_STICK);
                        entries.add(ModItems.SPARK_STONE_HELMET);
                        entries.add(ModItems.SPARK_STONE_CHESTPLATE);
                        entries.add(ModItems.SPARK_STONE_LEGGINGS);
                        entries.add(ModItems.SPARK_STONE_BOOTS);
                        entries.add(ModItems.SPARK_SNAKE_SPAWN_EGG);
                        entries.add(ModItems.BLAZEBUD);
                        entries.add(ModItems.BLAZEBUD_SEEDS);


                        entries.add(ModItems.AETHERIUS);
                        entries.add(ModItems.COSMOLIGHT);
                        entries.add(ModItems.AERIS_CONCENTRATE);
                        entries.add(ModItems.AERIS_VAPOR);
                        entries.add(ModBlocks.AERIS_VAPOR_BLOCK);
                        entries.add(ModBlocks.AERIS_BLOCK);
                        entries.add(ModItems.AERIS_BOOTS);
                        entries.add(ModItems.AERIS_CHESTPLATE);
                        entries.add(ModItems.AERIS_HELMET);
                        entries.add(ModItems.AERIS_LEGGINGS);
                        entries.add(ModItems.BIRD_SPAWN_EGG);



                        entries.add(ModItems.HYDROCITE_GEM);
                        entries.add(ModItems.HYDROCITE_SHARD);
                        entries.add(ModBlocks.HYDROCITE_ORE);
                        entries.add(ModBlocks.HYDROCITE_BLOCK);
                        entries.add(ModItems.WATER_STAFF);
                        entries.add(ModItems.HYDROCITE_HELMET);
                        entries.add(ModItems.HYDROCITE_CHESTPLATE);
                        entries.add(ModItems.HYDROCITE_LEGGINGS);
                        entries.add(ModItems.HYDROCITE_BOOTS);
                        entries.add(ModItems.LUMINOUS_RAY_SPAWN_EGG);
                        entries.add(ModItems.AQUABLOOM);
                        entries.add(ModItems.AQUABLOOM_SEEDS);
                    }).build()
    );
    public static final ItemGroup GRASS_GEM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ElementsMod.MOD_ID, "grass_gem_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GRASS_GEM))
                    .displayName(Text.translatable("itemgroup.elements.grass_gem_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GRASS_GEM);
                        entries.add(ModItems.RAW_GRASS_GEM);
                        entries.add(ModItems.BLOOM_STICK);
                        entries.add(ModItems.BLOOM_STAFF);
                        entries.add(ModItems.BLOOM_CROWN);
                        entries.add(ModItems.BUTTERFLY_SPAWN_EGG);
                        entries.add(ModItems.GRASS_GEM_HELMET);
                        entries.add(ModItems.GRASS_GEM_CHESTPLATE);
                        entries.add(ModItems.GRASS_GEM_LEGGINGS);
                        entries.add(ModItems.GRASS_GEM_BOOTS);
                        entries.add(ModItems.FLUTTERBLOOM);
                        entries.add(ModItems.FLUTTERBLOOM_SEEDS);
                        entries.add(ModItems.BLOOM_SHATTERER);
                    }).build()
    );

    public static final ItemGroup GRASS_GEM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ElementsMod.MOD_ID, "grass_gem_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.GRASS_GEM_ORE))
                    .displayName(Text.translatable("itemgroup.elements.grass_gem_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GRASS_GEM_ORE);
                        entries.add(ModBlocks.GRASS_GEM_BLOCK);
                    }).build()
    );

    public static final ItemGroup SPARK_STONE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ElementsMod.MOD_ID, "spark_stone_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SPARK_STONE))
                    .displayName(Text.translatable("itemgroup.elements.spark_stone_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SPARK_STONE);
                        entries.add(ModItems.RAW_SPARK_STONE);
                        entries.add(ModItems.SPARK_STONE_SWORD);
                        entries.add(ModItems.SPARK_STAFF);
                        entries.add(ModItems.SPARK_STICK);
                        entries.add(ModItems.SPARK_STONE_HELMET);
                        entries.add(ModItems.SPARK_STONE_CHESTPLATE);
                        entries.add(ModItems.SPARK_STONE_LEGGINGS);
                        entries.add(ModItems.SPARK_STONE_BOOTS);
                        entries.add(ModBlocks.SPARK_STONE_ORE);
                        entries.add(ModBlocks.SPARK_STONE_BLOCK);
                        entries.add(ModItems.SPARK_SNAKE_SPAWN_EGG);
                        entries.add(ModItems.BLAZEBUD);
                        entries.add(ModItems.BLAZEBUD_SEEDS);
                    }).build()
    );

    /*
    public static final ItemGroup SPARK_STONE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ElementsMod.MOD_ID, "spark_stone_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SPARK_STONE_ORE))
                    .displayName(Text.translatable("itemgroup.elements.spark_stone_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SPARK_STONE_BLOCK);
                        entries.add(ModBlocks.SPARK_STONE_ORE);
                    }).build()
    );
    */



    public static void registerItemGroups () {
        ElementsMod.LOGGER.info("Registering Item Groups for " + ElementsMod.MOD_ID );
    }
}
