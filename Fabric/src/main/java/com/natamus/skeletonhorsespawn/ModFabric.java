package com.natamus.skeletonhorsespawn;

import com.natamus.collective.check.RegisterMod;
import com.natamus.skeletonhorsespawn.events.SkeletonHorseEvent;
import com.natamus.skeletonhorsespawn.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		ServerTickEvents.START_WORLD_TICK.register((ServerLevel world) -> {
			SkeletonHorseEvent.onWorldTick(world);
		});

		ServerEntityEvents.ENTITY_LOAD.register((Entity entity, ServerLevel world) -> {
			SkeletonHorseEvent.onEntityJoin(world, entity);
		});
	}

	private static void setGlobalConstants() {

	}
}
