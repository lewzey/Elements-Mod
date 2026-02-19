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
                        entries.add(ModItems.BLOOM_STAFF);
                        entries.add(ModBlocks.GRASS_GEM_ORE);
                        entries.add(ModBlocks.GRASS_GEM_BLOCK);

                        entries.add(ModItems.AETHERIUS);
                        entries.add(ModItems.AERIS_CONCENTRATE);
                        entries.add(ModItems.AERIS_VAPOR);
                        entries.add(ModBlocks.AERIS_VAPOR_BLOCK);
                        entries.add(ModBlocks.AERIS_BLOCK);

                        entries.add(ModItems.HYDROCITE_GEM);
                        entries.add(ModItems.HYDROCITE_SHARD);
                        entries.add(ModBlocks.HYDROCITE_ORE);
                        entries.add(ModBlocks.HYDROCITE_BLOCK);
                    }).build()
    );
    public static final ItemGroup GRASS_GEM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ElementsMod.MOD_ID, "grass_gem_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.GRASS_GEM))
                    .displayName(Text.translatable("itemgroup.elements.grass_gem_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GRASS_GEM);
                        entries.add(ModItems.RAW_GRASS_GEM);
                        entries.add(ModItems.BLOOM_STAFF);
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


    public static void registerItemGroups () {
        ElementsMod.LOGGER.info("Registering Item Groups for " + ElementsMod.MOD_ID );
    }
}
