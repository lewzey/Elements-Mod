package net.loos.elementsmod.entity.client;

import com.google.common.collect.Maps;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.BirdEntity;
import net.loos.elementsmod.entity.custom.BirdVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class BirdRenderer extends MobEntityRenderer<BirdEntity, BirdModel<BirdEntity>> {
    private static final Map<BirdVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(BirdVariant.class), map -> {
                map.put(BirdVariant.BROWN,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/bird/brown.png"));
                map.put(BirdVariant.SANDY,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/bird/sandy.png"));
                map.put(BirdVariant.BLUE,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/bird/blue.png"));
            });

    public BirdRenderer(EntityRendererFactory.Context context) {
        super(context, new BirdModel<>(context.getPart(BirdModel.BIRD)), 0.3f);
    }

    @Override
    public Identifier getTexture(BirdEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(BirdEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1.0f, 1.0f, 1.0f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}