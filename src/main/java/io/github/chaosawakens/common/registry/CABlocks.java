package io.github.chaosawakens.common.registry;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.blocks.*;
import io.github.chaosawakens.common.blocks.trees.FancyableTree;
import io.github.chaosawakens.common.items.EnchantedBlockItem;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.IPositionPredicate;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CABlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChaosAwakens.MODID);
	public static final DeferredRegister<Item> ITEM_BLOCKS = DeferredRegister.create(ForgeRegistries.ITEMS, ChaosAwakens.MODID);
	
//	private static IPositionPredicate isTrue = (state, reader, pos) -> true; --Unused
	private static final IPositionPredicate isFalse = (state, reader, pos) -> false;
	
	private static final Function<Integer, ToIntFunction<BlockState>> lightValueFunction = (lightValue) -> (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
	
	// SHINY FOODS
	public static final RegistryObject<GoldenMelonBlock> GOLDEN_MELON = registerBlock("golden_melon", () -> new GoldenMelonBlock(Block.Properties.copy(Blocks.MELON).harvestTool(ToolType.AXE)), CAItemGroups.FOOD);
	public static final RegistryObject<AttachedStemBlock> ATTACHED_GOLDEN_MELON_STEM = registerBlock("attached_golden_melon_stem", () -> new AttachedStemBlock(GOLDEN_MELON.get(), AbstractBlock.Properties.copy(Blocks.ATTACHED_MELON_STEM)), null, false);
	
	// PLANTS
	public static final RegistryObject<StemBlock> GOLDEN_MELON_STEM = registerBlock("golden_melon_stem", () -> new StemBlock(GOLDEN_MELON.get(), AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.HARD_CROP)), null, false);
	public static final RegistryObject<GoldenCakeBlock> GOLDEN_CAKE = registerBlock("golden_cake", () -> new GoldenCakeBlock(Block.Properties.copy(Blocks.CAKE).noDrops()), CAItemGroups.FOOD, 1);
	public static final RegistryObject<EnchantedGoldenCakeBlock> ENCHANTED_GOLDEN_CAKE = registerEnchantedBlock("enchanted_golden_cake", () -> new EnchantedGoldenCakeBlock(Block.Properties.copy(Blocks.CAKE).noDrops()), CAItemGroups.FOOD, 1);
	public static final RegistryObject<TopTubeBlock> TUBE_WORM = registerBlock("tube_worm", () -> new TopTubeBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.BONE_BLOCK).noCollission().instabreak()), CAItemGroups.BLOCKS);
	public static final RegistryObject<TubeBlock> TUBE_WORM_PLANT = registerBlock("tube_worm_plant", () -> new TubeBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.BONE_BLOCK).noCollission().instabreak().lootFrom(CABlocks.TUBE_WORM)), null, false);
	public static final RegistryObject<CornTopBlock> CORN_TOP_BLOCK = registerBlock("corn_top_block", () -> new CornTopBlock(Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks(), Direction.UP, Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D), 4), CAItemGroups.FOOD, false);
	public static final RegistryObject<CornBodyBlock> CORN_BODY_BLOCK = registerBlock("corn_body_block", () -> new CornBodyBlock(Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks(), Direction.UP, Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D)), CAItemGroups.FOOD, false);
	public static final RegistryObject<TomatoTopBlock> TOMATO_TOP_BLOCK = registerBlock("tomato_top_block", () -> new TomatoTopBlock(Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks(), Direction.UP, Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D), 3), CAItemGroups.FOOD, false);
	public static final RegistryObject<TomatoBodyBlock> TOMATO_BODY_BLOCK = registerBlock("tomato_body_block", () -> new TomatoBodyBlock(Block.Properties.copy(Blocks.SUGAR_CANE).randomTicks(), Direction.UP, Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D)), CAItemGroups.FOOD, false);
	public static final RegistryObject<StrawberryBushBlock> STRAWBERRY_PLANT = registerBlock("strawberry_plant", () -> new StrawberryBushBlock(CAItems.STRAWBERRY_SEEDS, CAItems.STRAWBERRY, Block.Properties.copy(Blocks.SWEET_BERRY_BUSH).randomTicks()), CAItemGroups.FOOD, false);

	// APRIL FOOLS BLOCKS
	public static final RegistryObject<Block> CHERRY_COBBLESTONE = registerBlock("cherry_cobblestone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops().strength(100.0F, 2400.0F)), CAItemGroups.BLOCKS);
	public static final RegistryObject<CherryCampfireBlock> CHERRY_CAMPFIRE = registerBlock("cherry_campfire", () -> new CherryCampfireBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD).randomTicks().noOcclusion().lightLevel((state) -> 14), true), CAItemGroups.BLOCKS);
	public static final RegistryObject<CherryFireBlock> CHERRY_FIRE = registerBlock("cherry_fire", () -> new CherryFireBlock(AbstractBlock.Properties.of(Material.FIRE, MaterialColor.COLOR_PINK).noCollission().instabreak().lightLevel((state) -> 14).sound(SoundType.WOOL)), null);
	public static final RegistryObject<LanternBlock> CHERRY_LANTERN = registerBlock("cherry_lantern", () -> new LanternBlock(AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5F).sound(SoundType.LANTERN).lightLevel((state) -> 14).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CherryTorchBlock> CHERRY_TORCH = registerBlock("cherry_torch", () -> new CherryTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 14).sound(SoundType.WOOD)), null, false);
	public static final RegistryObject<WallCherryTorchBlock> WALL_CHERRY_TORCH = registerBlock("wall_cherry_torch", () -> new WallCherryTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 14).sound(SoundType.WOOD).lootFrom(CABlocks.CHERRY_TORCH)), null, false);


	// TREES
	public static final RegistryObject<RotatedPillarBlock> APPLE_LOG = registerBlock("apple_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> APPLE_PLANKS = registerBlock("apple_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.WOOD)), CAItemGroups.BLOCKS);
	public static final RegistryObject<FruitableLeavesBlock> APPLE_LEAVES = registerBlock("apple_leaves", () -> new FruitableLeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES), () -> Items.APPLE, 1, 1), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> CHERRY_LOG = registerBlock("cherry_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<FruitableLeavesBlock> CHERRY_LEAVES = registerBlock("cherry_leaves", () -> new FruitableLeavesBlock(AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.COLOR_PINK), CAItems.CHERRIES, 2, 4), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> CHERRY_PLANKS = registerBlock("cherry_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_PINK)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> PEACH_LOG = registerBlock("peach_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<FruitableLeavesBlock> PEACH_LEAVES = registerBlock("peach_leaves", () -> new FruitableLeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES), CAItems.PEACH, 1, 3), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> PEACH_PLANKS = registerBlock("peach_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_WHITE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> DUPLICATION_LOG = registerBlock("duplication_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<LeavesBlock> DUPLICATION_LEAVES = registerBlock("duplication_leaves", () -> new LeavesBlock(AbstractBlock.Properties.copy(Blocks.OAK_LEAVES)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> DUPLICATION_PLANKS = registerBlock("duplication_planks", () -> new Block(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_ORANGE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_PEACH_LOG = registerBlock("stripped_peach_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_DUPLICATION_LOG = registerBlock("stripped_duplication_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.STRIPPED_OAK_LOG)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> DEAD_DUPLICATION_LOG = registerBlock("dead_duplication_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.OAK_LOG)), CAItemGroups.BLOCKS);
	
	public static final RegistryObject<SaplingBlock> APPLE_SAPLING = registerBlock("apple_sapling", () -> new SaplingBlock(new FancyableTree(() -> CAConfiguredFeatures.FANCY_APPLE_TREE, () -> CAConfiguredFeatures.FANCY_APPLE_TREE_BEES_005, () -> CAConfiguredFeatures.APPLE_TREE, () -> CAConfiguredFeatures.APPLE_TREE_BEES_005),
		AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)), CAItemGroups.ITEMS);
	
	public static final RegistryObject<SaplingBlock> CHERRY_SAPLING = registerBlock("cherry_sapling", () -> new SaplingBlock(new FancyableTree(() -> CAConfiguredFeatures.FANCY_CHERRY_TREE, () -> CAConfiguredFeatures.FANCY_CHERRY_TREE_BEES_005, () -> CAConfiguredFeatures.CHERRY_TREE, () -> CAConfiguredFeatures.CHERRY_TREE_BEES_005),
			AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)), CAItemGroups.ITEMS);
	
	public static final RegistryObject<SaplingBlock> PEACH_SAPLING = registerBlock("peach_sapling", () -> new SaplingBlock(new FancyableTree(() -> CAConfiguredFeatures.FANCY_PEACH_TREE, () -> CAConfiguredFeatures.FANCY_PEACH_TREE_BEES_005, () -> CAConfiguredFeatures.PEACH_TREE, () -> CAConfiguredFeatures.PEACH_TREE_BEES_005),
			AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)), CAItemGroups.ITEMS);
	
	// DUNGEON BLOCKS
	public static final RegistryObject<Block> NEST_BLOCK = registerBlock("nest_block", () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_YELLOW).strength(0.3F).sound(SoundType.WOOD)), CAItemGroups.BLOCKS);
	public static final RegistryObject<GateBlock> GATE_BLOCK = registerBlock("gate_block", () -> new GateBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(-1.0F, 3600000.0F)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RandomTeleportBlock> RANDOM_TELEPORT_BLOCK = registerBlock("random_teleport_block", () -> new RandomTeleportBlock(Block.Properties.copy(Blocks.OBSIDIAN).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)), CAItemGroups.BLOCKS);
	
	// MINERAL ORES
	public static final RegistryObject<CAOreBlock> AMETHYST_ORE = registerBlock("amethyst_ore", () -> new CAOreBlock(AbstractBlock.Properties.of(Material.STONE).strength(4.5F, 3.25F).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)).withExpDrop(3, 7), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> RUBY_ORE = registerBlock("ruby_ore", () -> new CAOreBlock(AbstractBlock.Properties.of(Material.STONE).strength(6.5F, 3.25F).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)).withExpDrop(4, 9), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> NETHER_RUBY_ORE = registerBlock("nether_ruby_ore", () -> new CAOreBlock(Block.Properties.of(Material.STONE).strength(6.5F, 3F).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHER_ORE)).withExpDrop(4, 9), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> TIGERS_EYE_ORE = registerBlock("tigers_eye_ore", () -> new CAOreBlock(Block.Properties.of(Material.STONE).strength(4F, 3.25F).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)).withExpDrop(2, 8), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> TITANIUM_ORE = registerBlock("titanium_ore", () -> new CAOreBlock(Block.Properties.of(Material.STONE).strength(9F, 3.5F).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> URANIUM_ORE = registerBlock("uranium_ore", () -> new UraniumOreBlock(Block.Properties.of(Material.STONE)
            .strength(7.5F, 3.5F).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().randomTicks()
            .lightLevel((state) -> state.getValue(UraniumOreBlock.GLOW_STRENGTH))
            .sound(SoundType.STONE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> ALUMINUM_ORE = registerBlock("aluminum_ore", () -> new CAOreBlock(Block.Properties.of(Material.STONE).strength(3F).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> SALT_ORE = registerBlock("salt_ore", () -> new CAOreBlock(Block.Properties.of(Material.STONE).strength(2.5F).harvestLevel(0).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)).withExpDrop(0, 3), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> COPPER_ORE = registerBlock("copper_ore", () -> new CAOreBlock(Block.Properties.copy(Blocks.COAL_ORE).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> TIN_ORE = registerBlock("tin_ore", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> SILVER_ORE = registerBlock("silver_ore", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> PLATINUM_ORE = registerBlock("platinum_ore", () -> new CAOreBlock(Block.Properties.copy(Blocks.DIAMOND_ORE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> SUNSTONE_ORE = registerBlock("sunstone_ore", () -> new CAOreBlock(Block.Properties.copy(Blocks.EMERALD_ORE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel((state) -> 8)).withExpDrop(3, 6), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> BLOODSTONE_ORE = registerBlock("bloodstone_ore", () -> new CAOreBlock(Block.Properties.copy(Blocks.EMERALD_ORE).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.STONE)).withExpDrop(2, 5), CAItemGroups.BLOCKS);
	
	// INFESTED ORES
	public static final RegistryObject<AntInfestedOre> RED_ANT_INFESTED_ORE = registerBlock("red_ant_infested_ore", () -> new AntInfestedOre(CAEntityTypes.RED_ANT, Block.Properties.copy(Blocks.INFESTED_STONE).noDrops().requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(2)), CAItemGroups.BLOCKS);
	public static final RegistryObject<AntInfestedOre> TERMITE_INFESTED_ORE = registerBlock("termite_infested_ore", () -> new AntInfestedOre(CAEntityTypes.TERMITE, Block.Properties.copy(Blocks.INFESTED_STONE).noDrops().requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE).harvestLevel(2)), CAItemGroups.BLOCKS);

	// MOB ORES
	public static final RegistryObject<CAOreBlock> FOSSILISED_ACACIA_ENT = registerBlock("fossilised_acacia_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_BIRCH_ENT = registerBlock("fossilised_birch_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_DARK_OAK_ENT = registerBlock("fossilised_dark_oak_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_JUNGLE_ENT = registerBlock("fossilised_jungle_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_OAK_ENT = registerBlock("fossilised_oak_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_SPRUCE_ENT = registerBlock("fossilised_spruce_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_CRIMSON_ENT = registerBlock("fossilised_crimson_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_WARPED_ENT = registerBlock("fossilised_warped_ent", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_HERCULES_BEETLE = registerBlock("fossilised_hercules_beetle", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()).withFossilExp(), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_RUBY_BUG = registerBlock("fossilised_ruby_bug", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()).withFossilExp(), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_EMERALD_GATOR = registerBlock("fossilised_emerald_gator", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()).withFossilExp(), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_WTF = registerBlock("fossilised_wtf", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()).withFossilExp(), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_SCORPION = registerBlock("fossilised_scorpion", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()).withFossilExp(), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_WASP = registerBlock("fossilised_wasp", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()).withFossilExp(), CAItemGroups.BLOCKS);
	public static final RegistryObject<CAOreBlock> FOSSILISED_PIRAPORU = registerBlock("fossilised_piraporu", () -> new CAOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(1).requiresCorrectToolForDrops()).withFossilExp(), CAItemGroups.BLOCKS);
	
	// MINERAL BLOCKS
	public static final RegistryObject<Block> AMETHYST_BLOCK = registerBlock("amethyst_block", () -> new Block(Block.Properties.copy(Blocks.EMERALD_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.METAL)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(Block.Properties.copy(Blocks.ANCIENT_DEBRIS).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.METAL)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> TIGERS_EYE_BLOCK = registerBlock("tigers_eye_block", () -> new Block(Block.Properties.copy(Blocks.EMERALD_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block", () -> new Block(Block.Properties.copy(Blocks.NETHERITE_BLOCK).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block", () -> new Block(Block.Properties.copy(Blocks.NETHERITE_BLOCK).harvestLevel(3).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> COPPER_BLOCK = registerBlock("copper_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.METAL)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block", () -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> SUNSTONE_BLOCK = registerBlock("sunstone_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.METAL).lightLevel((state) -> 15)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> BLOODSTONE_BLOCK = registerBlock("bloodstone_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.METAL)), CAItemGroups.BLOCKS);
	
	// MOB DROP BLOCKS
	public static final RegistryObject<Block> ENDER_PEARL_BLOCK = registerBlock("ender_pearl_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.SHROOMLIGHT)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> ENDER_EYE_BLOCK = registerBlock("ender_eye_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().sound(SoundType.SHROOMLIGHT)), CAItemGroups.BLOCKS);
	
	// ANT NESTS
	public static final RegistryObject<AntNestBlock> BROWN_ANT_NEST = registerBlock("brown_ant_nest", () -> new AntNestBlock(CAEntityTypes.RAINBOW_ANT, Block.Properties.copy(Blocks.GRASS_BLOCK).randomTicks()), CAItemGroups.BLOCKS);
	public static final RegistryObject<AntNestBlock> RAINBOW_ANT_NEST = registerBlock("rainbow_ant_nest", () -> new AntNestBlock(CAEntityTypes.BROWN_ANT, Block.Properties.copy(Blocks.GRASS_BLOCK).randomTicks()), CAItemGroups.BLOCKS);
	public static final RegistryObject<AntNestBlock> RED_ANT_NEST = registerBlock("red_ant_nest", () -> new AntNestBlock(CAEntityTypes.TERMITE, Block.Properties.copy(Blocks.GRASS_BLOCK).randomTicks()), CAItemGroups.BLOCKS);
	public static final RegistryObject<AntNestBlock> UNSTABLE_ANT_NEST = registerBlock("unstable_ant_nest", () -> new AntNestBlock(CAEntityTypes.RED_ANT, Block.Properties.copy(Blocks.GRASS_BLOCK).randomTicks()), CAItemGroups.BLOCKS);
	public static final RegistryObject<AntNestBlock> TERMITE_NEST = registerBlock("termite_nest", () -> new AntNestBlock(CAEntityTypes.UNSTABLE_ANT, Block.Properties.copy(Blocks.GRASS_BLOCK).randomTicks()), CAItemGroups.BLOCKS);

	// TORCHES
	public static final RegistryObject<TorchBlock> CRYSTAL_TORCH = registerBlock("crystal_torch", () -> new TorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 14).sound(SoundType.WOOD), ParticleTypes.FLAME), null, false);
	public static final RegistryObject<WallTorchBlock> WALL_CRYSTAL_TORCH = registerBlock("wall_crystal_torch", () -> new WallTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 14).sound(SoundType.WOOD).lootFrom(CABlocks.CRYSTAL_TORCH), ParticleTypes.FLAME), null, false);
	public static final RegistryObject<TorchBlock> SUNSTONE_TORCH = registerBlock("sunstone_torch", () -> new TorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 12).sound(SoundType.WOOD), ParticleTypes.END_ROD), null, false);
	public static final RegistryObject<WallTorchBlock> WALL_SUNSTONE_TORCH = registerBlock("wall_sunstone_torch", () -> new WallTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 12).sound(SoundType.WOOD).lootFrom(CABlocks.SUNSTONE_TORCH), ParticleTypes.END_ROD), null, false);
	public static final RegistryObject<TorchBlock> EXTREME_TORCH = registerBlock("extreme_torch", () -> new TorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 15).sound(SoundType.WOOD), ParticleTypes.FLAME), null, false);
	public static final RegistryObject<WallTorchBlock> WALL_EXTREME_TORCH = registerBlock("wall_extreme_torch", () -> new WallTorchBlock(AbstractBlock.Properties.of(Material.DECORATION).noCollission().instabreak().lightLevel((state) -> 15).sound(SoundType.WOOD).lootFrom(CABlocks.EXTREME_TORCH), ParticleTypes.FLAME), null, false);
	
	// MINERS DREAM BLOCKS
	public static final RegistryObject<Block> MOLDY_PLANKS = registerBlock("moldy_planks", () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)), CAItemGroups.BLOCKS);
	public static final RegistryObject<SlabBlock> MOLDY_SLAB = registerBlock("moldy_slab", () -> new SlabBlock(Block.Properties.copy(Blocks.OAK_SLAB)), CAItemGroups.BLOCKS);
	public static final RegistryObject<FenceBlock> MOLDY_FENCE = registerBlock("moldy_fence", () -> new FenceBlock(Block.Properties.copy(Blocks.OAK_FENCE)), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> MINING_LAMP = registerBlock("mining_lamp", () -> new Block(Block.Properties.of(Material.BUILDABLE_GLASS).lightLevel((state) -> 15).strength(0.3F).sound(SoundType.GLASS)), CAItemGroups.BLOCKS);
	
	// LEGACY CRYSTAL DIMENSION
	public static final RegistryObject<Block> CRYSTAL_GRASS_BLOCK = registerBlock("crystal_grass_block", () -> new Block(Block.Properties.copy(Blocks.GRASS_BLOCK).requiresCorrectToolForDrops().isRedstoneConductor(isFalse)), CAItemGroups.BLOCKS);
	public static final RegistryObject<AntNestBlock> CRYSTAL_TERMITE_NEST = registerBlock("crystal_termite_nest", () -> new AntNestBlock(CAEntityTypes.UNSTABLE_ANT, Block.Properties.copy(CABlocks.CRYSTAL_GRASS_BLOCK.get()).randomTicks()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> KYANITE = registerBlock("kyanite", () -> new Block(Block.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().isRedstoneConductor(isFalse)), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> CRYSTAL_LOG = registerBlock("crystal_log", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_LOG).isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<RotatedPillarBlock> CRYSTAL_WOOD = registerBlock("crystal_wood", () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.OAK_WOOD).isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> CRYSTAL_WOOD_PLANKS = registerBlock("crystal_wood_planks", () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> RED_CRYSTAL_LEAVES = registerBlock("red_crystal_leaves", () -> new Block(Block.Properties.copy(Blocks.OAK_LEAVES).isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> GREEN_CRYSTAL_LEAVES = registerBlock("green_crystal_leaves", () -> new Block(Block.Properties.copy(Blocks.OAK_LEAVES).isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> YELLOW_CRYSTAL_LEAVES = registerBlock("yellow_crystal_leaves", () -> new Block(Block.Properties.copy(Blocks.OAK_LEAVES).isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CrystalClusterBlock> PINK_TOURMALINE_CLUSTER = registerBlock("pink_tourmaline_cluster", () -> new CrystalClusterBlock(Block.Properties.copy(Blocks.IRON_ORE).noOcclusion().isSuffocating(isFalse).isViewBlocking(isFalse).isRedstoneConductor(isFalse).harvestLevel(1)), CAItemGroups.BLOCKS);
	public static final RegistryObject<BuddingBlock> BUDDING_PINK_TOURMALINE = registerBlock("budding_pink_tourmaline", () -> new BuddingBlock(Block.Properties.copy(Blocks.STONE).randomTicks().isRedstoneConductor(isFalse).noOcclusion(), PINK_TOURMALINE_CLUSTER.get()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CrystalClusterBlock> CATS_EYE_CLUSTER = registerBlock("cats_eye_cluster", () -> new CrystalClusterBlock(Block.Properties.copy(Blocks.IRON_ORE).noOcclusion().isSuffocating(isFalse).isViewBlocking(isFalse).isRedstoneConductor(isFalse).harvestLevel(2)), CAItemGroups.BLOCKS);
	public static final RegistryObject<BuddingBlock> BUDDING_CATS_EYE = registerBlock("budding_cats_eye", () -> new BuddingBlock(Block.Properties.copy(Blocks.STONE).randomTicks().isRedstoneConductor(isFalse).noOcclusion(), CATS_EYE_CLUSTER.get()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CrystalEnergyBlock> CRYSTAL_ENERGY = registerBlock("crystal_energy", () -> new CrystalEnergyBlock(Block.Properties.copy(Blocks.GLASS).noOcclusion().isSuffocating(isFalse).isViewBlocking(isFalse).isRedstoneConductor(isFalse).harvestLevel(0).lightLevel((state) -> 8)), CAItemGroups.BLOCKS);
	public static final RegistryObject<CrystalCraftingTableBlock> CRYSTAL_CRAFTING_TABLE = registerBlock("crystal_crafting_table", () -> new CrystalCraftingTableBlock(Block.Properties.copy(Blocks.CRAFTING_TABLE).isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<CrystalFurnaceBlock> CRYSTAL_FURNACE = registerBlock("crystal_furnace", () -> new CrystalFurnaceBlock(Block.Properties.copy(Blocks.FURNACE).isRedstoneConductor(isFalse).noOcclusion().lightLevel(lightValueFunction.apply(13))), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> PINK_TOURMALINE_BLOCK = registerBlock("pink_tourmaline_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	public static final RegistryObject<Block> CATS_EYE_BLOCK = registerBlock("cats_eye_block", () -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().isRedstoneConductor(isFalse).noOcclusion()), CAItemGroups.BLOCKS);
	
	/**
	 * No stack size and generateItem variant, defaults to 64 and true, respectively
	 *
	 * @param <B>       Block type
	 * @param name      Block registry name
	 * @param supplier  Block instance supplier
	 * @param itemGroup Block item group, {@code null} for no item group
	 * @return A RegistryObject<B>
	 */
	public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup) {
		return registerBlock(name, supplier, itemGroup, true);
	}
	
	/**
	 * No stack size variant, defaults to 64
	 *
	 * @param <B>          Block type
	 * @param name         Block registry name
	 * @param supplier     Block instance supplier
	 * @param itemGroup    Block item group, {@code null} for no item group
	 * @param generateItem If a BlockItem should be generated for this block
	 * @return A RegistryObject<B>
	 */
	public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
		return registerBlock(name, supplier, itemGroup, 64, generateItem);
	}
	
	/**
	 * No generateItem variant, defaults to true
	 *
	 * @param <B>       Block type
	 * @param name      Block registry name
	 * @param supplier  Block instance supplier
	 * @param itemGroup Block item group, {@code null} for no item group
	 * @param stackSize Block stack size
	 * @return A RegistryObject<B>
	 */
	public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, int stackSize) {
		return registerBlock(name, supplier, itemGroup, stackSize, true);
	}
	
	/**
	 * Registers a block to the BLOCKS deferred register and BlockItem to the
	 * ITEM_BLOCKS deferred register
	 *
	 * @param <B>          Block type
	 * @param name         Block registry name
	 * @param supplier     Block instance supplier
	 * @param itemGroup    Block item group, {@code null} for no item group
	 * @param stackSize    Block stack size
	 * @param generateItem If a BlockItem should be generated for this block
	 * @return A RegistryObject<B>
	 */
	public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, int stackSize, boolean generateItem) {
		RegistryObject<B> block = CABlocks.BLOCKS.register(name, supplier);
		if (generateItem)
			ITEM_BLOCKS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).stacksTo(stackSize)));
		return block;
	}
	
	public static <E extends Block> RegistryObject<E> registerEnchantedBlock(String name, Supplier<? extends E> supplier, ItemGroup itemGroup, int stackSize) {
		RegistryObject<E> block = CABlocks.BLOCKS.register(name, supplier);
		ITEM_BLOCKS.register(name, () -> new EnchantedBlockItem(block.get(), new Item.Properties().tab(itemGroup).stacksTo(stackSize)));
		return block;
	}
}
