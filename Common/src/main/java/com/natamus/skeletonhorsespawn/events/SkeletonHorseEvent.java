package com.natamus.skeletonhorsespawn.events;

import com.natamus.collective.functions.BlockPosFunctions;
import com.natamus.collective.functions.HashMapFunctions;
import com.natamus.skeletonhorsespawn.config.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SkeletonHorseEvent {
	private static final HashMap<Level, CopyOnWriteArrayList<Entity>> skeletonhorses_per_world = new HashMap<Level, CopyOnWriteArrayList<Entity>>();
	private static final HashMap<Level, Integer> tickdelay_per_world = new HashMap<Level, Integer>();
	
	public static void onEntityJoin(Level level, Entity entity) {
		if (level.isClientSide) {
			return;
		}
		
		if (entity instanceof SkeletonHorse) {
			if (!HashMapFunctions.computeIfAbsent(skeletonhorses_per_world, level, k -> new CopyOnWriteArrayList<Entity>()).contains(entity)) {
				skeletonhorses_per_world.get(level).add(entity);
			}
		}
	}
	
	public static void onWorldTick(ServerLevel level) {
		int ticks = HashMapFunctions.computeIfAbsent(tickdelay_per_world, level, k -> 1);
		if (ticks % 20 != 0) {
			tickdelay_per_world.put(level, ticks+1);
			return;
		}
		tickdelay_per_world.put(level, 1);
		
		if (!ConfigHandler.shouldBurnSkeletonHorsesInDaylight) {
			return;
		}
		
		if (!level.isDay()) {
			return;
		}
		
		for (Entity skeletonhorse : HashMapFunctions.computeIfAbsent(skeletonhorses_per_world, level, k -> new CopyOnWriteArrayList<Entity>())) {
			if (skeletonhorse.isAlive()) {
				if (!skeletonhorse.isInWaterRainOrBubble()) {
					BlockPos epos = skeletonhorse.blockPosition();
					if (BlockPosFunctions.isOnSurface(level, epos)) {
						skeletonhorse.setSecondsOnFire(3);
					}
				}	
			}
			else {
				skeletonhorses_per_world.get(level).remove(skeletonhorse);
			}		
		}
	}
}