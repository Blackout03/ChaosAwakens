package io.github.chaosawakens.common.registry;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.util.IItemProvider;

public class CAVanillaCompat {
    public static void setup() {
        //Flammability
        registerFlammable(CABlocks.APPLE_LEAVES.get(), 30, 60);
        registerFlammable(CABlocks.APPLE_LOG.get(), 5, 5);
        registerFlammable(CABlocks.APPLE_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_APPLE_LOG.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_APPLE_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.APPLE_PLANKS.get(), 5, 20);
        registerFlammable(CABlocks.APPLE_SLAB.get(), 5, 20);
        registerFlammable(CABlocks.APPLE_STAIRS.get(), 5, 20);
        registerFlammable(CABlocks.APPLE_FENCE.get(), 5, 20);
        registerFlammable(CABlocks.APPLE_FENCE_GATE.get(), 5, 20);
        registerFlammable(CABlocks.CHERRY_LEAVES.get(), 30, 60);
        registerFlammable(CABlocks.CHERRY_LOG.get(), 5, 5);
        registerFlammable(CABlocks.CHERRY_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_CHERRY_LOG.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_CHERRY_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.CHERRY_PLANKS.get(), 5, 20);
        registerFlammable(CABlocks.CHERRY_SLAB.get(), 5, 20);
        registerFlammable(CABlocks.CHERRY_STAIRS.get(), 5, 20);
        registerFlammable(CABlocks.CHERRY_FENCE.get(), 5, 20);
        registerFlammable(CABlocks.CHERRY_FENCE_GATE.get(), 5, 20);
        registerFlammable(CABlocks.DUPLICATION_LEAVES.get(), 30, 60);
        registerFlammable(CABlocks.DUPLICATION_LOG.get(), 5, 5);
        registerFlammable(CABlocks.DUPLICATION_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_DUPLICATION_LOG.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_DUPLICATION_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.DUPLICATION_PLANKS.get(), 5, 20);
        registerFlammable(CABlocks.DUPLICATION_SLAB.get(), 5, 20);
        registerFlammable(CABlocks.DUPLICATION_STAIRS.get(), 5, 20);
        registerFlammable(CABlocks.DUPLICATION_FENCE.get(), 5, 20);
        registerFlammable(CABlocks.DUPLICATION_FENCE_GATE.get(), 5, 20);
        registerFlammable(CABlocks.PEACH_LEAVES.get(), 30, 60);
        registerFlammable(CABlocks.PEACH_LOG.get(), 5, 5);
        registerFlammable(CABlocks.PEACH_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_PEACH_LOG.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_PEACH_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.PEACH_PLANKS.get(), 5, 20);
        registerFlammable(CABlocks.PEACH_SLAB.get(), 5, 20);
        registerFlammable(CABlocks.PEACH_STAIRS.get(), 5, 20);
        registerFlammable(CABlocks.PEACH_FENCE.get(), 5, 20);
        registerFlammable(CABlocks.PEACH_FENCE_GATE.get(), 5, 20);
        registerFlammable(CABlocks.SKYWOOD_LEAVES.get(), 30, 60);
        registerFlammable(CABlocks.SKYWOOD_LOG.get(), 5, 5);
        registerFlammable(CABlocks.SKYWOOD_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_SKYWOOD_LOG.get(), 5, 5);
        registerFlammable(CABlocks.STRIPPED_SKYWOOD_WOOD.get(), 5, 5);
        registerFlammable(CABlocks.SKYWOOD_PLANKS.get(), 5, 20);
        registerFlammable(CABlocks.SKYWOOD_SLAB.get(), 5, 20);
        registerFlammable(CABlocks.SKYWOOD_STAIRS.get(), 5, 20);
        registerFlammable(CABlocks.SKYWOOD_FENCE.get(), 5, 20);
        registerFlammable(CABlocks.SKYWOOD_FENCE_GATE.get(), 5, 20);
        registerFlammable(CABlocks.CYAN_ROSE.get(), 60, 100);
        registerFlammable(CABlocks.RED_ROSE.get(), 60, 100);
        registerFlammable(CABlocks.PAEONIA.get(), 60, 100);
        registerFlammable(CABlocks.STRAWBERRY_BUSH.get(), 60, 100);
        registerFlammable(CABlocks.CORN_TOP_BLOCK.get(), 60, 100);
        registerFlammable(CABlocks.CORN_BODY_BLOCK.get(), 60, 100);
        registerFlammable(CABlocks.TOMATO_TOP_BLOCK.get(), 60, 100);
        registerFlammable(CABlocks.TOMATO_BODY_BLOCK.get(), 60, 100);

        //Log Stripping
        registerStrippable(CABlocks.APPLE_LOG.get(), CABlocks.STRIPPED_APPLE_LOG.get());
        registerStrippable(CABlocks.APPLE_WOOD.get(), CABlocks.STRIPPED_APPLE_WOOD.get());
        registerStrippable(CABlocks.CHERRY_LOG.get(), CABlocks.STRIPPED_CHERRY_LOG.get());
        registerStrippable(CABlocks.CHERRY_WOOD.get(), CABlocks.STRIPPED_CHERRY_WOOD.get());
        registerStrippable(CABlocks.PEACH_LOG.get(), CABlocks.STRIPPED_PEACH_LOG.get());
        registerStrippable(CABlocks.PEACH_WOOD.get(), CABlocks.STRIPPED_PEACH_WOOD.get());
        registerStrippable(CABlocks.DUPLICATION_LOG.get(), CABlocks.STRIPPED_DUPLICATION_LOG.get());
        registerStrippable(CABlocks.DUPLICATION_WOOD.get(), CABlocks.STRIPPED_DUPLICATION_WOOD.get());
        registerStrippable(CABlocks.SKYWOOD_LOG.get(), CABlocks.STRIPPED_SKYWOOD_LOG.get());
        registerStrippable(CABlocks.SKYWOOD_WOOD.get(), CABlocks.STRIPPED_SKYWOOD_WOOD.get());

        //Compostable Blocks
        registerCompostable(0.3F, CABlocks.APPLE_SAPLING.get());
        registerCompostable(0.3F, CABlocks.APPLE_LEAVES.get());
        registerCompostable(0.3F, CABlocks.CHERRY_SAPLING.get());
        registerCompostable(0.3F, CABlocks.CHERRY_LEAVES.get());
        registerCompostable(0.3F, CABlocks.DUPLICATION_LEAVES.get());
        registerCompostable(0.3F, CABlocks.PEACH_SAPLING.get());
        registerCompostable(0.3F, CABlocks.PEACH_LEAVES.get());
        registerCompostable(0.3F, CABlocks.SKYWOOD_LEAVES.get());
        registerCompostable(0.5F, CABlocks.TUBE_WORM.get());
        registerCompostable(0.65F, CABlocks.CYAN_ROSE.get());
        registerCompostable(0.65F, CABlocks.RED_ROSE.get());
        registerCompostable(0.65F, CABlocks.PAEONIA.get());
    }

    public static void registerStrippable(Block log, Block stripped_log) {
        AxeItem.STRIPABLES = Maps.newHashMap(AxeItem.STRIPABLES);
        AxeItem.STRIPABLES.put(log, stripped_log);
    }

    public static void registerCompostable(float chance, IItemProvider itemIn) {
        ComposterBlock.COMPOSTABLES.put(itemIn.asItem(), chance);
    }

    public static void registerFlammable(Block blockIn, int encouragement, int flammability) {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(blockIn, encouragement, flammability);
    }
}
