package net.loos.elementsmod.block.custom;

import net.loos.elementsmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AetheriaCropBlock extends CropBlock {

    public static final int MAX_AGE = 6;
    public static final IntProperty AGE = IntProperty.of("age",0,6);



    public AetheriaCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem(){
        return ModItems.AETHERIA_SEEDS;
    }

    @Override
    public IntProperty getAgeProperty(){
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(AGE);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!world.isClient && !state.isOf(newState.getBlock())) {

            if (state.get(AGE) == MAX_AGE) {
                ItemStack stack = new ItemStack(ModItems.AETHERIA_CROP);
                ItemEntity itemEntity = new ItemEntity(world,
                        pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack);

                itemEntity.setNoGravity(true);
                itemEntity.setVelocity(0, 0.05, 0);
                itemEntity.setToDefaultPickupDelay();

                world.spawnEntity(itemEntity);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}