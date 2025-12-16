package com.barlinc.seafarer.worldgen.biome;

import com.barlinc.seafarer.registry.worldgen.SeafarerBiomes;
import com.barlinc.seafarer.registry.SeafarerBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import static net.minecraft.world.level.levelgen.SurfaceRules.*;

public class SeafarerSurfaceRules {

    private static final SurfaceRules.RuleSource VOLCANIC_SAND = makeStateRule(SeafarerBlocks.VOLCANIC_SAND.get());
    private static final SurfaceRules.RuleSource VOLCANIC_SANDSTONE = makeStateRule(SeafarerBlocks.VOLCANIC_SANDSTONE.get());
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);

    private static SurfaceRules.RuleSource getVolcanicIslandRuleSource() {
        SurfaceRules.RuleSource volcanic_island = SurfaceRules.ifTrue(
                SurfaceRules.isBiome(SeafarerBiomes.VOLCANIC_ISLAND),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(65), 0)), beachSandRuleSource(VOLCANIC_SAND, VOLCANIC_SANDSTONE)),
                        SurfaceRules.ifTrue(ON_FLOOR, sequence(ifTrue(noiseRange(1.5F, 2.5F), beachSandRuleSource(VOLCANIC_SAND, VOLCANIC_SANDSTONE)), GRASS_BLOCK)),
                        SurfaceRules.ifTrue(UNDER_FLOOR, DIRT)
                ));
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(SeafarerBiomes.VOLCANIC_ISLAND), volcanic_island);
    }

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.sequence(getVolcanicIslandRuleSource());
    }

    private static RuleSource oceanSandRuleSource(RuleSource sand, RuleSource sandstone) {
        return sequence(
                ifTrue(ON_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand)),
                ifTrue(UNDER_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand))
        );
    }

    private static RuleSource beachSandRuleSource(RuleSource sand, RuleSource sandstone) {
        return sequence(
                ifTrue(ON_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand)),
                ifTrue(UNDER_FLOOR, sequence(ifTrue(ON_CEILING, sandstone), sand))
        );
    }

    private static RuleSource makeStateRule(Block block) {
        return state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double value) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, value / 8.25, Double.MAX_VALUE);
    }

    private static ConditionSource noiseRange(float low, float high) {
        return noiseCondition(Noises.SURFACE, low / 8.25F, high / 8.25F);
    }
}
