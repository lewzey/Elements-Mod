package net.loos.elementsmod;

import net.fabricmc.api.ClientModInitializer;



import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.loos.elementsmod.block.ModBlocks;

public class ElementsModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AERIS_VAPOR_BLOCK, RenderLayer.getTranslucent()); // allows client to see this block as transparent
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AERIS_BLOCK, RenderLayer.getTranslucent());
    }
}
