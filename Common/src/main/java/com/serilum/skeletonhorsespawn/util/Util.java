package com.serilum.skeletonhorsespawn.util;

import net.minecraft.world.entity.animal.equine.SkeletonHorse;

public class Util {
	public static boolean isUnclaimedModHorse(SkeletonHorse skeletonHorse) {
		if (!skeletonHorse.isTamed() || skeletonHorse.getOwnerReference() != null) {
			return false;
		}
		return !skeletonHorse.isSaddled() && !skeletonHorse.isWearingBodyArmor();
	}
}
