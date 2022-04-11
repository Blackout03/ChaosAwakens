package io.github.chaosawakens.common.registry;

import io.github.chaosawakens.ChaosAwakens;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class CATags {
	public static class Blocks {
		public static ITag.INamedTag<Block> tag(String name) {
			return BlockTags.bind(ChaosAwakens.MODID + ":" + name);
		}

		public static final ITag.INamedTag<Block> BASE_STONE_CRYSTAL = tag("base_stone_crystal");
		public static final ITag.INamedTag<Block> MINERS_DREAM_MINEABLE = tag("miners_dream_mineable");
		public static final ITag.INamedTag<Block> APPLE_LOGS = tag("apple_logs");
		public static final ITag.INamedTag<Block> CHERRY_LOGS = tag("cherry_logs");
		public static final ITag.INamedTag<Block> PEACH_LOGS = tag("peach_logs");
		public static final ITag.INamedTag<Block> DUPLICATION_LOGS = tag("duplication_logs");
		public static final ITag.INamedTag<Block> CRYSTAL_LOGS = tag("crystal_logs");
		public static final ITag.INamedTag<Block> CRYSTAL_LEAVES = tag("crystal_leaves");

		public static final ITag.INamedTag<Block> CHERRY_FIRE_BASE_BLOCKS = tag("cherry_fire_base_blocks");
	}

	public static class Items {
		public static ITag.INamedTag<Item> tag(String name) {
			return ItemTags.bind(ChaosAwakens.MODID + ":" + name);
		}

		public static final ITag.INamedTag<Item> APPLE_LOGS = tag("apple_logs");
		public static final ITag.INamedTag<Item> CHERRY_LOGS = tag("cherry_logs");
		public static final ITag.INamedTag<Item> PEACH_LOGS = tag("peach_logs");
		public static final ITag.INamedTag<Item> DUPLICATION_LOGS = tag("duplication_logs");
		public static final ITag.INamedTag<Item> CRYSTAL_LOGS = tag("crystal_logs");
		public static final ITag.INamedTag<Item> CRYSTAL_LEAVES = tag("crystal_leaves");

		public static final ITag.INamedTag<Item> CHERRY_FIRE_BASE_BLOCKS = tag("cherry_fire_base_blocks");

		public static final ITag.INamedTag<Item> RUBY_ORES = tag("ruby_ores");

		public static final ITag.INamedTag<Item> FISH = tag("fish");
		public static final ITag.INamedTag<Item> GEMSTONES = tag("gemstones");
		public static final ITag.INamedTag<Item> NUGGETS = tag("nuggets");
		public static final ITag.INamedTag<Item> INGOTS = tag("ingots");
		public static final ITag.INamedTag<Item> MINERAL_LUMPS = tag("mineral_lumps");
		public static final ITag.INamedTag<Item> PLANTS = tag("plants");
		public static final ITag.INamedTag<Item> SEEDS = tag("seeds");

		public static final ITag.INamedTag<Item> CUSTOM_TOOLTIPS = tag("custom_tooltips");
	}
}
