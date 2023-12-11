package com.natamus.skeletonhorsespawn;

import com.natamus.collective.objects.SAMObject;
import com.natamus.skeletonhorsespawn.config.ConfigHandler;
import net.minecraft.world.entity.EntityType;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		new SAMObject(EntityType.SKELETON, EntityType.SKELETON_HORSE, null, ConfigHandler.chanceSurfaceSkeletonHasHorse, false, true, ConfigHandler.onlySpawnSkeletonHorsesOnSurface);
	}
}