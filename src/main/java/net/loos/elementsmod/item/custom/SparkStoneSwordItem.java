package net.loos.elementsmod.item.custom;

import net.loos.elementsmod.item.ModArmorMaterials;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SparkStoneSwordItem extends SwordItem {

    public SparkStoneSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof PlayerEntity player) {

            if (isWearingFullSparkArmor(player)) {
                target.setOnFireFor(4); // 4 seconds
            }
        }

        return super.postHit(stack, target, attacker);
    }

    private boolean isWearingFullSparkArmor(PlayerEntity player) {
        return player.getInventory().getArmorStack(0).getItem() instanceof net.minecraft.item.ArmorItem boots &&
                player.getInventory().getArmorStack(1).getItem() instanceof net.minecraft.item.ArmorItem leggings &&
                player.getInventory().getArmorStack(2).getItem() instanceof net.minecraft.item.ArmorItem chest &&
                player.getInventory().getArmorStack(3).getItem() instanceof net.minecraft.item.ArmorItem helmet &&

                boots.getMaterial() == ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL &&
                leggings.getMaterial() == ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL &&
                chest.getMaterial() == ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL &&
                helmet.getMaterial() == ModArmorMaterials.SPARK_STONE_ARMOR_MATERIAL;
    }
}
