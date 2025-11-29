package com.barlinc.seafarer.registry.tags;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class SeafarerEntityTags {

    public static final TagKey<EntityType<?>> COLLIDES_WITH_FISHING_NETS = modEntityTag("collides_with_fishing_nets");

    private static TagKey<EntityType<?>> modEntityTag(String name) {
        return entityTag(Seafarer.MOD_ID, name);
    }

    private static TagKey<EntityType<?>> forgeEntityTag(String name) {
        return entityTag("forge", name);
    }

    public static TagKey<EntityType<?>> entityTag(String modid, String name) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(modid, name));
    }
}
