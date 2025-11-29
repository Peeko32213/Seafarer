package com.barlinc.seafarer.events;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.entities.*;
import com.barlinc.seafarer.entities.*;
import com.barlinc.seafarer.registry.SeafarerEntities;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobEvents {

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(SeafarerEntities.HORSESHOE_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HorseshoeCrab::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeafarerEntities.MAGMAW.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Magmaw::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeafarerEntities.MANTA_RAY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MantaRay::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeafarerEntities.SHORE_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ShoreCrab::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeafarerEntities.SNAKE_MACKEREL.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnakeMackerel::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(SeafarerEntities.SUNFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Sunfish::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SeafarerEntities.HORSESHOE_CRAB.get(), HorseshoeCrab.createAttributes().build());
        event.put(SeafarerEntities.MAGMAW.get(), Magmaw.createAttributes().build());
        event.put(SeafarerEntities.MANTA_RAY.get(), MantaRay.createAttributes().build());
        event.put(SeafarerEntities.SHORE_CRAB.get(), ShoreCrab.createAttributes().build());
        event.put(SeafarerEntities.SNAKE_MACKEREL.get(), SnakeMackerel.createAttributes().build());
        event.put(SeafarerEntities.SUNFISH.get(), Sunfish.createAttributes().build());
    }
}
