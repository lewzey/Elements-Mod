package net.loos.elementsmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loos.elementsmod.ElementsMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block GRASS_GEM_BLOCK = registerBlock("grass_gem_block",
            new Block(AbstractBlock.Settings.create().strength(4f).
                    requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block GRASS_GEM_ORE = registerBlock("grass_gem_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3f).
                    requiresTool().sounds(BlockSoundGroup.ROOTED_DIRT)));



    private static Block registerBlock (String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ElementsMod.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ElementsMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        ElementsMod.LOGGER.info("Registering Mod Blocks for" + ElementsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.GRASS_GEM_BLOCK);
            entries.add(ModBlocks.GRASS_GEM_ORE);
        });
    }
}
