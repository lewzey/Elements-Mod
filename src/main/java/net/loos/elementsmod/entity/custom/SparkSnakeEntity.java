package net.loos.elementsmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;

public class SparkSnakeEntity extends SilverfishEntity {

    public SparkSnakeEntity(EntityType<? extends SilverfishEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0);
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean success = super.tryAttack(target);

        if (success) {
            target.setOnFireFor(4);
        }
        return success;
    }

    @Override
    protected void initGoals() {

        // attack behavior
        this.goalSelector.add(1, new net.minecraft.entity.ai.goal.MeleeAttackGoal(this, 1.0, false));

        // idle behavior
        this.goalSelector.add(2, new net.minecraft.entity.ai.goal.WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(3, new net.minecraft.entity.ai.goal.LookAtEntityGoal(this, net.minecraft.entity.player.PlayerEntity.class, 8.0f));
        this.goalSelector.add(4, new net.minecraft.entity.ai.goal.LookAroundGoal(this));

        // only attack when attacked
        this.targetSelector.add(1, new net.minecraft.entity.ai.goal.RevengeGoal(this));
    }
}
