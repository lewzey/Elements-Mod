package net.loos.elementsmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent FLUTTERBLOOM = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,300),1.0f).build();
}
