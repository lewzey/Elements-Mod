package net.loos.elementsmod;

import net.fabricmc.api.ClientModInitializer;



import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.loos.elementsmod.entity.ModEntities;
import net.loos.elementsmod.entity.client.*;
import net.minecraft.client.render.RenderLayer;
import net.loos.elementsmod.block.ModBlocks;


public class ElementsModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AERIS_VAPOR_BLOCK, RenderLayer.getTranslucent()); // allows client to see this block as transparent
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AERIS_BLOCK, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLUTTERBLOOM_CROP, RenderLayer.getCutout());
        EntityModelLayerRegistry.registerModelLayer(ButterflyModel.BUTTERFLY, ButterflyModel::getTexturedModelData );
        EntityRendererRegistry.register(ModEntities.BUTTERFLY, ButterflyRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(LuminousRayModel.LUMINOUS_RAY, LuminousRayModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.LUMINOUS_RAY, LuminousRayRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AQUABLOOM_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.SPARK_SNAKE, SparkSnakeRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(BirdModel.BIRD, BirdModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BIRD, BirdRenderer::new);

    }
}


