package com.barlinc.seafarer.events;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.entities.Clutch;
import com.barlinc.seafarer.entities.Magmaw;
import com.barlinc.seafarer.registry.SeafarerEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(SeafarerEntities.CLUTCH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Clutch::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeafarerEntities.MAGMAW.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Magmaw::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SeafarerEntities.CLUTCH.get(), Clutch.createAttributes().build());
        event.put(SeafarerEntities.MAGMAW.get(), Magmaw.createAttributes().build());
    }
}
