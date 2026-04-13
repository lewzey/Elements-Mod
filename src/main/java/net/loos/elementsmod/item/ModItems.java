package net.loos.elementsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.entity.ModEntities;
import net.loos.elementsmod.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    // General
    public static final Item ELEMENTS_MOD_ICON = registerItem("elements_mod_icon", new Item(new Item.Settings()));

    // GRASS
    public static final Item GRASS_GEM = registerItem("grass_gem", new Item(new Item.Settings()));
    public static final Item RAW_GRASS_GEM = registerItem("raw_grass_gem", new Item(new Item.Settings()));
    public static final Item BLOOM_STICK = registerItem("bloom_stick", new Item(new Item.Settings()));
    public static final Item BLOOM_SHATTERER = registerItem("bloom_shatterer", new HammerItem(ModToolMaterials.GRASS_GEM, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.GRASS_GEM, 8, -3.5f))));
    public static final Item BLOOM_STAFF = registerItem("bloom_staff", (new BloomStaff(new Item.Settings().maxDamage(32))));
    public static final Item BLOOM_CROWN = registerItem("bloom_crown", new Item(new Item.Settings()));
    public static final Item GRASS_GEM_HELMET = registerItem("grass_gem_helmet",
            new ModArmorItem(ModArmorMaterials.GRASS_GEM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item GRASS_GEM_CHESTPLATE = registerItem("grass_gem_chestplate",
            new ArmorItem(ModArmorMaterials.GRASS_GEM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item GRASS_GEM_LEGGINGS = registerItem("grass_gem_leggings",
            new ArmorItem(ModArmorMaterials.GRASS_GEM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item GRASS_GEM_BOOTS = registerItem("grass_gem_boots",
            new ArmorItem(ModArmorMaterials.GRASS_GEM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item BUTTERFLY_SPAWN_EGG = registerItem("butterfly_spawn_egg",
            new SpawnEggItem(ModEntities.BUTTERFLY, 0xede512, 0xd32cc7, new Item.Settings()));
    public static final Item FLUTTERBLOOM = registerItem("flutterbloom", new Item(new Item.Settings().food(ModFoodComponents.FLUTTERBLOOM)));
    public static final Item FLUTTERBLOOM_SEEDS = registerItem("flutterbloom_seeds",
            new AliasedBlockItem(ModBlocks.FLUTTERBLOOM_CROP, new Item.Settings()));

    // AIR (AERIS)
    public static final Item AERIS_CONCENTRATE = registerItem("aeris_concentrate", new Item(new Item.Settings()));
    public static final Item AERIS_VAPOR = registerItem("aeris_vapor", new Item(new Item.Settings()));
    public static final Item AETHERIUS = registerItem("aetherius", new Aetherius(new Item.Settings().rarity(Rarity.EPIC)));
    public static final Item COSMOLIGHT = registerItem("cosmolight", new Cosmolight(new Item.Settings().rarity(Rarity.EPIC)));

    public static final Item AERIS_HELMET = registerItem("aeris_helmet",
            new ModArmorItem(ModArmorMaterials.AERIS_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item AERIS_CHESTPLATE = registerItem("aeris_chestplate",
            new ArmorItem(ModArmorMaterials.AERIS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage((ArmorItem.Type.CHESTPLATE.getMaxDamage(12)))));
    public static final Item AERIS_LEGGINGS = registerItem("aeris_leggings",
            new ArmorItem(ModArmorMaterials.AERIS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage((ArmorItem.Type.LEGGINGS.getMaxDamage(12)))));
    public static final Item AERIS_BOOTS = registerItem("aeris_boots",
            new ArmorItem(ModArmorMaterials.AERIS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage((ArmorItem.Type.BOOTS.getMaxDamage(12)))));

    public static final Item AETHERIA_CROP = registerItem("aetheria_crop", new Item(new Item.Settings()));
    public static final Item AETHERIA_SEEDS = registerItem("aetheria_seeds",
            new AliasedBlockItem(ModBlocks.AETHERIA_CROP, new Item.Settings()));

    // FIRE
    public static final Item RAW_SPARK_STONE = registerItem("raw_spark_stone", new Item(new Item.Settings()));
    public static final Item SPARK_STONE = registerItem("spark_stone", new Item(new Item.Settings()));
    public static final Item SPARK_STONE_SWORD = registerItem("spark_stone_sword",
            new SparkStoneSwordItem(ModToolMaterials.SPARK_STONE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SPARK_STONE, 3, -2.4f))));
    public static final Item SPARK_STAFF = registerItem("spark_staff", new SparkStaff(new Item.Settings()));
    public static final Item SPARK_STICK = registerItem("spark_stick", new Item(new Item.Settings()));

    public static final Item SPARK_STONE_HELMET = registerItem("spark_stone_helmet",
            new ModArmorItem(ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item SPARK_STONE_CHESTPLATE = registerItem("spark_stone_chestplate",
            new ArmorItem(ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item SPARK_STONE_LEGGINGS = registerItem("spark_stone_leggings",
            new ArmorItem(ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));
    public static final Item SPARK_STONE_BOOTS = registerItem("spark_stone_boots",
            new ArmorItem(ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage((ArmorItem.Type.HELMET.getMaxDamage(12)))));

    public static final Item SPARK_SNAKE_SPAWN_EGG = registerItem("spark_snake_spawn_egg",
            new SpawnEggItem(ModEntities.SPARK_SNAKE, 0x3b2f2f, 0xff6a00, new Item.Settings()));
    public static final Item BLAZEBUD = registerItem("blazebud", new Item(new Item.Settings()));
    public static final Item BLAZEBUD_SEEDS = registerItem("blazebud_seeds",
            new AliasedBlockItem(ModBlocks.BLAZEBUD_CROP, new Item.Settings()));

    public static final Item BIRD_SPAWN_EGG = registerItem("bird_spawn_egg",
            new SpawnEggItem(ModEntities.BIRD, 0xe0f7fa, 0xffd54f, new Item.Settings()));

    // WATER
    public static final Item HYDROCITE_GEM = registerItem("hydrocite_gem", new Item(new Item.Settings()));
    public static final Item HYDROCITE_SHARD = registerItem("hydrocite_shard", new Item(new Item.Settings()));
    public static final Item WATER_STAFF = registerItem("water_staff",
            new WaterStaff(ModToolMaterials.HYDROCITE, new Item.Settings()));
    public static final Item HYDROCITE_HELMET = registerItem("hydrocite_helmet",
            new ArmorItem(ModArmorMaterials.HYDROCITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item HYDROCITE_CHESTPLATE = registerItem("hydrocite_chestplate",
            new ArmorItem(ModArmorMaterials.HYDROCITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item HYDROCITE_LEGGINGS = registerItem("hydrocite_leggings",
            new ArmorItem(ModArmorMaterials.HYDROCITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item HYDROCITE_BOOTS = registerItem("hydrocite_boots",
            new ArmorItem(ModArmorMaterials.HYDROCITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));
    public static final Item LUMINOUS_RAY_SPAWN_EGG = registerItem("luminous_ray_spawn_egg",
            new SpawnEggItem(ModEntities.LUMINOUS_RAY, 0x000080, 0x39FF14, new Item.Settings()));
    public static final Item AQUABLOOM = registerItem("aquabloom", new Item(new Item.Settings()));
    public static final Item AQUABLOOM_SEEDS = registerItem("aquabloom_seeds",
            new AliasedBlockItem(ModBlocks.AQUABLOOM_CROP, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ElementsMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ElementsMod.LOGGER.info("Registering Mod Items for " + ElementsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ELEMENTS_MOD_ICON);
            entries.add(GRASS_GEM);
            entries.add(RAW_GRASS_GEM);
            entries.add(BLOOM_STICK);
            entries.add(BLOOM_STAFF);
            entries.add(BLOOM_CROWN);
            entries.add(GRASS_GEM_HELMET);
            entries.add(GRASS_GEM_CHESTPLATE);
            entries.add(GRASS_GEM_LEGGINGS);
            entries.add(GRASS_GEM_BOOTS);
            entries.add(FLUTTERBLOOM);
            entries.add(FLUTTERBLOOM_SEEDS);
            entries.add(BLOOM_SHATTERER);

            entries.add(SPARK_STONE);
            entries.add(RAW_SPARK_STONE);
            entries.add(SPARK_STONE_SWORD);
            entries.add(SPARK_STICK);
            entries.add(SPARK_STONE_HELMET);
            entries.add(SPARK_STONE_CHESTPLATE);
            entries.add(SPARK_STONE_LEGGINGS);
            entries.add(SPARK_STONE_BOOTS);
            entries.add(SPARK_SNAKE_SPAWN_EGG);
            entries.add(BLAZEBUD);
            entries.add(BLAZEBUD_SEEDS);

            entries.add(AETHERIUS);
            entries.add(COSMOLIGHT);
            entries.add(AERIS_CONCENTRATE);
            entries.add(AERIS_VAPOR);
            entries.add(ModBlocks.AERIS_VAPOR_BLOCK);
            entries.add(ModBlocks.AERIS_BLOCK);
            entries.add(AERIS_BOOTS);
            entries.add(AERIS_CHESTPLATE);
            entries.add(AERIS_HELMET);
            entries.add(AERIS_LEGGINGS);
            entries.add(BIRD_SPAWN_EGG);
            entries.add(AETHERIA_SEEDS);
            entries.add(AETHERIA_CROP);

            entries.add(HYDROCITE_GEM);
            entries.add(HYDROCITE_SHARD);
            entries.add(WATER_STAFF);
            entries.add(HYDROCITE_HELMET);
            entries.add(HYDROCITE_CHESTPLATE);
            entries.add(HYDROCITE_LEGGINGS);
            entries.add(HYDROCITE_BOOTS);
            entries.add(LUMINOUS_RAY_SPAWN_EGG);
        });
    }
}