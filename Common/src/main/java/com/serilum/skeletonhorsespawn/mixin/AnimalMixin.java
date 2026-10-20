package com.serilum.skeletonhorsespawn.mixin;

import com.serilum.skeletonhorsespawn.config.ConfigHandler;
import com.serilum.skeletonhorsespawn.util.Util;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.equine.SkeletonHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Animal.class, priority = 1001)
public class AnimalMixin {
	@Inject(method = "removeWhenFarAway(D)Z", at = @At(value = "HEAD"), cancellable = true)
	public void removeWhenFarAway(double distSqr, CallbackInfoReturnable<Boolean> cir) {
		if (!ConfigHandler.skeletonHorsesCanDespawn) {
			return;
		}

		if (!((Object)this instanceof SkeletonHorse skeletonHorse)) {
			return;
		}

		if (Util.isUnclaimedModHorse(skeletonHorse)) {
			cir.setReturnValue(true);
		}
	}
}
