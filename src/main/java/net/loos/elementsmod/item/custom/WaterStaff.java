package net.loos.elementsmod.item.custom;

import net.loos.elementsmod.item.ModItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import java.util.List;


public class WaterStaff extends SwordItem implements Equipment {

    public WaterStaff(ToolMaterial material, Settings settings) {
        super(material, settings.attributeModifiers(SwordItem.createAttributeModifiers(material,4, -2.5f)));
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }
    public static final float MIN_DAMAGE_AMOUNT_TO_BREAK = 3.0F;

    //Blocking Mechanic like shield
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    //How long can you hold down the block (72000 is 1 hour)
    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }
    //Start using Item in hand and trigger block
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack staff = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(staff);
    }

    //Function So the bubbles and block persist after holding right click
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {

        if (!world.isClient() && world instanceof ServerWorld serverWorld) {

            //  BUBBLE SPHERE
            double visualRadius = 1.5;
            int numParticles = 50;
            double goldenAngle = Math.PI * (3.0 - Math.sqrt(5.0));
            double spin = remainingUseTicks * 0.15;

            for (int i = 0; i < numParticles; i++) {
                double y = 1.0 - (i / (double)(numParticles - 1)) * 2.0;
                double radiusAtY = Math.sqrt(1.0 - y * y);
                double theta = goldenAngle * i + spin;

                double particleX = user.getX() + (visualRadius * Math.cos(theta) * radiusAtY);
                double particleY = user.getY() + 1.0 + (visualRadius * y);
                double particleZ = user.getZ() + (visualRadius * Math.sin(theta) * radiusAtY);

                serverWorld.spawnParticles(ParticleTypes.BUBBLE_COLUMN_UP, particleX, particleY, particleZ, 1, 0.0, 0.0, 0.0, 0.0);
            }

            //  WHIRLPOOL VORTEX & HEALING RAIN
            double effectRadius = 8.0; // How far the staff can reach
            boolean isSneaking = user.isSneaking();

            // Find everything nearby
            List<Entity> nearbyEntities = world.getOtherEntities(user, user.getBoundingBox().expand(effectRadius));

            for (Entity entity : nearbyEntities) {
                if (entity instanceof LivingEntity target) {

                    // WHIRLPOOL Only drag hostile mobstowards you
                    if (target instanceof HostileEntity) {
                        double distance = user.distanceTo(target);

                        // Stop pulling if they are already inside your bubble shield
                        if (distance > 1.5) {
                            // Calculate the exact vector to pull them towards you
                            Vec3d pullVec = new Vec3d(user.getX() - target.getX(), user.getY() - target.getY(), user.getZ() - target.getZ())
                                    .normalize()
                                    .multiply(0.04);

                            target.addVelocity(pullVec.x, pullVec.y, pullVec.z);
                            target.velocityModified = true;
                        }
                    }
                    // HEALING RAIN: If sneaking, heal nearby friendly players/pets every 1 second
                    if (isSneaking && remainingUseTicks % 20 == 0) {
                        if (!(target instanceof HostileEntity)) {
                            target.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0, false, true));
                        }
                    }
                }
            }
            // Apply healing to the player themselves, but damage the staff for using this powerful magic
            if (isSneaking && remainingUseTicks % 20 == 0) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40, 0, false, true));
                stack.damage(1, user, EquipmentSlot.MAINHAND);
            }
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            double radius = 5.0;

            //CLEANSING WAVE
            BlockPos center = user.getBlockPos();
            int r = (int) radius;

            // Loop through a 3D grid of blocks around the player
            for (BlockPos pos : BlockPos.iterate(center.add(-r, -r, -r), center.add(r, r, r))) {
                BlockState state = world.getBlockState(pos);

                // Extinguish fire blocks
                if (state.getBlock() == Blocks.FIRE) {
                    world.removeBlock(pos, false);
                }
                // Turn still Lava into Obsidian
                else if (state.getBlock() == Blocks.LAVA && state.getFluidState().isStill()) {
                    world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, 2, 0.2, 0.2, 0.2, 0.0);
                }
            }

            //CLEANSING WAVE & THE EXPLOSION
            List<Entity> targets = world.getOtherEntities(user, user.getBoundingBox().expand(radius));

            for (Entity entity : targets) {

                if (entity.isOnFire()) {
                    entity.extinguish();
                }

                // Blast away and damage enemies
                if (entity instanceof LivingEntity target && entity instanceof HostileEntity) {
                    target.damage(world.getDamageSources().magic(), 6.0F);

                    double knockbackX = target.getX() - user.getX();
                    double knockbackZ = target.getZ() - user.getZ();

                    target.takeKnockback(2.0, -knockbackX, -knockbackZ);
                }
            }

            // VISUALS & COOLDOWN
            serverWorld.spawnParticles(ParticleTypes.CLOUD, user.getX(), user.getY() + 1.0, user.getZ(), 200, radius / 2.0, 1.0, radius / 2.0, 0.5);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0f, 1.5f);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.PLAYERS, 2.0f, 0.5f);

            if (user instanceof PlayerEntity player) {
                player.getItemCooldownManager().set(this, 100);
            }
        }
    }
    //Lets Staff be repaired in the anvil with a Hydrocite Gem.
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.HYDROCITE_GEM) || super.canRepair(stack, ingredient);
    }
    //Allows shift clicking straight into hotbar from inventory
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.MAINHAND;
    }

}

