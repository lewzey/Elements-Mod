package net.loos.elementsmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loos.elementsmod.ElementsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // GRASS
    public static final Item GRASS_GEM = registerItem("grass_gem",new Item(new Item.Settings()));
    public static final Item RAW_GRASS_GEM = registerItem("raw_grass_gem", new Item(new Item.Settings()));


    // AIR
    public static final Item AIR_BAR = registerItem("air_bar", new Item(new Item.Settings()));
    public static final Item AIR_ORE = registerItem("air_ore", new Item(new Item.Settings()));

    //FIRE


    // WATER
    public static final Item HYDROCITE_GEM = registerItem("hydrocite_gem", new Item(new Item.Settings()));
    public static final Item HYDROCITE_SHARD = registerItem("hydrocite_shard", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ElementsMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ElementsMod.LOGGER.info("Registering Mod Items for " + ElementsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(GRASS_GEM);
            entries.add (RAW_GRASS_GEM);


            entries.add(AIR_BAR);
            entries.add(AIR_ORE);

            entries.add(HYDROCITE_GEM);
            entries.add(HYDROCITE_SHARD);
        });
    }

}
