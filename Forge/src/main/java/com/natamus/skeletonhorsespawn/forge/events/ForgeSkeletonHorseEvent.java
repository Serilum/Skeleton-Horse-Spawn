package com.natamus.skeletonhorsespawn.forge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.skeletonhorsespawn.events.SkeletonHorseEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeSkeletonHorseEvent {
	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent e) {
		SkeletonHorseEvent.onEntityJoin(e.getWorld(), e.getEntity());
	}
	
	@SubscribeEvent
	public void onWorldTick(WorldTickEvent e) {
		Level level = e.world;
		if (level.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}
		
		SkeletonHorseEvent.onWorldTick((ServerLevel)level);
	}
}