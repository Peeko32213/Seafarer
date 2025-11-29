package com.barlinc.seafarer.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class LargeLakeFeatureConfig implements FeatureConfiguration {

    public static final Codec<LargeLakeFeatureConfig> CODEC = RecordCodecBuilder.create((lakeConfig) -> lakeConfig.group(
            BlockStateProvider.CODEC.fieldOf("fluid").forGetter(config -> config.fluid),
            BlockStateProvider.CODEC.fieldOf("barrier").forGetter(config -> config.barrier))
            .apply(lakeConfig, LargeLakeFeatureConfig::new)
    );

    public final BlockStateProvider fluid;
    public final BlockStateProvider barrier;

    public LargeLakeFeatureConfig(BlockStateProvider fluid, BlockStateProvider barrier) {
        this.fluid = fluid;
        this.barrier = barrier;
    }
}
