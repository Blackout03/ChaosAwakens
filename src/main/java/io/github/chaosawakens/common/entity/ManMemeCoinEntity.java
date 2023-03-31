package io.github.chaosawakens.common.entity;

import io.github.chaosawakens.common.entity.ai.RotateGoal;
import io.github.chaosawakens.common.registry.CABlocks;
import io.github.chaosawakens.common.registry.CAItems;
import io.github.chaosawakens.common.registry.CATags;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AmbientEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManMemeCoinEntity extends MobEntity implements IAnimatable {
	private final AnimationFactory factory = new AnimationFactory(this);

	public ManMemeCoinEntity(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
		this.noCulling = true;
	}

	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.createLivingAttributes()
				.add(Attributes.MAX_HEALTH, 1)
				.add(Attributes.MOVEMENT_SPEED, 0D)
				.add(Attributes.FOLLOW_RANGE, 0);
	}

	public <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		return PlayState.CONTINUE;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new RotateGoal(this));
	}

	public static boolean checkManMemeCoinSpawnRules(EntityType<? extends ManMemeCoinEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos blockPos, Random random) {
		return world.canSeeSky(blockPos);
	}

	@Override
	public void die(DamageSource cause) {
		super.die(cause);

		BlockPos blockPos = this.blockPosition();
		int chance = random.nextInt(11);
		IItemProvider itemToDrop = null;
		IItemProvider itemToDrop1;
		if (chance == 0) {
			itemToDrop = Items.DIAMOND;
		} else if (chance == 1) {
			itemToDrop = CAItems.URANIUM_NUGGET.get();
		} else if (chance == 2) {
			itemToDrop = CAItems.TITANIUM_NUGGET.get();
		} else if (chance == 3) {
			itemToDrop = Items.EMERALD;
		} else if (chance == 4) {
			itemToDrop = CAItems.EMERALD_SWORD.get();
		} else if (chance == 5) {
			itemToDrop = CAItems.EMERALD_PICKAXE.get();
		} else if (chance == 6) {
			itemToDrop = CAItems.EMERALD_AXE.get();
		} else if (chance == 7) {
			itemToDrop = CAItems.EMERALD_SHOVEL.get();
		} else if (chance == 8) {
			itemToDrop = CAItems.EMERALD_HOE.get();
		} else if (chance == 9) {
			itemToDrop = CAItems.MAN_MEME_COIN_SPAWN_EGG.get();
		} else {
			for (int i = 0; i < 3; i++) {
				this.level.addFreshEntity(new ItemEntity(this.level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), randomItem()));
			}
		}
		if (chance != 10) {
			ItemStack itemStack = new ItemStack(itemToDrop);
			if (itemStack.getItem().equals(CAItems.EMERALD_SWORD.get())) {
				itemStack.enchant(Enchantments.MOB_LOOTING, 1);
			}
			if (itemStack.getItem().equals(CAItems.EMERALD_PICKAXE.get()) ||
					itemStack.getItem().equals(CAItems.EMERALD_AXE.get()) ||
					itemStack.getItem().equals(CAItems.EMERALD_SHOVEL.get()) ||
					itemStack.getItem().equals(CAItems.EMERALD_HOE.get())) {
				itemStack.enchant(Enchantments.SILK_TOUCH, 1);
			}
			this.level.addFreshEntity(new ItemEntity(this.level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), itemStack));
		}
		itemToDrop1 = CAItems.FLAMING_HOT_CHEETOS.get();
		ItemStack itemStack1 = new ItemStack(itemToDrop1);
		this.level.addFreshEntity(new ItemEntity(this.level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), itemStack1));
	}

	public ItemStack randomItem() {
		List<Item> itemList = new ArrayList<>(ForgeRegistries.ITEMS.getValues());
		itemList.removeIf(item -> item.is(CATags.Items.UNDROPPABLE));
		Item randomItem = itemList.get(random.nextInt(itemList.size()));

		return randomItem.getDefaultInstance();
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "manmemecoincontroller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
