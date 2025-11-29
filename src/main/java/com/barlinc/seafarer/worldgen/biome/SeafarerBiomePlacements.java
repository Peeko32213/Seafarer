package com.barlinc.seafarer.worldgen.biome;

import com.barlinc.seafarer.SeafarerConfig;
import com.barlinc.seafarer.registry.worldgen.SeafarerBiomes;
import com.terraformersmc.biolith.api.biome.BiomePlacement;
import com.terraformersmc.biolith.api.biome.SubBiomeMatcher;
import net.minecraft.world.level.biome.Biomes;

public class SeafarerBiomePlacements {

    public static final SubBiomeMatcher.Criterion NEAR_BORDER = SubBiomeMatcher.Criterion.ofMax(SubBiomeMatcher.CriterionTargets.EDGE, SubBiomeMatcher.CriterionTypes.RATIO, 1.25F);

    public static void register() {

        if (SeafarerConfig.FLOWERING_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeafarerBiomes.FLOWERING_BEACH,
                    0.05D
            );
        }

        if (SeafarerConfig.GLASS_BEACH.get()) {
            BiomePlacement.replaceOverworld(
                    Biomes.BEACH,
                    SeafarerBiomes.GLASS_BEACH,
                    0.01D
            );
        }

        if (SeafarerConfig.VOLCANIC_ISLAND.get()) {
            BiomePlacement.addSubOverworld(
                    Biomes.MUSHROOM_FIELDS,
                    SeafarerBiomes.VOLCANIC_ISLAND,
                    SubBiomeMatcher.of(
                            SubBiomeMatcher.Criterion.ofRange(SubBiomeMatcher.CriterionTargets.TEMPERATURE, SubBiomeMatcher.CriterionTypes.VALUE, 0.2F, 1.0F, false)
                    ));
        }
    }
}
