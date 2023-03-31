package io.github.chaosawakens.common.registry;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class CAFoods {
	// APRILS FOOLS FOOD
	public static final Food FOOD_FLAMING_HOT_CHEETOS = new Food.Builder().nutrition(10).saturationMod(0.5F).fast().alwaysEat().effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 4000, 1), 1.0F).effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 4000, 1), 1.0F).effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 4000, 1), 1.0F).build();

	// MEATS
	public static final Food FOOD_RAW_BACON = new Food.Builder().nutrition(3).saturationMod(0.33F).meat().build();
	public static final Food FOOD_COOKED_BACON = new Food.Builder().nutrition(8).saturationMod(1F).meat().build();
	public static final Food FOOD_RAW_CORNDOG = new Food.Builder().nutrition(4).saturationMod(0.25F).build();
	public static final Food FOOD_COOKED_CORNDOG = new Food.Builder().nutrition(8).saturationMod(1F).build();
	public static final Food FOOD_CRAB_MEAT = new Food.Builder().nutrition(3).saturationMod(0.25F).meat().build();
	public static final Food FOOD_COOKED_CRAB_MEAT = new Food.Builder().nutrition(6).saturationMod(0.75F).meat().build();
	public static final Food FOOD_PEACOCK_LEG = new Food.Builder().nutrition(2).saturationMod(0.5F).build();
	public static final Food FOOD_COOKED_PEACOCK_LEG = new Food.Builder().nutrition(6).saturationMod(0.8F).build();
	public static final Food FOOD_RAW_VENISON = new Food.Builder().nutrition(2).saturationMod(0.5F).meat().build();
	public static final Food FOOD_COOKED_VENISON = new Food.Builder().nutrition(6).saturationMod(0.8F).meat().build();

	// PLANTS
	public static final Food FOOD_CHERRIES = new Food.Builder().nutrition(2).saturationMod(0.45F).build();
	public static final Food FOOD_CORN = new Food.Builder().nutrition(2).saturationMod(0.5F).build();
	public static final Food FOOD_LETTUCE = new Food.Builder().nutrition(3).saturationMod(0.45F).build();
	public static final Food FOOD_PEACH = new Food.Builder().nutrition(3).saturationMod(0.55F).build();
	public static final Food FOOD_RADISH = new Food.Builder().nutrition(2).saturationMod(0.45F).build();
	public static final Food FOOD_STRAWBERRY = new Food.Builder().nutrition(2).saturationMod(0.65F).build();
	public static final Food FOOD_TOMATO = new Food.Builder().nutrition(2).saturationMod(0.55F).build();

	// CRYSTAL PLANTS
	public static final Food FOOD_CRYSTAL_APPLE = new Food.Builder().nutrition(5).saturationMod(0.85F).alwaysEat().effect(() -> new EffectInstance(Effects.WEAKNESS, 3000, 0), 1.0F).effect(() -> new EffectInstance(Effects.POISON, 3000, 0), 1.0F).build();
	public static final Food FOOD_CRYSTAL_BEETROOT = new Food.Builder().nutrition(1).saturationMod(0.15F).alwaysEat().effect(() -> new EffectInstance(Effects.WITHER, 3000, 0), 1.0F).effect(() -> new EffectInstance(Effects.POISON, 3000, 0), 1.0F).build();
	public static final Food FOOD_CRYSTAL_CARROT = new Food.Builder().nutrition(3).saturationMod(0.35F).alwaysEat().effect(() -> new EffectInstance(Effects.BLINDNESS, 3000, 0), 1.0F).effect(() -> new EffectInstance(Effects.POISON, 3000, 0), 1.0F).build();
	public static final Food FOOD_CRYSTAL_POTATO = new Food.Builder().nutrition(2).saturationMod(0.30F).alwaysEat().effect(() -> new EffectInstance(Effects.HUNGER, 3000, 0), 1.0F).effect(() -> new EffectInstance(Effects.POISON, 3000, 0), 1.0F).build();

	// MANUFACTURED
	public static final Food FOOD_BLT_SANDWICH = new Food.Builder().nutrition(9).saturationMod(1.1F).build();
	public static final Food FOOD_CHEESE = new Food.Builder().nutrition(4).saturationMod(0.5F).build();
	public static final Food FOOD_GARDEN_SALAD = new Food.Builder().nutrition(5).saturationMod(0.95F).build();
	public static final Food FOOD_SEAFOOD_PATTY = new Food.Builder().nutrition(8).saturationMod(0.9F).build();
	public static final Food FOOD_RADISH_STEW = new Food.Builder().nutrition(5).saturationMod(0.75F).build();

	// POPCORN
	public static final Food FOOD_POPCORN = new Food.Builder().nutrition(2).saturationMod(0.2F).build();
	public static final Food FOOD_POPCORN_BAG = new Food.Builder().nutrition(4).saturationMod(0.25F).build();
	public static final Food FOOD_SALTED_POPCORN_BAG = new Food.Builder().nutrition(5).saturationMod(0.275F).build();
	public static final Food FOOD_BUTTERED_POPCORN_BAG = new Food.Builder().nutrition(6).saturationMod(0.3F).build();

	// CANDY
	public static final Food FOOD_BUTTER_CANDY = new Food.Builder().nutrition(2).saturationMod(0.15F).alwaysEat().effect(() -> new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 400, 1), 1.0F).build();
	public static final Food FOOD_CANDYCANE = new Food.Builder().nutrition(2).saturationMod(0.15F).alwaysEat().effect(() -> new EffectInstance(Effects.DIG_SLOWDOWN, 400, 1), 1.0F).build();

	// FISH
	public static final Food FOOD_BLUE_FISH = new Food.Builder().nutrition(5).saturationMod(0.6F).build();
	public static final Food FOOD_GRAY_FISH = new Food.Builder().nutrition(5).saturationMod(0.6F).build();
	public static final Food FOOD_GREEN_FISH = new Food.Builder().nutrition(5).saturationMod(0.6F).build();
	public static final Food FOOD_PINK_FISH = new Food.Builder().nutrition(5).saturationMod(0.6F).build();
	public static final Food FOOD_SPARK_FISH = new Food.Builder().nutrition(3).saturationMod(0.2F).alwaysEat().effect(() -> new EffectInstance(Effects.LEVITATION, 100, 0), 1.0F).build();
	public static final Food FOOD_FIRE_FISH = new Food.Builder().nutrition(3).saturationMod(0.4F).alwaysEat().effect(() -> new EffectInstance(Effects.LEVITATION, 200, 0), 1.0F).build();
	public static final Food FOOD_LAVA_EEL = new Food.Builder().nutrition(4).saturationMod(0.4F).alwaysEat().effect(() -> new EffectInstance(Effects.LEVITATION, 400, 0), 1.0F).build();
	public static final Food FOOD_SUN_FISH = new Food.Builder().nutrition(4).saturationMod(0.6F).alwaysEat().effect(() -> new EffectInstance(Effects.LEVITATION, 600, 0), 1.0F).build();

	// GOLDEN FOOD
	public static final Food FOOD_GOLDEN_MELON_SLICE = new Food.Builder().nutrition(2).saturationMod(0.45F).alwaysEat().build();
	public static final Food FOOD_GOLDEN_BEETROOT = new Food.Builder().nutrition(3).saturationMod(0.45F).alwaysEat().build();
	public static final Food FOOD_GOLDEN_POTATO = new Food.Builder().nutrition(3).saturationMod(0.65F).alwaysEat().effect(() -> new EffectInstance(Effects.POISON, 400, 0), 1.0F).build();
	public static final Food FOOD_GOLDEN_BAKED_POTATO = new Food.Builder().nutrition(6).saturationMod(0.65F).alwaysEat().effect(() -> new EffectInstance(Effects.POISON, 400, 0), 1.0F).build();
	public static final Food FOOD_ENCHANTED_GOLDEN_CARROT = new Food.Builder().nutrition(6).saturationMod(0.85F).alwaysEat().effect(() -> new EffectInstance(Effects.POISON, 600, 2), 1.0F).effect(() -> new EffectInstance(Effects.BLINDNESS, 1200, 0), 1.0F).effect(() -> new EffectInstance(Effects.WITHER, 1200, 0), 1.0F).build();
	public static final Food FOOD_ULTIMATE_APPLE = new Food.Builder().nutrition(6).saturationMod(1.5F).alwaysEat().effect(() -> new EffectInstance(Effects.WEAKNESS, 3900, 2), 1.0F).effect(() -> new EffectInstance(Effects.POISON, 4800, 3), 1.0F).effect(() -> new EffectInstance(Effects.WITHER, 2400, 3), 1.0F).effect(() -> new EffectInstance(Effects.LEVITATION, 7200, 0), 1.0F).build();
}
