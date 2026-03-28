package net.loos.elementsmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class SparkStaff extends Item {
    public SparkStaff(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.consume(user.getStackInHand(hand));
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient() && world instanceof ServerWorld serverWorld && user instanceof PlayerEntity player) {
            Vec3d eyePos = player.getEyePos();
            Vec3d lookDir = player.getRotationVector();

            if (remainingUseTicks % 5 == 0) {
                world.playSound(null, player.getBlockPos(),
                        SoundEvents.ITEM_FIRECHARGE_USE,
                        SoundCategory.PLAYERS,
                        0.5f, 1.0f);
            }

            for (double i = 1.0; i <= 12.0; i += 0.5) {
                Vec3d particlePos = eyePos.add(lookDir.multiply(i));

                serverWorld.spawnParticles(ParticleTypes.FLAME,
                        particlePos.x, particlePos.y, particlePos.z,
                        1, 0.0, 0.0, 0.0, 0.0);

                Box box = new Box(
                        particlePos.x - 0.5, particlePos.y - 0.5, particlePos.z - 0.5,
                        particlePos.x + 0.5, particlePos.y + 0.5, particlePos.z + 0.5
                );

                List<Entity> entities = world.getOtherEntities(player, box);

                for (Entity entity : entities) {
                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.damage(player.getDamageSources().magic(), 1.0f);
                        livingEntity.setOnFireFor(2);
                    }
                }
            }
        }
    }
}