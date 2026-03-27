package net.loos.elementsmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends MiningToolItem {
    public HammerItem(ToolMaterial material, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, int depth, BlockPos initalBlockPos, Direction dir) {
        List<BlockPos> positions = new ArrayList<>();

        for (int d = 0; d <= depth; d++) {
            BlockPos base = initalBlockPos.offset(dir, d);

            if(dir == Direction.DOWN || dir == Direction.UP) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(base.getX() + x, base.getY(), base.getZ() + y));
                    }
                }
            }

            if(dir == Direction.NORTH || dir == Direction.SOUTH) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(base.getX() + x, base.getY() + y, base.getZ()));
                    }
                }
            }

            if(dir == Direction.EAST || dir == Direction.WEST) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(base.getX(), base.getY() + y, base.getZ() + x));
                    }
                }
            }
        }

        return positions;
    }
}

