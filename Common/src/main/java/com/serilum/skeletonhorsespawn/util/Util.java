package com.serilum.skeletonhorsespawn.util;

import net.minecraft.world.entity.animal.horse.SkeletonHorse;

public class Util {
	public static boolean isUnclaimedModHorse(SkeletonHorse skeletonHorse) {
		if (!skeletonHorse.isTamed() || skeletonHorse.getOwnerUUID() != null) {
			return false;
		}
		return !skeletonHorse.isSaddled();
	}
}
