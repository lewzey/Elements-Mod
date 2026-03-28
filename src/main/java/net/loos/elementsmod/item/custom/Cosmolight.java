package net.loos.elementsmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Cosmolight extends Item { // if ykyk, (inspired from terraria calamity)

    public Cosmolight(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient() && world instanceof ServerWorld serverWorld) {

            if (user.isSneaking()) {
                // weather cycle: clear to rain to thunder
                cycleWeather(serverWorld, user);
            } else {
                // time cycle: morning to midday to evening to midnight
                cycleTime(serverWorld, user);
            }
        }

        // Add a 1-second delay between uses
        user.getItemCooldownManager().set(this, 20);

        return TypedActionResult.success(itemStack);
    }


    // for managing time cycle
    private void cycleTime(ServerWorld world, PlayerEntity user) {
        long currentTime = world.getTimeOfDay() % 24000;
        long newTime;
        String timeMessage;

        // determine the next time of day based on the current time
        if (currentTime < 6000) {
            newTime = 6000; // changing to midday
            timeMessage = "Time set to Midday";
        } else if (currentTime < 12000) {
            newTime = 12000; // changing to evening
            timeMessage = "Time set to Evening";
        } else if (currentTime < 18000) {
            newTime = 18000; // changing to night
            timeMessage = "Time set to Midnight";
        } else {
            // Jump to morning (the next day)
            // We add the difference to advance the day counter, if I didnt it just resets the day counter
            newTime = world.getTimeOfDay() + (24000 - currentTime);
            timeMessage = "Time set to Morning";
        }

        world.setTimeOfDay(newTime);
        // will show the message above hotbar
        user.sendMessage(Text.literal(timeMessage), true);
    }

    // for changing the weather
    private void cycleWeather(ServerWorld world, PlayerEntity user) {
        String weatherMessage;

        if (world.isThundering()) {
            // change to clear
            world.setWeather(6000, 0, false, false);
            weatherMessage = "Weather cleared";
        } else if (world.isRaining()) {
            // change to thunder
            world.setWeather(0, 6000, true, true);
            weatherMessage = "Thunderstorm approaching";
        } else {
            // change to rain
            world.setWeather(0, 6000, true, false);
            weatherMessage = "It's starting to rain";
        }

        user.sendMessage(Text.literal(weatherMessage), true);
    }
}