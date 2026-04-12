package net.loos.elementsmod.entity.custom;

import net.loos.elementsmod.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.Ingredient;
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
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.25));

        this.goalSelector.add(1, new TemptGoal(this, 1.2D,
                Ingredient.ofItems(ModItems.AQUABLOOM), false));

        this.goalSelector.add(2, new SwimAroundGoal(this, 1.0, 10));

        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }


    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }
}

