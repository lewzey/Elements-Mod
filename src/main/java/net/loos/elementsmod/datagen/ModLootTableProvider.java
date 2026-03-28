package net.loos.elementsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.block.custom.FlutterbloomCropBlock;
import net.loos.elementsmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import javax.swing.plaf.nimbus.State;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GRASS_GEM_BLOCK);

        addDrop(ModBlocks.GRASS_GEM_ORE, oreDrops(ModBlocks.GRASS_GEM_ORE, ModItems.RAW_GRASS_GEM));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.FLUTTERBLOOM_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(FlutterbloomCropBlock.AGE, FlutterbloomCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.FLUTTERBLOOM_CROP, this.cropDrops(ModBlocks.FLUTTERBLOOM_CROP, ModItems.FLUTTERBLOOM, ModItems.FLUTTERBLOOM_SEEDS, builder2));
    }

    //call this if blocks drop multiple items
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
