package com.natamus.skeletonhorsespawn.neoforge.events;

import com.natamus.skeletonhorsespawn.events.SkeletonHorseEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.TickEvent.LevelTickEvent;
import net.neoforged.neoforge.event.TickEvent.Phase;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeSkeletonHorseEvent {
	@SubscribeEvent
	public static void onEntityJoin(EntityJoinLevelEvent e) {
		SkeletonHorseEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
	
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent e) {
		Level level = e.level;
		if (level.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}
		
		SkeletonHorseEvent.onWorldTick((ServerLevel)level);
	}
}