package com.barlinc.seafarer.registry.tags;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SeafarerItemTags {

    public static final TagKey<Item> SEA_GLASS = modItemTag("sea_glass");
    public static final TagKey<Item> SEA_GLASS_PANES = modItemTag("sea_glass_panes");

    public static final TagKey<Item> ROPES = modItemTag("ropes");

    private static TagKey<Item> modItemTag(String name) {
        return itemTag(Seafarer.MOD_ID, name);
    }

    private static TagKey<Item> forgeItemTag(String name) {
        return itemTag("forge", name);
    }

    public static TagKey<Item> itemTag(String modid, String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(modid, name));
    }
}
