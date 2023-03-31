package io.github.chaosawakens.common.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CherryCampfireBlock extends CampfireBlock {
	public CherryCampfireBlock(Properties properties, boolean spawnParticles) {
		super(spawnParticles, 0, properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(LIT, true).setValue(SIGNAL_FIRE, false).setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
	}

	@Override
	public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity && entity.isAlive() && state.getValue(LIT)) {
			LivingEntity livingEntity = (LivingEntity) entity;
			if (!livingEntity.hasEffect(Effects.REGENERATION) || !livingEntity.hasEffect(Effects.HEALTH_BOOST)) {
				livingEntity.addEffect(new EffectInstance(Effects.REGENERATION, 150, 2));
				livingEntity.addEffect(new EffectInstance(Effects.HEALTH_BOOST, 300, 1));
			}
		}
		super.entityInside(state, world, pos, entity);
	}
}