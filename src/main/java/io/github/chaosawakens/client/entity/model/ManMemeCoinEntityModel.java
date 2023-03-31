package io.github.chaosawakens.client.entity.model;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.entity.ManMemeCoinEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ManMemeCoinEntityModel extends AnimatedGeoModel<ManMemeCoinEntity> {
	@Override
	public ResourceLocation getModelLocation(ManMemeCoinEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "geo/man_meme_coin.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ManMemeCoinEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "textures/entity/man_meme_coin.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ManMemeCoinEntity animatable) {
		return new ResourceLocation(ChaosAwakens.MODID, "animations/dummy.animation.json");
	}

	@Override
	public void setLivingAnimations(ManMemeCoinEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
	}
}
