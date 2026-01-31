package net.loos.elementsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.item.custom.Aetherius;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //general
    public static final Item ELEMENTS_MOD_ICON = registerItem("elements_mod_icon",new Item(new Item.Settings()));



    // GRASS
    public static final Item GRASS_GEM = registerItem("grass_gem",new Item(new Item.Settings()));
    public static final Item RAW_GRASS_GEM = registerItem("raw_grass_gem", new Item(new Item.Settings()));


    // AIR
    public static final Item AERIS_CONCENTRATE = registerItem("aeris_concentrate", new Item(new Item.Settings()));
    public static final Item AERIS_VAPOR = registerItem("aeris_vapor", new Item(new Item.Settings()));

    public static final Item AETHERIUS = registerItem("aetherius", new Aetherius(new Item.Settings()));
    //FIRE


    // WATER


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ElementsMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ElementsMod.LOGGER.info("Registering Mod Items for " + ElementsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ELEMENTS_MOD_ICON);

            entries.add(GRASS_GEM);
            entries.add(RAW_GRASS_GEM);


            entries.add(AERIS_CONCENTRATE);
            entries.add(AERIS_VAPOR);
            entries.add(AETHERIUS);
        });
    }

}
