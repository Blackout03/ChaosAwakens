package io.github.chaosawakens.common.blocks;

import io.github.chaosawakens.common.registry.CATags;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class CherryFireBlock extends AbstractFireBlock {
	public CherryFireBlock(Properties properties) {
		super(properties, 0);
	}

	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return this.canSurvive(stateIn, worldIn, currentPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
	}

	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return shouldLightCherryFire(worldIn.getBlockState(pos.below()).getBlock());
	}

	public static boolean shouldLightCherryFire(Block block) {
		return block.is(CATags.Blocks.CHERRY_FIRE_BASE_BLOCKS);
	}

	protected boolean canBurn(BlockState state) {
		return false;
	}

	@Override
	public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
		if (entity instanceof LivingEntity && entity.isAlive()) {
			LivingEntity livingEntity = (LivingEntity) entity;
			if (!livingEntity.hasEffect(Effects.REGENERATION) || !livingEntity.hasEffect(Effects.HEALTH_BOOST)) {
				livingEntity.addEffect(new EffectInstance(Effects.REGENERATION, 150, 2));
				livingEntity.addEffect(new EffectInstance(Effects.HEALTH_BOOST, 300, 1));
			}
		}

		super.entityInside(state, world, pos, entity);
	}
}
