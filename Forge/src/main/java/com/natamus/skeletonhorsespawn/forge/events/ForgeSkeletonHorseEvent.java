package com.natamus.skeletonhorsespawn.forge.events;

import com.natamus.skeletonhorsespawn.events.SkeletonHorseEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.LevelTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeSkeletonHorseEvent {
	@SubscribeEvent
	public void onEntityJoin(EntityJoinLevelEvent e) {
		SkeletonHorseEvent.onEntityJoin(e.getLevel(), e.getEntity());
	}
	
	@SubscribeEvent
	public void onWorldTick(LevelTickEvent e) {
		Level level = e.level;
		if (level.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}
		
		SkeletonHorseEvent.onWorldTick((ServerLevel)level);
	}
}