package net.loos.elementsmod.entity.client;

import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.BirdEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BirdModel<T extends BirdEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BIRD = new EntityModelLayer(
            Identifier.of(ElementsMod.MOD_ID, "bird"), "main");

    private final ModelPart root; // This is the actual root from the constructor
    private final ModelPart body;
    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final ModelPart right_wing;
    private final ModelPart left_wing;
    private final ModelPart head;

    public BirdModel(ModelPart root) {
        this.root = root;

        // FIX: Grab the 'body' first since everything is inside it now
        this.body = root.getChild("body");

        // FIX: Grab the children FROM the body, not the root
        this.right_leg = this.body.getChild("right leg");
        this.left_leg = this.body.getChild("left leg");
        this.right_wing = this.body.getChild("right wing");
        this.left_wing = this.body.getChild("left wing");
        this.head = this.body.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        // The master BODY folder
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        // Cubes inside the body
        body.addChild("body_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -4.0F, 0.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -2.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

        // Sub-folders inside the body
        body.addChild("right leg", ModelPartBuilder.create().uv(0, 13).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -2.0F, 0.5F));
        body.addChild("left leg", ModelPartBuilder.create().uv(4, 13).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -2.0F, 0.5F));

        ModelPartData right_wing = body.addChild("right wing", ModelPartBuilder.create(), ModelTransform.pivot(0.7365F, -5.7763F, 0.9193F));
        right_wing.addChild("right wing_r1", ModelPartBuilder.create().uv(12, 0).cuboid(0.0434F, 0.0153F, -1.6777F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.3807F, -0.1745F, 0.0F, -0.2182F));

        ModelPartData left_wing = body.addChild("left wing", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, -5.7763F, 1.3F));
        left_wing.addChild("left wing_r1", ModelPartBuilder.create().uv(12, 7).cuboid(-0.9F, -0.0237F, -1.1234F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -0.3807F, -0.1745F, 0.0F, 0.2182F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, -6.0F, 1.3F));
        head.addChild("beak_r1", ModelPartBuilder.create().uv(8, 13).cuboid(0.0F, -1.0F, 1.8F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.0F, -0.3F, 0.0F, -0.0436F, 0.0F));
        head.addChild("head_r1", ModelPartBuilder.create().uv(0, 7).cuboid(-2.0F, -2.7F, -0.3F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, -1.3F, -0.0436F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.root.yaw = (float) Math.toRadians(180);
        this.head.yaw = netHeadYaw * ((float)Math.PI / 180f);

        float pitchOffset = (float) Math.toRadians(-20);
        this.head.pitch = ((-headPitch) * ((float)Math.PI / 180f)) + pitchOffset;

        // Animations
        this.animateMovement(BirdAnimation.walking, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, BirdAnimation.idle, ageInTicks, 1f);
        this.updateAnimation(entity.flyAnimationState, BirdAnimation.flying, ageInTicks, 1f);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }
}