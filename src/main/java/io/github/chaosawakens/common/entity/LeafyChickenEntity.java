package io.github.chaosawakens.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.chaosawakens.api.IAnimatableEntity;
import io.github.chaosawakens.common.registry.CAEntityTypes;
import io.github.chaosawakens.common.registry.CAItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class LeafyChickenEntity extends AnimalEntity implements IAnimatableEntity, IAnimationTickable {
	private final AnimationFactory factory = new AnimationFactory(this);
	private final AnimationController<?> controller = new AnimationController<>(this, "leafychickencontroller", animationInterval(), this::predicate);
	private static final DataParameter<Boolean> PANIC = EntityDataManager.defineId(LeafyChickenEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS, CAItems.LETTUCE_SEEDS.get(), CAItems.CORN_SEEDS.get(), CAItems.RADISH_SEEDS.get(), CAItems.STRAWBERRY_SEEDS.get(), CAItems.TOMATO_SEEDS.get());
	public float flap;
	public float flapSpeed;
	public float oFlapSpeed;
	public float oFlap;
	public float flapping = 1.0F;
	public int eggTime = this.random.nextInt(4500) + 4500;
	public boolean isChickenJockey;

	public LeafyChickenEntity(EntityType<? extends AnimalEntity> type, World world) {
		super(type, world);
		this.setPathfindingMalus(PathNodeType.WATER, 0.0F);
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.createLivingAttributes()
				.add(Attributes.MAX_HEALTH, 5)
				.add(Attributes.FOLLOW_RANGE, 5)
				.add(Attributes.MOVEMENT_SPEED, 0.25F);
	}
	
	public <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.leafy_chicken.idle", true));
			return PlayState.CONTINUE;
		}
		if (!isOnGround()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.leafy_chicken.falling", true));
			return PlayState.CONTINUE;
		}
		if (event.isMoving() && !getPanicking()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.leafy_chicken.walk", true));
			return PlayState.CONTINUE;
		}
		if (event.isMoving() && this.getPanicking()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.leafy_chicken.run", true));
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(controller);
	}
	
	@Override
	public void aiStep() {
		super.aiStep();
		this.oFlap = this.flap;
		this.oFlapSpeed = this.flapSpeed;
		this.flapSpeed = (float)((double)this.flapSpeed + (double)(this.onGround ? -1 : 4) * 0.3D);
		this.flapSpeed = MathHelper.clamp(this.flapSpeed, 0.0F, 1.0F);
		if (!this.onGround && this.flapping < 1.0F) {
			this.flapping = 1.0F;
		}

		this.flapping = (float)((double)this.flapping * 0.9D);
		Vector3d vector3d = this.getDeltaMovement();
		if (!this.onGround && vector3d.y < 0.0D) {
			this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));
		}

		this.flap += this.flapping * 2.0F;
		if (!this.level.isClientSide && this.isAlive() && !this.isBaby() && !this.isChickenJockey() && --this.eggTime <= 0) {
			this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.spawnAtLocation(randomEgg());
			this.eggTime = this.random.nextInt(4500) + 4500;
		}
	}

	public ItemStack randomEgg() {
		List<Item> itemList = new ArrayList<>(ForgeRegistries.ITEMS.getValues());
		itemList.removeIf(item -> !Objects.requireNonNull(item.getRegistryName()).getPath().contains("_spawn_egg"));
		itemList.removeIf(item -> Objects.requireNonNull(item.getRegistryName()).getPath().contains("robo"));
		Item randomItem = itemList.get(random.nextInt(itemList.size()));

		return randomItem.getDefaultInstance();
	}

	public boolean getPanicking() {
		return this.entityData.get(PANIC);
	}

	public void setPanicking(boolean panicking) {
		this.entityData.set(PANIC, panicking);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PANIC, false);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(2, new LeafyChickenPanicGoal(this));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, FOOD_ITEMS));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));	    
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
		return this.isBaby() ? p_213348_2_.height * 0.85F : p_213348_2_.height * 0.92F;
	}
	
	@Override
	public LeafyChickenEntity getBreedOffspring(ServerWorld world, AgeableEntity mate) {
		return CAEntityTypes.LEAFY_CHICKEN.get().create(world);
	}

	public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
		return false;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.CHICKEN_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
		return SoundEvents.CHICKEN_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.CHICKEN_DEATH;
	}

	protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
		this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
	}

	public boolean isFood(ItemStack p_70877_1_) {
		return FOOD_ITEMS.test(p_70877_1_);
	}

	protected int getExperienceReward(PlayerEntity p_70693_1_) {
		return this.isChickenJockey() ? 10 : super.getExperienceReward(p_70693_1_);
	}

	public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
		super.readAdditionalSaveData(p_70037_1_);
		this.isChickenJockey = p_70037_1_.getBoolean("IsChickenJockey");
		if (p_70037_1_.contains("EggLayTime")) {
			this.eggTime = p_70037_1_.getInt("EggLayTime");
		}

	}

	public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
		super.addAdditionalSaveData(p_213281_1_);
		p_213281_1_.putBoolean("IsChickenJockey", this.isChickenJockey);
		p_213281_1_.putInt("EggLayTime", this.eggTime);
	}

	public boolean removeWhenFarAway(double p_213397_1_) {
		return this.isChickenJockey();
	}

	public void positionRider(Entity p_184232_1_) {
		super.positionRider(p_184232_1_);
		float f = MathHelper.sin(this.yBodyRot * ((float)Math.PI / 180F));
		float f1 = MathHelper.cos(this.yBodyRot * ((float)Math.PI / 180F));
		float f2 = 0.1F;
		float f3 = 0.0F;
		p_184232_1_.setPos(this.getX() + (double)(0.1F * f), this.getY(0.5D) + p_184232_1_.getMyRidingOffset() + 0.0D, this.getZ() - (double)(0.1F * f1));
		if (p_184232_1_ instanceof LivingEntity) {
			((LivingEntity)p_184232_1_).yBodyRot = this.yBodyRot;
		}

	}

	public boolean isChickenJockey() {
		return this.isChickenJockey;
	}

	public void setChickenJockey(boolean p_152117_1_) {
		this.isChickenJockey = p_152117_1_;
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	static class LeafyChickenPanicGoal extends PanicGoal {
		LeafyChickenEntity leafyChickenEntity;

		public LeafyChickenPanicGoal(CreatureEntity entity) {
			super(entity, 1.4D);
			this.leafyChickenEntity = (LeafyChickenEntity) entity;
		}

		@Override
		public void start() {
			super.start();
			this.leafyChickenEntity.setPanicking(true);
		}

		@Override
		public void stop() {
			super.stop();
			this.leafyChickenEntity.setPanicking(false);
		}
	}

	@Override
	public int tickTimer() {
		return tickCount;
	}

	@Override
	public AnimationController<?> getController() {
		return controller;
	}

	@Override
	public int animationInterval() {
		return 3;
	}
}
