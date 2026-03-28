package net.loos.elementsmod.item;

import net.loos.elementsmod.ElementsMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> GRASS_GEM_ARMOR_MATERIAL = registerArmorMaterial("grass_gem",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.BODY, 9);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(ModItems.GRASS_GEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ElementsMod.MOD_ID,"grass_gem"))),0, 0));

    public static final RegistryEntry<ArmorMaterial> SPARK_STONE_ARMOR_MATERIAL = registerArmorMaterial("spark_stone",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.BODY, 8);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> Ingredient.ofItems(ModItems.SPARK_STONE),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ElementsMod.MOD_ID,"spark_stone"))),0, 0));
    public static final RegistryEntry<ArmorMaterial> HYDROCITE_ARMOR_MATERIAL = registerArmorMaterial("hydrocite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.BODY, 11);
            }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.HYDROCITE_GEM),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ElementsMod.MOD_ID,"hydrocite_armor"))), 3.0f, 0.1f));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(ElementsMod.MOD_ID, name), material.get());
    }


}
