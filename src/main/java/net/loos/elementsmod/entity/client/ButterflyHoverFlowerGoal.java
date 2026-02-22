package net.loos.elementsmod.entity.client;
import net.loos.elementsmod.entity.custom.ButterflyEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;

public class ButterflyHoverFlowerGoal extends Goal {
    private final ButterflyEntity butterfly;
    private BlockPos targetFlower;

    public ButterflyHoverFlowerGoal(ButterflyEntity butterfly) {
        this.butterfly = butterfly;
    }

    @Override
    public boolean canStart() {
        targetFlower = findFlower();
        return targetFlower != null;
    }

    @Override
    public void start() {
        butterfly.getNavigation().startMovingTo(
                targetFlower.getX() + 0.5,
                targetFlower.getY() + 1.2,
                targetFlower.getZ() + 0.5,
                1.0
        );
    }

    private BlockPos findFlower() {
        BlockPos center = butterfly.getBlockPos();

        for (BlockPos pos : BlockPos.iterateOutwards(center, 5, 3, 5)) {
            BlockState state = butterfly.getWorld().getBlockState(pos);
            if (state.isIn(BlockTags.FLOWERS)) {
                return pos.toImmutable();
            }
        }
        return null;
    }
}