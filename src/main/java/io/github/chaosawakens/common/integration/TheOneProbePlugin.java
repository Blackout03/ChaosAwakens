package io.github.chaosawakens.common.integration;

import io.github.chaosawakens.common.blocks.AntInfestedOre;
import io.github.chaosawakens.common.registry.CABlocks;
import mcjty.theoneprobe.Tools;
import mcjty.theoneprobe.api.CompoundText;
import mcjty.theoneprobe.api.ITheOneProbe;
import mcjty.theoneprobe.api.TextStyleClass;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.fml.InterModComms;

import java.util.function.Function;

public class TheOneProbePlugin {
    private TheOneProbePlugin() {}

    public static void register() {
        InterModComms.sendTo("theoneprobe", "getTheOneProbe", GetTheOneProbe::new);
    }

    public static class GetTheOneProbe implements Function<ITheOneProbe, Void> {
        @Override
        public Void apply(ITheOneProbe iTheOneProbe) {
            iTheOneProbe.registerBlockDisplayOverride((probeMode, iProbeInfo, playerEntity, world, blockState, iProbeHitData) -> {
                if (blockState.getBlock() instanceof AntInfestedOre) {
                    if (blockState.is(CABlocks.RED_ANT_INFESTED_ORE.get())) {
                        ItemStack stack = new ItemStack(Items.DIAMOND_ORE);
                        iProbeInfo.horizontal().item(stack).vertical().itemLabel(stack).text(CompoundText.create().style(TextStyleClass.MODNAME).text(Tools.getModName(stack.getItem())));
                    } else if (blockState.is(CABlocks.TERMITE_INFESTED_ORE.get())) {
                        ItemStack stack = new ItemStack(Items.EMERALD_ORE);
                        iProbeInfo.horizontal().item(stack).vertical().itemLabel(stack).text(CompoundText.create().style(TextStyleClass.MODNAME).text(Tools.getModName(stack.getItem())));
                    }
                    return true;
                }
                return false;
            });
            return null;
        }
    }
}
