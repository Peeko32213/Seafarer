package com.barlinc.seafarer.registry.worldgen;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.*;

public class SeafarerBiomes {

    public static final ResourceKey<Biome> FLOWERING_BEACH = createKey("flowering_beach");
    public static final ResourceKey<Biome> GLASS_BEACH = createKey("glass_beach");
    public static final ResourceKey<Biome> VOLCANIC_ISLAND = createKey("volcanic_island");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, Seafarer.modPrefix(name));
    }
}
