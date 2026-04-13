package net.loos.elementsmod.block.custom;

import net.loos.elementsmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class AquabloomCropBlock extends CropBlock implements Waterloggable {
    public static final IntProperty AGE = Properties.AGE_2;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final int MAX_AGE = 2;

    public AquabloomCropBlock(Settings settings) {
        super(settings);
        // We set waterlogged to true by default since it's an underwater plant
        setDefaultState(this.stateManager.getDefaultState()
                .with(AGE, 0)
                .with(WATERLOGGED, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE, WATERLOGGED);
    }

    // 1. Strictly Underwater Placement
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos groundPos = pos.down();
        // Check if block at current position is a water source
        boolean isUnderwater = world.getFluidState(pos).isStill();
        return isUnderwater && this.canPlantOnTop(world.getBlockState(groundPos), world, groundPos);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        // Only plantable on Sand or Dirt underwater
        return floor.isOf(Blocks.SAND) || floor.isOf(Blocks.DIRT) || floor.isOf(Blocks.GRAVEL);
    }

    // 2. Ensuring the water stays inside the block
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.AQUABLOOM_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty() { return AGE; }

    @Override
    public int getMaxAge() { return MAX_AGE; }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return state.get(this.getAgeProperty()) < this.getMaxAge();
    }

    @Override
    protected int getGrowthAmount(World world) {

        return world.random.nextInt(2) + 1;
    }
}