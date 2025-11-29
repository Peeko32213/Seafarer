package com.barlinc.seafarer.registry.tags;

import com.barlinc.seafarer.Seafarer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SeafarerBlockTags {

    public static final TagKey<Block> GORGONIANS = modBlockTag("gorgonians");
    public static final TagKey<Block> STARFISH = modBlockTag("starfish");
    public static final TagKey<Block> BEACH_PLANT_PLACEABLE = modBlockTag("beach_plant_placeable");
    public static final TagKey<Block> SEA_GLASS = modBlockTag("sea_glass");
    public static final TagKey<Block> SEA_GLASS_PANES = modBlockTag("sea_glass_panes");

    private static TagKey<Block> modBlockTag(String name) {
        return blockTag(Seafarer.MOD_ID, name);
    }

    private static TagKey<Block> forgeBlockTag(String name) {
        return blockTag("forge", name);
    }

    public static TagKey<Block> blockTag(String modid, String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(modid, name));
    }
}
