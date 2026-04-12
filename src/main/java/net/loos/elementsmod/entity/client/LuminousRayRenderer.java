package net.loos.elementsmod.entity.client;

import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.LuminousRayEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.LuminousRayEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
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
import net.minecraft.util.math.MathHelper;

import java.util.Map;


public class LuminousRayRenderer extends MobEntityRenderer<LuminousRayEntity, LuminousRayModel<LuminousRayEntity>> {
    private static final Identifier TEXTURE = Identifier.of(ElementsMod.MOD_ID, "textures/entity/ray/luminous_ray.png");

    public LuminousRayRenderer(EntityRendererFactory.Context context) {

        super(context, new LuminousRayModel<>(context.getPart(LuminousRayModel.LUMINOUS_RAY)), 0.5f);
    }

    @Override
    public Identifier getTexture(LuminousRayEntity entity) {
        return TEXTURE;
    }
}