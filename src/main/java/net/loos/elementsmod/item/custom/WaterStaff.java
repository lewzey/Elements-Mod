package net.loos.elementsmod.item.custom;

import net.loos.elementsmod.item.ModItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class WaterStaff extends Item implements Equipment {

    //Define Box around player


    public WaterStaff(Settings settings) {
        super(settings);
        //Dispenser will equip directly onto player / mob
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
    //Chat did the math using the Fibonacci Sphere formula
    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {

        if (!world.isClient() && world instanceof ServerWorld serverWorld) {
            double radius = 1.5;
            int numParticles = 50;
            // The Golden Angle in radians (approx 137.5 degrees)
            double goldenAngle = Math.PI * (3.0 - Math.sqrt(5.0));
            // Use the remaining ticks to slowly spin the entire globe
            double spin = remainingUseTicks * 0.15;
            for (int i = 0; i < numParticles; i++) {
                // 1. Calculate the vertical Y position evenly from top (1.0) to bottom (-1.0)
                double y = 1.0 - (i / (double)(numParticles - 1)) * 2.0;
                // 2. Calculate how wide the sphere is at this specific Y height
                double radiusAtY = Math.sqrt(1.0 - y * y);
                // 3. Calculate the horizontal angle using the Golden Ratio plus spin offset
                double theta = goldenAngle * i + spin;
                // 4. Convert to exact world coordinates
                double particleX = user.getX() + (radius * Math.cos(theta) * radiusAtY);
                double particleY = user.getY() + 1.0 + (radius * y);
                double particleZ = user.getZ() + (radius * Math.sin(theta) * radiusAtY);
                // 5. Spawn bubble
                serverWorld.spawnParticles(
                        ParticleTypes.BUBBLE_COLUMN_UP,
                        particleX, particleY, particleZ,
                        1, 0.0, 0.0, 0.0, 0.0
                );
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

