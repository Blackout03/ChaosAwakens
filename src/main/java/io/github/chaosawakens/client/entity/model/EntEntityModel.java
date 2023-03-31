package io.github.chaosawakens.client.entity.model;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.entity.EntEntity;
import io.github.chaosawakens.common.entity.EntEntity.Types;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class EntEntityModel extends AnimatedTickingGeoModel<EntEntity> {
	private final EntEntity.Types entType;

	public EntEntityModel(Types entType) {
		super();
		this.entType = entType;
	}

	@Override
	public ResourceLocation getModelLocation(EntEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "geo/ent/" + this.entType.getNameString() + "_ent.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(EntEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "textures/entity/ent/" + this.entType.getNameString() + "_ent.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(EntEntity object) {
		return new ResourceLocation(ChaosAwakens.MODID, "animations/ent.animation.json");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setLivingAnimations(EntEntity entity, Integer uniqueID, @SuppressWarnings("rawtypes") AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);

		IBone root = this.getAnimationProcessor().getBone("root");
		IBone head = this.getAnimationProcessor().getBone("Head");
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		root.setScaleX(0.1f);
		root.setScaleY(0.1f);
		root.setScaleZ(0.1f);
		head.setRotationX((extraData.headPitch) * ((float) Math.PI / 180F));
		head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 270F));
	}
}
