package io.github.chaosawakens.mixins;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.chaosawakens.api.IUtilityHelper;
import io.github.chaosawakens.common.items.EnderScaleArmorItem;
import io.github.chaosawakens.common.registry.CAEffects;
import io.github.chaosawakens.common.registry.CAItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

//TODO Re-code this entire file, the code I wrote here is just a temporary substitute while other stuff gets worked on
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	private static final UUID SLOW_FALLING_ID = UUID.fromString("A5B6CF2A-2F7C-31EF-9022-7C3E7D5E6ABA");
	private static final AttributeModifier SLOW_FALLING = new AttributeModifier(SLOW_FALLING_ID, "Slow falling acceleration reduction", -0.07, AttributeModifier.Operation.ADDITION); // Add -0.07 to 0.08 so we get the vanilla default of 0.01
	
	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}
	 
	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setSharedFlag(IZ)V"), method = "updateFallFlying")
	public boolean chaosawakens$setFlag(boolean value) {
		LivingEntity entity = (LivingEntity) (Object) this;
		if (EnderScaleArmorItem.isElytraToggled((entity.getItemBySlot(EquipmentSlotType.CHEST)))) {
			ItemStack chestplate = entity.getItemBySlot(EquipmentSlotType.CHEST);
			value = IUtilityHelper.isFullArmorSet((PlayerEntity) entity, CAItems.ENDER_DRAGON_SCALE_HELMET.get(), CAItems.ENDER_DRAGON_SCALE_CHESTPLATE.get(), CAItems.ENDER_DRAGON_SCALE_LEGGINGS.get(), CAItems.ENDER_DRAGON_SCALE_BOOTS.get()) && EnderScaleArmorItem.isElytraToggled(chestplate);
			entity.setSharedFlag(7, entity.getSharedFlag(7) && value);
			return entity.getSharedFlag(7);
		}
		return entity.getSharedFlag(7);
	}
	
	@Inject(method = "Lnet/minecraft/entity/LivingEntity;aiStep()V", at = @At("INVOKE"), cancellable = true)
	public void chaosawakens$aiStep(CallbackInfo info) {
		LivingEntity entity = (LivingEntity) (Object) this;
		if (EnderScaleArmorItem.isElytraToggled((entity.getItemBySlot(EquipmentSlotType.CHEST)))) {
			entity.flyingSpeed = 0.012F;
		}
	}

	@Inject(method = "isImmobile", at = @At("HEAD"), cancellable = true)
	protected void chaosawakens$isImmobile(CallbackInfoReturnable<Boolean> cir) {
		LivingEntity entity = (LivingEntity) (Object) this;
		if (entity.hasEffect(CAEffects.PARALYSIS_EFFECT.get())) {
			entity.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
			entity.setNoActionTime(entity.getEffect(CAEffects.PARALYSIS_EFFECT.get()).getDuration());
			cir.setReturnValue(true);
		}
	}
}