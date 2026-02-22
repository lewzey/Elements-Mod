package net.loos.elementsmod.entity.client;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

import java.util.EnumSet;

public class ButterflyFlyGoal extends Goal {
    private final PathAwareEntity entity;

    public ButterflyFlyGoal(PathAwareEntity entity) {
        this.entity = entity;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    @Override
    public boolean canStart() {
        return entity.getNavigation().isIdle() && entity.getRandom().nextInt(10) == 0;
    }

    @Override
    public void start() {
        Vec3d target = getRandomAirPos();
        entity.getNavigation().startMovingTo(target.x, target.y, target.z, 1.0);
    }

    private Vec3d getRandomAirPos() {
        Random random = entity.getRandom();
        double x = entity.getX() + (random.nextDouble() - 0.5) * 8;
        double y = entity.getY() + (random.nextDouble() - 0.5) * 4;
        double z = entity.getZ() + (random.nextDouble() - 0.5) * 8;
        return new Vec3d(x, y, z);
    }
}