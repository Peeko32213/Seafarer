package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SeafarerParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Seafarer.MOD_ID);

    public static final RegistryObject<SimpleParticleType> SMALL_VOLCANIC_SMOKE = PARTICLE_TYPES.register("small_volcanic_smoke", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MEDIUM_VOLCANIC_SMOKE = PARTICLE_TYPES.register("medium_volcanic_smoke", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> BIG_VOLCANIC_SMOKE = PARTICLE_TYPES.register("big_volcanic_smoke", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GIANT_VOLCANIC_SMOKE = PARTICLE_TYPES.register("giant_volcanic_smoke", () -> new SimpleParticleType(false));

}
