package com.natamus.skeletonhorsespawn.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.skeletonhorsespawn.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1.0) public static double chanceSurfaceSkeletonHasHorse = 0.05;
	@Entry public static boolean shouldBurnSkeletonHorsesInDaylight = true;
	@Entry public static boolean onlySpawnSkeletonHorsesOnSurface = true;

	public static void initConfig() {
		configMetaData.put("chanceSurfaceSkeletonHasHorse", Arrays.asList(
			"The chance a skeleton that has spawned on the surface is riding a horse."
		));
		configMetaData.put("shouldBurnSkeletonHorsesInDaylight", Arrays.asList(
			"If enabled, burns skeleton horses when daylight shines upon them."
		));
		configMetaData.put("onlySpawnSkeletonHorsesOnSurface", Arrays.asList(
			"If enabled, a skeleton horse with rider will only spawn on the surface."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}