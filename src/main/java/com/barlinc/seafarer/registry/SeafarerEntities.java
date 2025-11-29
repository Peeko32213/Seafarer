package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import com.barlinc.seafarer.entities.*;
import com.barlinc.seafarer.entities.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Seafarer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SeafarerEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Seafarer.MOD_ID);

    public static final RegistryObject<EntityType<HorseshoeCrab>> HORSESHOE_CRAB = ENTITY_TYPES.register(
            "horseshoe_crab", () ->
            EntityType.Builder.of(HorseshoeCrab::new, MobCategory.CREATURE)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "horseshoe_crab").toString())
    );

    public static final RegistryObject<EntityType<Magmaw>> MAGMAW = ENTITY_TYPES.register(
            "magmaw", () ->
            EntityType.Builder.of(Magmaw::new, MobCategory.WATER_CREATURE)
                    .sized(1.2F, 1.3F)
                    .clientTrackingRange(10)
                    .fireImmune()
                    .build(new ResourceLocation(Seafarer.MOD_ID, "magmaw").toString())
    );

    public static final RegistryObject<EntityType<MantaRay>> MANTA_RAY = ENTITY_TYPES.register(
            "manta_ray", () ->
            EntityType.Builder.of(MantaRay::new, MobCategory.WATER_CREATURE)
                    .sized(2.5F, 1.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "manta_ray").toString())
    );

    public static final RegistryObject<EntityType<ShoreCrab>> SHORE_CRAB = ENTITY_TYPES.register(
            "shore_crab", () ->
            EntityType.Builder.of(ShoreCrab::new, MobCategory.CREATURE)
                    .sized(0.7F, 0.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "shore_crab").toString())
    );

    public static final RegistryObject<EntityType<SnakeMackerel>> SNAKE_MACKEREL = ENTITY_TYPES.register(
            "snake_mackerel", () ->
            EntityType.Builder.of(SnakeMackerel::new, MobCategory.WATER_AMBIENT)
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "snake_mackerel").toString())
    );

    public static final RegistryObject<EntityType<Sunfish>> SUNFISH = ENTITY_TYPES.register(
            "sunfish", () ->
            EntityType.Builder.of(Sunfish::new, MobCategory.WATER_CREATURE)
                    .sized(1.5F, 1.98F)
                    .clientTrackingRange(10)
                    .build(new ResourceLocation(Seafarer.MOD_ID, "sunfish").toString())
    );
}
