package net.loos.elementsmod.entity;

import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.BirdEntity;
import net.loos.elementsmod.entity.custom.ButterflyEntity;
import net.loos.elementsmod.entity.custom.LuminousRayEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.loos.elementsmod.entity.custom.SparkSnakeEntity;
import net.minecraft.entity.EntityDimensions;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

public class ModEntities {
    public static final EntityType<ButterflyEntity> BUTTERFLY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ElementsMod.MOD_ID, "butterfly"),
            EntityType.Builder.create(ButterflyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.3f, 0.3f).build());

    public static final EntityType<LuminousRayEntity> LUMINOUS_RAY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ElementsMod.MOD_ID, "ray"),
            EntityType.Builder.create(LuminousRayEntity::new, SpawnGroup.WATER_AMBIENT)
                    .dimensions(1.5f, 0.4f).build());

    public static final EntityType<SparkSnakeEntity> SPARK_SNAKE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ElementsMod.MOD_ID, "spark_snake"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SparkSnakeEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 0.6f)).build());

    public static final EntityType<BirdEntity> BIRD = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ElementsMod.MOD_ID, "bird"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BirdEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.7f)).build());

    public static void registerModEntities() {
        ElementsMod.LOGGER.info("Registering Mob Entities for" + ElementsMod.MOD_ID);
    }
}
