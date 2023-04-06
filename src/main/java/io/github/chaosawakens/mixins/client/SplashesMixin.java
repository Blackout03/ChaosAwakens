package io.github.chaosawakens.mixins.client;


import net.minecraft.client.util.Splashes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(Splashes.class)
public class SplashesMixin {
	@Nullable
	@Inject(at = @At("HEAD"), method = "getSplash", cancellable = true)
	public void chaosawakens$getSplash(CallbackInfoReturnable<String> callbackInfoReturnable) {
		callbackInfoReturnable.setReturnValue("Happy April Fools!");
	}
}
