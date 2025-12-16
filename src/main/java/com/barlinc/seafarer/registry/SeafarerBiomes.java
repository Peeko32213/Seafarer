package com.barlinc.seafarer.registry;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class SeafarerBiomes {

    public static final ResourceKey<Biome> VOLCANIC_ISLAND = createKey("volcanic_island");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, Seafarer.modPrefix(name));
    }
}
