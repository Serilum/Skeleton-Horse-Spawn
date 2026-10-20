package com.serilum.skeletonhorsespawn.config;

import com.natamus.collective.config.DuskConfig;
import com.serilum.skeletonhorsespawn.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1.0) public static double chanceSurfaceSkeletonHasHorse = 0.05;
	@Entry public static boolean shouldBurnSkeletonHorsesInDaylight = true;
	@Entry public static boolean onlySpawnSkeletonHorsesOnSurface = true;
	@Entry public static boolean skeletonHorsesCanDespawn = true;
	@Entry(registry = "dimension") public static String dimensionsToSpawnIn = "";
	@Entry(registry = "worldgen/biome") public static String biomesToSpawnIn = "";

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
		configMetaData.put("skeletonHorsesCanDespawn", Arrays.asList(
			"If enabled, skeleton horses spawned by the mod despawn like other monsters when no player is near. A horse with a saddle, armor, an owner, a name tag or a lead stays."
		));
		configMetaData.put("dimensionsToSpawnIn", Arrays.asList(
			"Dimensions in which skeletons can spawn riding a skeleton horse, separated by a comma. Leave empty for every dimension. For example: 'minecraft:overworld'."
		));
		configMetaData.put("biomesToSpawnIn", Arrays.asList(
			"Biomes in which skeletons can spawn riding a skeleton horse, separated by a comma. Biome tags work too, starting with a '#'. Leave empty for every biome. For example: 'minecraft:plains,#minecraft:is_savanna'."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}