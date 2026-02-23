package net.loos.elementsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.ModEntities;
import net.loos.elementsmod.item.custom.Aetherius;
import net.loos.elementsmod.item.custom.BloomStaff;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //general
    public static final Item ELEMENTS_MOD_ICON = registerItem("elements_mod_icon",new Item(new Item.Settings()));



    // GRASS
    public static final Item GRASS_GEM = registerItem("grass_gem",new Item(new Item.Settings()));
    public static final Item RAW_GRASS_GEM = registerItem("raw_grass_gem", new Item(new Item.Settings()));
    public static final Item BLOOM_STICK = registerItem("bloom_stick",new Item(new Item.Settings()));
    public static final Item BLOOM_STAFF = registerItem("bloom_staff",(new BloomStaff(new Item.Settings().maxDamage(32))));
    public static final Item BLOOM_CROWN = registerItem("bloom_crown", new Item(new Item.Settings()));
    public static final Item GRASS_GEM_HELMET = registerItem("grass_gem_helmet",
            new ArmorItem(ModArmorMaterials.GRASS_GEM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
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

    // AIR
    public static final Item AERIS_CONCENTRATE = registerItem("aeris_concentrate", new Item(new Item.Settings()));
    public static final Item AERIS_VAPOR = registerItem("aeris_vapor", new Item(new Item.Settings()));

    public static final Item AETHERIUS = registerItem("aetherius", new Aetherius(new Item.Settings()));

    //FIRE
    public static final Item RAW_SPARK_STONE = registerItem("raw_spark_stone", new Item(new Item.Settings()));
    public static final Item SPARK_STONE = registerItem("spark_stone", new Item(new Item.Settings()));
    public static final Item SPARK_STONE_SWORD = registerItem("spark_stone_sword",
            new SwordItem(ModToolMaterials.SPARK_STONE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SPARK_STONE, 3, -2.4f))));

    // WATER
    public static final Item HYDROCITE_GEM = registerItem("hydrocite_gem", new Item(new Item.Settings()));
    public static final Item HYDROCITE_SHARD = registerItem("hydrocite_shard", new Item(new Item.Settings()));

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

            entries.add(SPARK_STONE);
            entries.add(RAW_SPARK_STONE);
            entries.add(SPARK_STONE_SWORD);

            entries.add(AERIS_CONCENTRATE);
            entries.add(AERIS_VAPOR);
            entries.add(AETHERIUS);

            entries.add(HYDROCITE_GEM);
            entries.add(HYDROCITE_SHARD);
        });
    }

}
