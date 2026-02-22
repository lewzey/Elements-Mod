package net.loos.elementsmod.entity;

import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.ButterflyEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ButterflyEntity> BUTTERFLY = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(ElementsMod.MOD_ID, "butterfly"),
            EntityType.Builder.create(ButterflyEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.3f, 0.3f).build());
    public static void registerModEntities() {
        ElementsMod.LOGGER.info("Registering Mob Entities for" + ElementsMod.MOD_ID);
    }
}
