package com.barlinc.seafarer.registry.tags;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class SeafarerBiomeTags {

    public static final TagKey<Biome> HAS_VOLCANOES = modBiomeTag("has_structure/volcano");

    private static TagKey<Biome> modBiomeTag(String name) {
        return biomeTag(Seafarer.MOD_ID, name);
    }

    private static TagKey<Biome> forgeBiomeTag(String name) {
        return biomeTag("forge", name);
    }

    public static TagKey<Biome> biomeTag(String modid, String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(modid, name));
    }
}
