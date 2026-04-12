package net.loos.elementsmod.entity.client;

import net.loos.elementsmod.ElementsMod;
import net.loos.elementsmod.entity.custom.LuminousRayEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class LuminousRayModel<T extends LuminousRayEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer LUMINOUS_RAY = new EntityModelLayer(Identifier.of(ElementsMod.MOD_ID, "ray"), "main");
    private final ModelPart root;
    private final ModelPart left_wing;
    private final ModelPart right_wing;

    public LuminousRayModel(ModelPart root) {
        this.root = root;
        this.left_wing = root.getChild("left_wing");
        this.right_wing = root.getChild("right_wing");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0)
                .cuboid(-4.0F, -1.0F, -6.0F, 8.0F, 2.0F, 12.0F), ModelTransform.pivot(0.0F, 22.0F, 0.0F));

        modelPartData.addChild("left_wing", ModelPartBuilder.create().uv(0, 14)
                .cuboid(0.0F, 0.0F, -5.0F, 10.0F, 1.0F, 10.0F), ModelTransform.pivot(4.0F, 21.0F, 0.0F));

        modelPartData.addChild("right_wing", ModelPartBuilder.create().uv(0, 14).mirrored()
                .cuboid(-10.0F, 0.0F, -5.0F, 10.0F, 1.0F, 10.0F), ModelTransform.pivot(-4.0F, 21.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        float flap = MathHelper.cos(ageInTicks * 0.15f) * 0.4f;
        this.left_wing.roll = flap;
        this.right_wing.roll = -flap;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}