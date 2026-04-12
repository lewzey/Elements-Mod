package net.loos.elementsmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.world.World;

public class LuminousRayEntity extends WaterCreatureEntity {
    public LuminousRayEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
        super(entityType, world);
    }

    // Set the mob's stats
    public static DefaultAttributeContainer.Builder createAttributes() {
        return WaterCreatureEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimAroundGoal(this, 1.0, 10));
    }

    // This makes the mob actually use the "Swim" navigation instead of trying to walk on the seafloor
    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }
}