package com.barlinc.seafarer.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BaseCoralWallFanBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Optional;

public abstract class WarmCoralFeature extends Feature<NoneFeatureConfiguration> {

    public WarmCoralFeature(Codec<NoneFeatureConfiguration> configuration) {
        super(configuration);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        RandomSource randomsource = context.random();
        WorldGenLevel worldgenlevel = context.level();
        BlockPos blockpos = context.origin();
        Optional<Block> optional = BuiltInRegistries.BLOCK.getTag(BlockTags.CORAL_BLOCKS).flatMap((p_224980_) -> p_224980_.getRandomElement(randomsource)).map(Holder::value);
        return optional.filter(block -> this.placeFeature(worldgenlevel, randomsource, blockpos, block.defaultBlockState())).isPresent();
    }

    protected abstract boolean placeFeature(LevelAccessor p_224966_, RandomSource p_224967_, BlockPos p_224968_, BlockState p_224969_);

    protected boolean placeCoralBlock(LevelAccessor level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = level.getBlockState(pos);
        if ((blockstate.is(Blocks.WATER) || blockstate.is(BlockTags.CORALS)) && level.getBlockState(blockpos).is(Blocks.WATER)) {
            level.setBlock(pos, state, 3);
            if (random.nextFloat() < 0.25F) {
                BuiltInRegistries.BLOCK.getTag(BlockTags.CORALS).flatMap((blockNamed) -> blockNamed.getRandomElement(random)).map(Holder::value).ifPresent((block) -> {
//                    BlockState blockstate1 = block.defaultBlockState();
//                    if (blockstate1.hasProperty(RotatableDoublePlantBlock.FACING)) {
//                        for (Direction direction : Direction.Plane.HORIZONTAL) {
//                            blockstate1 = blockstate1.setValue(RotatableDoublePlantBlock.FACING, direction);
//                        }
//                    }
//                    if (blockstate1.hasProperty(RotatableDoublePlantBlock.HALF)) {
//                        blockstate1.setValue(RotatableDoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
//                    }
                    level.setBlock(blockpos, block.defaultBlockState(), 2);
                });
            } else if (random.nextFloat() < 0.05F) {
                level.setBlock(blockpos, Blocks.SEA_PICKLE.defaultBlockState().setValue(SeaPickleBlock.PICKLES, random.nextInt(4) + 1), 2);
            }

            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (random.nextFloat() < 0.2F) {
                    BlockPos blockpos1 = pos.relative(direction);
                    if (level.getBlockState(blockpos1).is(Blocks.WATER)) {
                        BuiltInRegistries.BLOCK.getTag(BlockTags.WALL_CORALS).flatMap((blockNamed) -> blockNamed.getRandomElement(random)).map(Holder::value).ifPresent((block) -> {
                            BlockState blockstate2 = block.defaultBlockState();
                            if (blockstate2.hasProperty(BaseCoralWallFanBlock.FACING)) {
                                blockstate2 = blockstate2.setValue(BaseCoralWallFanBlock.FACING, direction);
                            }

                            level.setBlock(blockpos1, blockstate2, 2);
                        });
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}