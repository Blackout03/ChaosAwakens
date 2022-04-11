package io.github.chaosawakens.common.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CAItemGroups {
    public static ItemGroup BLOCKS = new ItemGroup("chaosawakens.blocks") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CABlocks.TITANIUM_BLOCK.get());
        }
    };

    public static ItemGroup ITEMS = new ItemGroup("chaosawakens.items") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CAItems.URANIUM_INGOT.get());
        }
    };

    public static ItemGroup FOOD = new ItemGroup("chaosawakens.food") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CAItems.CORN.get());
        }
    };

    public static ItemGroup EQUIPMENT = new ItemGroup("chaosawakens.equipment") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CAItems.ULTIMATE_AXE.get());
        }
    };

    public static ItemGroup SPAWN_EGGS = new ItemGroup("chaosawakens.spawn_eggs") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CAItems.RAINBOW_ANT_SPAWN_EGG.get());
        }
    };
}
