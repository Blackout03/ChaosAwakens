package io.github.chaosawakens;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Random;

import io.github.chaosawakens.items.ThunderStaffItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
public class GameEvents {

    @SubscribeEvent
    public static void livingUpdateEvent(LivingEvent.LivingUpdateEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof PlayerEntity) {
//    		event.getEntity().stepHeight = 1.0f;

            PlayerEntity player = (PlayerEntity)event.getEntity();

            double baseReach = 3.5;

            if (player.isCreative()) {
                baseReach = 8.0;
            }

            player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).setBaseValue(baseReach);
            if (player.getHeldItemMainhand() != null) {
                Item item = player.getHeldItemMainhand().getItem();
                if (item instanceof ThunderStaffItem) {
                    player.getAttribute(net.minecraftforge.common.ForgeMod.REACH_DISTANCE.get()).setBaseValue(baseReach + 20.0);
                }
            }
        }
    }
}