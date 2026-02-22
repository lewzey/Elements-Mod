package net.loos.elementsmod.entity.client;

import com.google.common.collect.Maps;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.ButterflyEntity;
import net.loos.elementsmod.entity.custom.ButterflyVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ButterflyRenderer extends MobEntityRenderer<ButterflyEntity, ButterflyModel<ButterflyEntity>> {
    private static final Map<ButterflyVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ButterflyVariant.class), map -> {
                map.put(ButterflyVariant.DEFAULT,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/butterfly/butterfly.png"));
                map.put(ButterflyVariant.PURPLE,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/butterfly/purple_butterfly.png"));
                map.put(ButterflyVariant.GREEN,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/butterfly/green_butterfly.png"));
                map.put(ButterflyVariant.BLACK,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/butterfly/black_butterfly.png"));
                map.put(ButterflyVariant.RED,
                        Identifier.of(ElementsMod.MOD_ID, "textures/entity/butterfly/red_butterfly.png"));
            });
    public ButterflyRenderer(EntityRendererFactory.Context context) {
        super(context, new ButterflyModel<>(context.getPart(ButterflyModel.BUTTERFLY)), 0.75f);
    }

    @Override
    public Identifier getTexture(ButterflyEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(ButterflyEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.15f, 0.15f, 0.15f);
        } else {
            matrixStack.scale(0.3f, 0.3f, 0.3f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
