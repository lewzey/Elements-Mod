package net.loos.elementsmod.entity.client;

import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.ButterflyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ButterflyModel <T extends ButterflyEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BUTTERFLY = new EntityModelLayer(Identifier.of(ElementsMod.MOD_ID, "butterfly"), "main");private final ModelPart butterfly;
    private final ModelPart leftwing;
    private final ModelPart rightwing;
    private final ModelPart head;

    public ButterflyModel(ModelPart root) {
        this.butterfly = root;
        this.leftwing = root.getChild("leftwing");
        this.rightwing = root.getChild("rightwing");
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData leftwing = modelPartData.addChild("leftwing", ModelPartBuilder.create().uv(16, 8).cuboid(-1.0F, -10.9F, 0.9F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 14).cuboid(-3.0F, -11.9F, 1.4F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 14).cuboid(-2.0F, -11.9F, 1.4F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F))
                .uv(12, 0).cuboid(-4.0F, -12.9F, 1.9F, 1.0F, 11.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 0).cuboid(-5.0F, -13.9F, 0.9F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 0).cuboid(-6.0F, -13.9F, 1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 3).cuboid(-6.0F, -2.9F, 1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 22).cuboid(-7.0F, -13.9F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(12, 22).cuboid(-7.0F, -14.9F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 22).cuboid(-8.0F, -14.9F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 18).cuboid(-7.0F, -0.8F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 20).cuboid(-8.0F, -0.8F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(-7.0F, -1.8F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.4189F, 0.0F, 0.0F));

        ModelPartData rightwing = modelPartData.addChild("rightwing", ModelPartBuilder.create().uv(16, 0).cuboid(1.0F, -10.9F, 0.9F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 12).cuboid(2.0F, -11.9F, 1.4F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F))
                .uv(12, 12).cuboid(3.0F, -11.9F, 1.4F, 1.0F, 9.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(4.0F, -12.9F, 1.9F, 1.0F, 11.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(5.0F, -13.9F, 0.9F, 1.0F, 13.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 6).cuboid(6.0F, -13.9F, 1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 9).cuboid(6.1F, -2.9F, 1.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 16).cuboid(7.0F, -14.9F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 14).cuboid(7.0F, -13.9F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(16, 23).cuboid(8.0F, -14.9F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 12).cuboid(8.1F, -0.8F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(16, 21).cuboid(7.1F, -0.8F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(24, 0).cuboid(7.1F, -1.8F, 1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.4189F, 0.0F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(16, 16).cuboid(0.0F, -5.0F, 0.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -4.2F, -2.0F, 0.3491F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(ButterflyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ButterflyAnimations.ANIM_BUTTERFLY_FLY, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ButterflyAnimations.ANIM_BUTTERFLY_IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles( float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 25.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;

    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        butterfly.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return butterfly;
    }

}