package com.barlinc.seafarer;

import net.minecraftforge.common.ForgeConfigSpec;

public class SeafarerConfig {

    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.BooleanValue BIOMES;

    public static ForgeConfigSpec.BooleanValue FLOWERING_BEACH;
    public static ForgeConfigSpec.BooleanValue GLASS_BEACH;
    public static ForgeConfigSpec.BooleanValue VOLCANIC_ISLAND;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.push("Biomes");

        BIOMES = COMMON_BUILDER.comment("Whether any custom biomes are enabled").define("biomes", true);

        FLOWERING_BEACH = COMMON_BUILDER.comment("Whether the flowering beach biome is enabled").define("floweringBeach", true);

        GLASS_BEACH = COMMON_BUILDER.comment("Whether the glass beach biome is enabled").define("glassBeach", true);

        VOLCANIC_ISLAND = COMMON_BUILDER.comment("Whether the volcanic island biome is enabled").define("volcanicBeach", true);

        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

}
