package net.loos.elementsmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.block.custom.AquabloomCropBlock;
import net.loos.elementsmod.block.custom.FlutterbloomCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.loos.elementsmod.block.custom.BlazebudCropBlock;

public class ModBlocks {

    // ground
    public static final Block GRASS_GEM_BLOCK = registerBlock("grass_gem_block",
            new Block(AbstractBlock.Settings.create().strength(4f).
                    requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block GRASS_GEM_ORE = registerBlock("grass_gem_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(3f).
                    requiresTool().sounds(BlockSoundGroup.ROOTED_DIRT)));
    public static final Block FLUTTERBLOOM_CROP = registerBlockWithoutBlockItem("flutterbloom_crop",
            new FlutterbloomCropBlock((AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN))));

    // air
    public static final Block AERIS_VAPOR_BLOCK = registerBlock("aeris_vapor_block",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(5,7),
                    AbstractBlock.Settings.create()
                    .strength(0.5f, 1200f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOL)
                    .nonOpaque()
                    .luminance(state ->5)));


    public static final Block AERIS_BLOCK = registerBlock("aeris_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3f, 1200f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOL)
                    .luminance(state -> 10)));

    //Water
    public static final Block HYDROCITE_BLOCK = registerBlock("hydrocite_block",
            new Block(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .mapColor(MapColor.LAPIS_BLUE)
                    .strength(5f,1200f)
                    .requiresTool()
                    .luminance(state ->15)));
    public static final Block HYDROCITE_ORE = registerBlock("hydrocite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,7),AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.STONE)
                    .mapColor(MapColor.LAPIS_BLUE)
                    .strength(50f,1200f)
                    .requiresTool()
                    .luminance(state ->7)));

    public static final Block AQUABLOOM_CROP = registerBlockWithoutBlockItem("aquabloom_crop",
            new AquabloomCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .luminance(state -> 10)
                    .emissiveLighting((state, world, pos) -> true)
                    .mapColor(MapColor.WATER_BLUE)));

    // Fire
    public static final Block SPARK_STONE_BLOCK = registerBlock("spark_stone_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.COPPER)));

    public static final Block SPARK_STONE_ORE = registerBlock("spark_stone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(2f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.FUNGUS))
    );
    public static final Block BLAZEBUD_CROP = registerBlockWithoutBlockItem("blazebud_crop",
            new BlazebudCropBlock((AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.RED))));

    private static Block registerBlock (String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ElementsMod.MOD_ID, name), block);
    }
    private static Block registerBlockWithoutBlockItem (String name, Block block) {
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
            entries.add(ModBlocks.SPARK_STONE_BLOCK);
            entries.add(ModBlocks.SPARK_STONE_ORE);
            entries.add(ModBlocks.AERIS_VAPOR_BLOCK);
            entries.add(ModBlocks.AERIS_BLOCK);
            entries.add(ModBlocks.HYDROCITE_BLOCK);
            entries.add(ModBlocks.HYDROCITE_ORE);
        });
    }
}
