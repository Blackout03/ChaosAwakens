package io.github.chaosawakens.mixins;

import io.github.chaosawakens.common.blocks.CherryFireBlock;
import io.github.chaosawakens.common.registry.CABlocks;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public abstract class AbstractFireBlockMixin {
    @Inject(at = @At("HEAD"), method = "getState", cancellable = true)
    private static void addCherryFire(IBlockReader reader, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
        BlockPos blockpos = pos.below();
        BlockState blockstate = reader.getBlockState(blockpos);
        if (CherryFireBlock.shouldLightCherryFire(blockstate.getBlock())) {
            cir.cancel();
            cir.setReturnValue(CABlocks.CHERRY_FIRE.get().defaultBlockState());
        }
    }
}
