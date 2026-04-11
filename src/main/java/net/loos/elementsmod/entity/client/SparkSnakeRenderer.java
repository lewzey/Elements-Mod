package net.loos.elementsmod.entity.client;

import net.loos.elementsmod.ElementsMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SilverfishEntityRenderer;
import net.minecraft.util.Identifier;

public class SparkSnakeRenderer extends SilverfishEntityRenderer {
    private static final Identifier TEXTURE =
            Identifier.of(ElementsMod.MOD_ID, "textures/entity/snake/spark_snake.png");
    public SparkSnakeRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(net.minecraft.entity.mob.SilverfishEntity entity) {
        return TEXTURE;
    }
}
