package io.github.chaosawakens.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class WallCherryTorchBlock extends WallTorchBlock {
	private static final IParticleData dustParticles = new RedstoneParticleData(0.847F, 0.572F, 0.811F, 1.0F);

	public WallCherryTorchBlock(Properties properties) {
		super(properties, null);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
		double d0 = (double) pos.getX() + 0.5D;
		double d1 = (double) pos.getY() + 0.7D;
		double d2 = (double) pos.getZ() + 0.5D;
		world.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		world.addParticle(dustParticles, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
}
