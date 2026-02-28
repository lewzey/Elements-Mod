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
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class Aetherius extends Item {
    public Aetherius(Settings settings) {
        super(settings);
    }

    // how you fly when you hold it
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && entity instanceof PlayerEntity player) {
            boolean isHoldingWand = player.getMainHandStack() == stack || player.getOffHandStack() == stack;

            if (isHoldingWand) {
                if (!player.getAbilities().allowFlying) {
                    player.getAbilities().allowFlying = true;
                    player.sendAbilitiesUpdate();
                }
            } else {
                if (!player.isCreative() && !player.isSpectator() && player.getAbilities().allowFlying) {
                    player.getAbilities().allowFlying = false;
                    player.getAbilities().flying = false;
                    player.sendAbilitiesUpdate();
                }
            }
        }
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW; // bow animation when holding right clock
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
    public boolean hasGlint(ItemStack stack) {
        return true; // Makes it shiny even without enchantments
    }

    // wind steam right click attack (really cool)
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient() && world instanceof ServerWorld serverWorld && user instanceof PlayerEntity player) {

            Vec3d eyePos = player.getEyePos();
            Vec3d lookDir = player.getRotationVector();
            double range = 8.0; // How far the wind travels in blocks

            // for swaping the cloud particles 1
            for (int i = 1; i <= range; i++) {
                Vec3d particlePos = eyePos.add(lookDir.multiply(i));
                serverWorld.spawnParticles(ParticleTypes.CLOUD, particlePos.x, particlePos.y, particlePos.z,
                        1, 0.2, 0.2, 0.2, 0.05);
            }

            // apply damage/knockback every 5 ticks (so we don't instantly obliterate mobs 20 times a second)
            if (remainingUseTicks % 5 == 0) {

                // play a sound
                //SoundEvents.ENTITY_BREEZE_SHOOT
                //SoundEvents.ENTITY_ENDER_DRAGON_FLAP
                // SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL
                world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL, SoundCategory.PLAYERS, 1.0f, 0.5f + (world.random.nextFloat() * 0.4f));

                //get all living entities within a rough box around the player
                Box hitBox = player.getBoundingBox().expand(range);
                List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class, hitBox, entity -> entity != player);

                for (int j = 0; j < targets.size(); j++) {
                    LivingEntity target = targets.get(j);
                    Vec3d toTarget = target.getPos().subtract(player.getPos()).normalize();
                    // dot product > 0.7 means they are within roughly a 45-degree cone in front of you
                    if (lookDir.dotProduct(toTarget) > 0.7 && player.distanceTo(target) <= range) {
                        // deal 1 heart per hit
                        target.damage(serverWorld.getDamageSources().playerAttack(player), 2.0f);
                        // push them back
                        target.takeKnockback(1.0, -lookDir.x, -lookDir.z);
                    }
                }
            }
        }
    }
}