package net.loos.elementsmod;

import net.fabricmc.api.ClientModInitializer;



import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.loos.elementsmod.entity.ModEntities;
import net.loos.elementsmod.entity.client.ButterflyModel;
import net.loos.elementsmod.entity.client.ButterflyRenderer;
import net.minecraft.client.render.RenderLayer;
import net.loos.elementsmod.block.ModBlocks;
import net.loos.elementsmod.entity.client.SparkSnakeRenderer;



public class ElementsModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AERIS_VAPOR_BLOCK, RenderLayer.getTranslucent()); // allows client to see this block as transparent
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AERIS_BLOCK, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLUTTERBLOOM_CROP, RenderLayer.getCutout());
        EntityModelLayerRegistry.registerModelLayer(ButterflyModel.BUTTERFLY, ButterflyModel::getTexturedModelData );
        EntityRendererRegistry.register(ModEntities.BUTTERFLY, ButterflyRenderer::new);

        EntityRendererRegistry.register(ModEntities.SPARK_SNAKE, SparkSnakeRenderer::new);
    }
}


