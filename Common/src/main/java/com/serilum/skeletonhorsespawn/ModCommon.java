package com.serilum.skeletonhorsespawn;

import com.natamus.collective.globalcallbacks.ConfigCallback;
import com.natamus.collective.objects.SAMObject;
import com.serilum.skeletonhorsespawn.config.ConfigHandler;
import com.serilum.skeletonhorsespawn.util.Reference;
import net.minecraft.world.entity.EntityType;

public class ModCommon {
	private static SAMObject samObject;

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		samObject = new SAMObject(EntityType.SKELETON, EntityType.SKELETON_HORSE, null, ConfigHandler.chanceSurfaceSkeletonHasHorse, false, true, ConfigHandler.onlySpawnSkeletonHorsesOnSurface, false, false, Integer.MAX_VALUE);
		samObject.dimensionIds = ConfigHandler.dimensionsToSpawnIn;
		samObject.biomeIds = ConfigHandler.biomesToSpawnIn;

		ConfigCallback.CONFIG_CHANGED.register((String modid) -> {
			if (!modid.equals(Reference.MOD_ID)) {
				return;
			}

			samObject.changeChance = ConfigHandler.chanceSurfaceSkeletonHasHorse;
			samObject.onlyOnSurface = ConfigHandler.onlySpawnSkeletonHorsesOnSurface;
			samObject.dimensionIds = ConfigHandler.dimensionsToSpawnIn;
			samObject.biomeIds = ConfigHandler.biomesToSpawnIn;
		});
	}
}