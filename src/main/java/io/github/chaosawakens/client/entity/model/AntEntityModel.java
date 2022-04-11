package io.github.chaosawakens.client.entity.model;

import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.entity.AntEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class AntEntityModel extends AnimatedGeoModel<AntEntity> {

    private final String textureName;

    public AntEntityModel(String textureName) {
        this.textureName = textureName;
    }

    @Override
    public ResourceLocation getModelLocation(AntEntity object) {
        return new ResourceLocation(ChaosAwakens.MODID, "geo/ant.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AntEntity object) {
        return new ResourceLocation(ChaosAwakens.MODID, "textures/entity/ant/" + textureName + ".png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AntEntity object) {
        return new ResourceLocation(ChaosAwakens.MODID, "animations/ant.animation.json");
    }

    @Override
    public void setLivingAnimations(AntEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone root = this.getAnimationProcessor().getBone("root");
        IBone head = this.getAnimationProcessor().getBone("head");
        root.setScaleX(10.0f);
        root.setScaleY(10.0f);
        root.setScaleZ(10.0f);
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX((extraData.headPitch) * ((float) Math.PI / 180F));
        head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 270F));
    }
}
