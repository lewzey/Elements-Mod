package net.loos.elementsmod.item.custom;

import net.loos.elementsmod.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Map;

// can change flowers and saplings into other variants when exposed to the sun
//possibly try to randomize in the future
public class BloomStaff extends Item {
    private static final Map<Block, Block> BLOOM_MAP =
            Map.ofEntries(
                    //flowers
                    Map.entry(Blocks.DANDELION, Blocks.POPPY),
                    Map.entry(Blocks.POPPY, Blocks.BLUE_ORCHID),
                    Map.entry(Blocks.BLUE_ORCHID, Blocks.ALLIUM),
                    Map.entry(Blocks.ALLIUM, Blocks.AZURE_BLUET),
                    Map.entry(Blocks.AZURE_BLUET, Blocks.RED_TULIP),
                    Map.entry(Blocks.RED_TULIP, Blocks.ORANGE_TULIP),
                    Map.entry(Blocks.ORANGE_TULIP, Blocks.WHITE_TULIP),
                    Map.entry(Blocks.WHITE_TULIP, Blocks.PINK_TULIP),
                    Map.entry(Blocks.PINK_TULIP, Blocks.OXEYE_DAISY),
                    Map.entry(Blocks.OXEYE_DAISY, Blocks.CORNFLOWER),
                    Map.entry(Blocks.CORNFLOWER, Blocks.LILY_OF_THE_VALLEY),
                    Map.entry(Blocks.LILY_OF_THE_VALLEY, Blocks.DANDELION),
                    //saplings
                    Map.entry(Blocks.OAK_SAPLING, Blocks.SPRUCE_SAPLING),
                    Map.entry(Blocks.SPRUCE_SAPLING, Blocks.BIRCH_SAPLING),
                    Map.entry(Blocks.BIRCH_SAPLING, Blocks.JUNGLE_SAPLING),
                    Map.entry(Blocks.JUNGLE_SAPLING, Blocks.ACACIA_SAPLING),
                    Map.entry(Blocks.ACACIA_SAPLING, Blocks.DARK_OAK_SAPLING),
                    Map.entry(Blocks.DARK_OAK_SAPLING, Blocks.CHERRY_SAPLING),
                    Map.entry(Blocks.CHERRY_SAPLING, Blocks.OAK_SAPLING)
            );

    public BloomStaff(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        // 🌞 must be daytime AND exposed to sky
        if (!world.isDay() || !world.isSkyVisible(context.getBlockPos())) {
            if (!world.isClient && context.getPlayer() != null) {
                context.getPlayer().sendMessage(
                        Text.literal("The staff sleeps without sunlight..."),
                        true
                );
            }
            return ActionResult.FAIL;
        }

        if(BLOOM_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()  && world instanceof ServerWorld serverWorld) {
                world.setBlockState(context.getBlockPos(), BLOOM_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(2, (serverWorld), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_BONE_MEAL_USE, SoundCategory.BLOCKS);
                BlockPos pos = context.getBlockPos();

                for (int i = 0; i < 20; i++) {
                    double offsetX = (world.random.nextDouble() - 0.5);
                    double offsetY = world.random.nextDouble();
                    double offsetZ = (world.random.nextDouble() - 0.5);

                    serverWorld.spawnParticles(
                            ParticleTypes.GLOW,
                            pos.getX() + 0.5 + offsetX,
                            pos.getY() + 0.5 + offsetY,
                            pos.getZ() + 0.5 + offsetZ,
                            1,
                            0, 0, 0,
                            0
                    );
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}
